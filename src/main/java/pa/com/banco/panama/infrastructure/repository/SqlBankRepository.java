package pa.com.banco.panama.infrastructure.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import pa.com.banco.panama.infrastructure.entities.BankEntity;
@ApplicationScoped
//@Transactional
public class SqlBankRepository implements PanacheRepositoryBase<BankEntity, Long> {
}
