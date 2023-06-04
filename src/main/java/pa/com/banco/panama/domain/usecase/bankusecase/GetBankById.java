package pa.com.banco.panama.domain.usecase.bankusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Bank;
import pa.com.banco.panama.domain.repositories.BankRepository;

@RequiredArgsConstructor
public class GetBankById {

    private final BankRepository bankRepository;

    public Uni<Bank> buscarBancoPorId(Long id) {
        return bankRepository.buscarBancoPorId(id);
    }

}
