package pa.com.banco.panama.application.configuration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;
import pa.com.banco.panama.domain.repositories.BankRepository;
import pa.com.banco.panama.domain.repositories.CountryRepository;
import pa.com.banco.panama.domain.usecase.aliastypeusecase.DeleteAliasTypeUseCase;
import pa.com.banco.panama.domain.usecase.aliastypeusecase.GetAliasTypeUseCase;
import pa.com.banco.panama.domain.usecase.aliastypeusecase.ListAliasTypeUseCase;
import pa.com.banco.panama.domain.usecase.aliastypeusecase.SaveAliasTypeUseCase;
import pa.com.banco.panama.domain.usecase.bankusecase.*;
import pa.com.banco.panama.domain.usecase.countryusecase.DeleteCountryUseCase;
import pa.com.banco.panama.domain.usecase.countryusecase.GetByCountryCodeUseCase;
import pa.com.banco.panama.domain.usecase.countryusecase.ListCountriesUseCase;
import pa.com.banco.panama.domain.usecase.countryusecase.SaveCountryUseCase;

@ApplicationScoped
public class BeanConfig {
    @Produces
    public ListBanksUseCase listBanksUseCase(BankRepository bankRepository){
        return new ListBanksUseCase(bankRepository);
    }

    @Produces
    public SaveBankUseCase saveBankUseCase(BankRepository bankRepository){
        return new SaveBankUseCase(bankRepository);
    }

    @Produces
    public GetBankById getBankById(BankRepository bankRepository){
        return new GetBankById(bankRepository);
    }

    @Produces
    public UpdatedBankUseCase updatedBankUseCase(BankRepository bankRepository){
        return new UpdatedBankUseCase(bankRepository);
    }

    @Produces
    public DeleteBankUseCase deleteBankUseCase(BankRepository bankRepository){
        return new DeleteBankUseCase(bankRepository);
    }

    //USecase Pais
    @Produces
    public ListCountriesUseCase listCountriesUseCase(CountryRepository countryRepository){
        return new ListCountriesUseCase(countryRepository);
    }
    @Produces
    public GetByCountryCodeUseCase getByCountryCodeUseCase(CountryRepository countryRepository){
        return new GetByCountryCodeUseCase(countryRepository);
    }
    @Produces
    public SaveCountryUseCase saveBankUseCase(CountryRepository countryRepository){
        return new SaveCountryUseCase(countryRepository);
    }
    @Produces
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository countryRepository){
        return new DeleteCountryUseCase(countryRepository);
    }

    @Produces
    public ListAliasTypeUseCase listAliasTypeUseCase(AliasTypeRepository aliasTypeRepository){
        return new ListAliasTypeUseCase(aliasTypeRepository);
    }
    @Produces
    public GetAliasTypeUseCase getAliasTypeUseCase(AliasTypeRepository aliasTypeRepository){
        return new GetAliasTypeUseCase(aliasTypeRepository);
    }
    @Produces
    public SaveAliasTypeUseCase saveAliasTypeUseCase(AliasTypeRepository aliasTypeRepository){
        return new SaveAliasTypeUseCase(aliasTypeRepository);
    }
    @Produces
    public DeleteAliasTypeUseCase deleteAliasTypeUseCase(AliasTypeRepository aliasTypeRepository){
        return new DeleteAliasTypeUseCase(aliasTypeRepository);
    }
}
