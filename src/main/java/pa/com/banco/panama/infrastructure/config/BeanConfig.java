package pa.com.banco.panama.infrastructure.config;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import pa.com.banco.panama.application.ports.BankPort;
import pa.com.banco.panama.application.usecase.BankUSeCase;
import pa.com.banco.panama.domain.repositories.BankRepository;

@ApplicationScoped
public class BeanConfig {
    @Produces
    public BankPort bankPort(BankRepository bankRepository){
        return new BankUSeCase(bankRepository);
    }
}
