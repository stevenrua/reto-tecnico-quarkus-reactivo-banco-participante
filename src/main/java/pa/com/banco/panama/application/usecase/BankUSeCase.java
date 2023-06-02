package pa.com.banco.panama.application.usecase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.application.ports.BankPort;
import pa.com.banco.panama.domain.models.Bank;
import pa.com.banco.panama.domain.repositories.BankRepository;
import java.util.List;

@RequiredArgsConstructor
//@ApplicationScoped
public class BankUSeCase implements BankPort{
    private final BankRepository bankRepository;

    @Override
    public Uni<List<Bank>> listarBancos() {
        return bankRepository.listarBancos();
    }

    @Override
    public Uni<Bank> buscarBancoPorId(Long id) {
        return bankRepository.buscarBancoPorId(id);
    }

    @Override
    public Uni<Bank> guardarBanco(Bank bank) {
        return bankRepository.guardarBanco(bank);
    }

    @Override
    public Uni<Bank> actualizarBanco(Long id, Bank bank) {
        return bankRepository.actualizarBanco(id, bank);
    }

    @Override
    public Uni<Void> borrarBanco(Long id) {
        return null;
    }
}
