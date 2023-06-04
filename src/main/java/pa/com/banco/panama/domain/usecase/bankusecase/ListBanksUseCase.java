package pa.com.banco.panama.domain.usecase.bankusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Bank;
import pa.com.banco.panama.domain.repositories.BankRepository;
import java.util.List;

@RequiredArgsConstructor
public class ListBanksUseCase {

    private final BankRepository bankRepository;

    public Uni<List<Bank>> listarBancos() {
        return bankRepository.listarBancos();
    }

}
