package pa.com.banco.panama.domain.usecase.bankusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.repositories.BankRepository;

@RequiredArgsConstructor
public class DeleteBankUseCase {

    private final BankRepository bankRepository;

    public Uni<Void> borrarBanco(Long id) {
        return bankRepository.borrarBanco(id);
    }

}
