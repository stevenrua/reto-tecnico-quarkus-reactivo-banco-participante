package pa.com.banco.panama.domain.repositories;
import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.Account;

public interface AccountRepository {
    Uni<Account> buscarCuentaPorIdBanco(Long idBanco);
    Uni<Account> buscarCuentaPorNumeroCuenta(String numeroCuenta);

    Uni<Account> guardarCuenta(Account account);
}
