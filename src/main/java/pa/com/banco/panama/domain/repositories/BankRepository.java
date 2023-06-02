package pa.com.banco.panama.domain.repositories;

import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.Bank;

import java.util.List;

public interface BankRepository {
    Uni<List<Bank>> listarBancos();
    Uni<Bank> buscarBancoPorId(Long id);
    Uni<Bank> guardarBanco(Bank bank);
    Uni<Bank> actualizarBanco(Long id, Bank bank);
    Uni<Void> borrarBanco(Long id);
}
