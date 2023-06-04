package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
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
                        throw new WebApplicationException("ERR-US00: Lista de estados sin contenido");
                    }
                    return listaEstados;
                });
    }

    @Override
    @WithSession
    public Uni<UserState> buscarEstadoUsuarioPorId(Long id) {
        return sqlUserStateRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-US01: Estado con ese id no encontrado"))
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
                .onItem().ifNull().failWith(new WebApplicationException("ERR-US01: Estado con ese id no encontrado"))
                .flatMap(sqlUserStateRepository::delete);
    }
}
