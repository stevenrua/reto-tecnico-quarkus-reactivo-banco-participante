package pa.com.banco.panama.infrastructure.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import pa.com.banco.panama.infrastructure.entities.AliasTypeEntity;

@ApplicationScoped
public class SqlAliasTypeRepository implements PanacheRepositoryBase<AliasTypeEntity, Long> {
}
