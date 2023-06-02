package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Bank;
import pa.com.banco.panama.domain.repositories.BankRepository;
import pa.com.banco.panama.infrastructure.entities.BankEntity;
import pa.com.banco.panama.infrastructure.repository.SqlBankRepository;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlBankAdapter implements BankRepository {
    private final SqlBankRepository sqlBankRepository;
    @Override
    @WithSession
    public Uni<List<Bank>> listarBancos() {
        return sqlBankRepository.listAll()
                .map(bankEntities -> bankEntities.stream()
                        .map(bankEntity -> Bank.builder()
                                .id(bankEntity.getId())
                                .nombreBanco(bankEntity.getNombreBanco())
                                .build())
                        .collect(Collectors.toList()))
                .map(listaBancos ->{
                    if (listaBancos.isEmpty()) {
                        throw new WebApplicationException("ERR-00: Lista de banco sin contenido");
                    }
                    return listaBancos;
                });
    }
    @Override
    @WithSession
    public Uni<Bank> buscarBancoPorId(Long id) {
        return sqlBankRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-01: Banco con ese id no encontrado"))
                .map(bankEntity -> Bank.builder()
                        .id(bankEntity.getId())
                        .nombreBanco(bankEntity.getNombreBanco())
                        .build());
    }

    @Override
    @WithTransaction
    public Uni<Bank> guardarBanco(Bank bank) {
        return sqlBankRepository.persist(BankEntity.builder()
                        .nombreBanco(bank.getNombreBanco())
                .build())
                .map(bankEntity -> Bank.builder()
                        .id(bankEntity.getId())
                        .nombreBanco(bankEntity.getNombreBanco())
                        .build());
    }

    @Override
    @WithSession
    @WithTransaction
    public Uni<Bank> actualizarBanco(Long id, Bank bank) {
        return sqlBankRepository.findById(id)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-01: Banco con ese id no encontrado"))
                .flatMap(bankEntity -> {
                    bankEntity.setNombreBanco(bank.getNombreBanco());
                    return sqlBankRepository.persist(bankEntity)
                            .map(entity -> Bank.builder()
                                    .id(entity.getId())
                                    .nombreBanco(entity.getNombreBanco())
                                    .build());
                });
    }

    @Override
    public Uni<Void> borrarBanco(Long id) {
        return null;
    }
}