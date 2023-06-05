package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.errorenum.ErrorCode;
import pa.com.banco.panama.domain.models.UserState;
import pa.com.banco.panama.domain.repositories.UserStateRepository;
import pa.com.banco.panama.infrastructure.entities.UserStateEntity;
import pa.com.banco.panama.infrastructure.repository.SqlUserStateRepository;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlUserStateAdapter implements UserStateRepository {
    private final SqlUserStateRepository sqlUserStateRepository;
    @Override
    @WithSession
    public Uni<List<UserState>> listarEstadoUsuario() {
        return sqlUserStateRepository.listAll()
                .map(userStateEntities -> userStateEntities.stream()
                        .map(userStateEntity -> UserState.builder()
                                .idEstado(userStateEntity.getIdEstado())
                                .nombre(userStateEntity.getNombre())
                                .build())
                        .collect(Collectors.toList()))
                .map(listaEstados ->{
                    if (listaEstados.isEmpty()) {
                        throw new WebApplicationException(ErrorCode.ERROR_US00_LIST_USER_STATE_EMPTY.getMessage());
                    }
                    return listaEstados;
                });
    }

    @Override
    @WithSession
    public Uni<UserState> buscarEstadoUsuarioPorId(Long id) {
        return sqlUserStateRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException(ErrorCode.ERROR_US01_USER_STATE_NOT_FOUND.getMessage()))
                .map(userStateEntity -> UserState.builder()
                        .idEstado(userStateEntity.getIdEstado())
                        .nombre(userStateEntity.getNombre())
                        .build());
    }

    @Override
    @WithTransaction
    public Uni<UserState> guardarEstadoUsuario(UserState userState) {
        return sqlUserStateRepository.persist(UserStateEntity.builder()
                .nombre(userState.getNombre())
                .build())
                .map(userStateEntity -> UserState.builder()
                        .idEstado(userStateEntity.getIdEstado())
                        .nombre(userStateEntity.getNombre())
                        .build());
    }

    @Override
    @WithSession
    @WithTransaction
    public Uni<Void> borrarEstadoUsuario(Long id) {
        return sqlUserStateRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException(ErrorCode.ERROR_US01_USER_STATE_NOT_FOUND.getMessage()))
                .flatMap(sqlUserStateRepository::delete);
    }
}
