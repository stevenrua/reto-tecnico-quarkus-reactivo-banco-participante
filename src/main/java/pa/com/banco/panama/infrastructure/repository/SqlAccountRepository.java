package pa.com.banco.panama.infrastructure.repository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.infrastructure.entities.AccountEntity;

@ApplicationScoped
public class SqlAccountRepository implements PanacheRepositoryBase<AccountEntity, Long> {
    public Uni<AccountEntity> findByIdBanco(Long idBanco){
        return find("idBanco", idBanco).firstResult();
    }
    public Uni<AccountEntity> findByNumeroCuenta(String numeroCuenta){
        return find("numeroCuenta", numeroCuenta).firstResult();
    }
}
