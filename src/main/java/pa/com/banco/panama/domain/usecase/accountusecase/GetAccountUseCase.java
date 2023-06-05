package pa.com.banco.panama.domain.usecase.accountusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.domain.repositories.AccountRepository;

@RequiredArgsConstructor
public class GetAccountUseCase {
    private final AccountRepository accountRepository;
    public Uni<Account> buscarCuentaPorIdBanco(Long idBanco){
        return accountRepository.buscarCuentaPorIdBanco(idBanco);
    }
}
