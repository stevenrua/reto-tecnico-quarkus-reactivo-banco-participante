package pa.com.banco.panama.domain.usecase.accountusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.domain.repositories.AccountRepository;

@RequiredArgsConstructor
public class SaveAccountUseCase {
    private final AccountRepository accountRepository;
    public Uni<Account> guardarCuenta(Account account){
        return accountRepository.guardarCuenta(account);
    }
}
