package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.AliasType;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;
import pa.com.banco.panama.infrastructure.entities.AliasTypeEntity;
import pa.com.banco.panama.infrastructure.repository.SqlAliasTypeRepository;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlAliasTypeAdapter implements AliasTypeRepository {
    private final SqlAliasTypeRepository sqlAliasTypeRepository;
    @Override
    @WithSession
    public Uni<List<AliasType>> listarTiposAlias() {
        return sqlAliasTypeRepository.listAll()
                .map(aliasTypeEntities -> aliasTypeEntities.stream()
                        .map(aliasTypeEntity -> AliasType.builder()
                                .idTipoAlias(aliasTypeEntity.getIdTipoAlias())
                                .descripcion(aliasTypeEntity.getDescripcion())
                                .build())
                        .collect(Collectors.toList()))
                .map(listaBancos ->{
                    if (listaBancos.isEmpty()) {
                        throw new WebApplicationException("ERR-AT00: Lista de tipo alias sin contenido");
                    }
                    return listaBancos;
                });
    }
    @Override
    @WithSession
    public Uni<AliasType> buscarTipoAliasPorId(Long id) {
        return sqlAliasTypeRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-AT01: Tipo Alias con ese id no encontrado"))
                .map(aliasTypeEntity -> AliasType.builder()
                        .idTipoAlias(aliasTypeEntity.getIdTipoAlias())
                        .descripcion(aliasTypeEntity.getDescripcion())
                        .build());
    }

    @Override
    @WithTransaction
    public Uni<AliasType> guardarTipoAlias(AliasType aliasType) {
        return sqlAliasTypeRepository.persist(AliasTypeEntity.builder()
                        .descripcion(aliasType.getDescripcion())
                        .build())
                .map(aliasTypeEntity -> AliasType.builder()
                        .idTipoAlias(aliasTypeEntity.getIdTipoAlias())
                        .descripcion(aliasTypeEntity.getDescripcion())
                        .build());
    }

    @Override
    @WithSession
    @WithTransaction
    public Uni<Void> borrarTipoAlias(Long id) {
        return sqlAliasTypeRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-AT01: Tipo Alias con ese id no encontrado"))
                .flatMap(sqlAliasTypeRepository::delete);
    }
}
