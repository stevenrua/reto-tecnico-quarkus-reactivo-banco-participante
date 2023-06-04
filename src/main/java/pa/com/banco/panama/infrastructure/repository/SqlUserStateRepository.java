package pa.com.banco.panama.infrastructure.repository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import pa.com.banco.panama.infrastructure.entities.UserStateEntity;

@ApplicationScoped
public class SqlUserStateRepository implements PanacheRepositoryBase<UserStateEntity, Long> {
}
