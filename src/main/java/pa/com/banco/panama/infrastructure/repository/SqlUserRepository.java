package pa.com.banco.panama.infrastructure.repository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import pa.com.banco.panama.infrastructure.entities.UserEntity;

@ApplicationScoped
public class SqlUserRepository implements PanacheRepositoryBase<UserEntity, Long> {
    public Uni<UserEntity> findByAlias(String alias){
        return find("alias", alias).firstResult();
    }
}
