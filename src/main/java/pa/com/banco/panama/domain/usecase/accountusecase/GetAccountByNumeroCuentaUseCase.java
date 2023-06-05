package pa.com.banco.panama.domain.usecase.accountusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.domain.repositories.AccountRepository;

@RequiredArgsConstructor
public class GetAccountByNumeroCuentaUseCase {
    private final AccountRepository accountRepository;
    public Uni<Account> buscarCuentaPorNumeroCuenta(String numeroCuenta){
        return accountRepository.buscarCuentaPorNumeroCuenta(numeroCuenta);
    }
}
