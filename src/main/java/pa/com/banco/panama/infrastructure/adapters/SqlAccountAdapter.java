package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.errorenum.ErrorCode;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.domain.repositories.AccountRepository;
import pa.com.banco.panama.domain.repositories.BankRepository;
import pa.com.banco.panama.infrastructure.entities.AccountEntity;
import pa.com.banco.panama.infrastructure.repository.SqlAccountRepository;
import pa.com.banco.panama.infrastructure.repository.SqlBankRepository;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlAccountAdapter implements AccountRepository {
    private final SqlAccountRepository sqlAccountRepository;
    private final BankRepository bankRepository;
    @Override
    @WithTransaction
    public Uni<Account> buscarCuentaPorIdBanco(Long idBanco) {
        return sqlAccountRepository.findByIdBanco(idBanco)
                .onItem().ifNull().failWith(new WebApplicationException("No se encontre cuenta con id de de ese banco"))
                .map(accountEntity -> Account.builder()
                        .idCuenta(accountEntity.getIdBanco())
                        .numeroCuenta(accountEntity.getNumeroCuenta())
                        .idBanco(accountEntity.getIdBanco())
                        .build());
    }

    @Override
    @WithSession
    public Uni<Account> buscarCuentaPorNumeroCuenta(String numeroCuenta) {
        return sqlAccountRepository.findByNumeroCuenta(numeroCuenta)
                .onItem().ifNull().failWith(new WebApplicationException("No se encontre cuenta con ese numero de cuenta"))
                .map(accountEntity -> Account.builder()
                        .idCuenta(accountEntity.getIdCuenta())
                        .numeroCuenta(accountEntity.getNumeroCuenta())
                        .idBanco(accountEntity.getIdBanco())
                        .build());
    }

    @Override
    @WithTransaction
    @WithSession
    public Uni<Account> guardarCuenta(Account account) {
        return bankRepository.buscarBancoPorId(account.getIdBanco())
                .flatMap(bank -> {
                    return sqlAccountRepository.findByIdBanco(account.getIdBanco())
                            .onItem().ifNotNull().failWith(new WebApplicationException(ErrorCode.ERROR_ACC00_BANK_REGISTERED.getMessage()))
                            .flatMap(account1 -> {
                                return sqlAccountRepository.findByNumeroCuenta(account.getNumeroCuenta())
                                        .onItem().ifNotNull().failWith(new WebApplicationException(ErrorCode.ERROR_ACC01_NUMBER_ACCOUNT_REGISTERED.getMessage()))
                                        .flatMap(ignore -> {
                                            return sqlAccountRepository.persist(AccountEntity.builder()
                                                            .numeroCuenta(account.getNumeroCuenta())
                                                            .idBanco(account.getIdBanco())
                                                            .build())
                                                    .map(accountEntity -> Account.builder()
                                                            .idCuenta(accountEntity.getIdCuenta())
                                                            .numeroCuenta(accountEntity.getNumeroCuenta())
                                                            .idBanco(accountEntity.getIdBanco())
                                                            .build());
                                        });
                            });
                });
        /*return sqlAccountRepository.persist(AccountEntity.builder()
                .numeroCuenta(account.getNumeroCuenta())
                        .idBanco(account.getIdBanco())
                        .build())
                .map(accountEntity -> Account.builder()
                        .idCuenta(accountEntity.getIdCuenta())
                        .numeroCuenta(accountEntity.getNumeroCuenta())
                        .idBanco(accountEntity.getIdBanco())
                        .build());*/
    }
}
