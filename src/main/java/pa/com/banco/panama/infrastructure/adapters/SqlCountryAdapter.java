package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.errorenum.ErrorCode;
import pa.com.banco.panama.domain.exceptions.MyExceptions;
import pa.com.banco.panama.domain.models.Country;
import pa.com.banco.panama.domain.repositories.CountryRepository;
import pa.com.banco.panama.infrastructure.entities.CountryEntity;
import pa.com.banco.panama.infrastructure.repository.SqlCountryRepository;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlCountryAdapter implements CountryRepository {
    private final SqlCountryRepository sqlCountryRepository;
    @Override
    @WithSession
    public Uni<List<Country>> listarPaises() {
        return sqlCountryRepository.listAll()
                .map(countryEntities -> countryEntities.stream()
                        .map(countryEntity -> Country.builder()
                                .codigoPais(countryEntity.getCodigoPais())
                                .nombrePais(countryEntity.getNombrePais())
                                .indicativoMovil(countryEntity.getIndicativoMovil())
                                .build())
                        .collect(Collectors.toList()))
                .map(listaPaises ->{
                    if (listaPaises.isEmpty()) {
                        throw new MyExceptions(ErrorCode.ERROR_C00_LIST_COUNTRY_EMPTY.getMessage());
                    }
                    return listaPaises;
                });
    }

    @Override
    @WithSession
    public Uni<Country> buscarPorCodigoPais(Long codigoPais) {
        return sqlCountryRepository.findById(codigoPais)
                .onItem().ifNull().failWith(new MyExceptions(ErrorCode.ERROR_C01_COUNTRY_NOT_FOUND.getMessage()))
                .map(countryEntity -> Country.builder()
                        .codigoPais(countryEntity.getCodigoPais())
                        .nombrePais(countryEntity.getNombrePais())
                        .indicativoMovil(countryEntity.getIndicativoMovil())
                        .build());
    }

    @Override
    @WithTransaction
    public Uni<Country> guardarPais(Country country) {
        return sqlCountryRepository.persist(CountryEntity.builder()
                        .nombrePais(country.getNombrePais())
                        .indicativoMovil(country.getIndicativoMovil())
                        .build())
                .map(countryEntity -> Country.builder()
                        .codigoPais(countryEntity.getCodigoPais())
                        .nombrePais(countryEntity.getNombrePais())
                        .indicativoMovil(countryEntity.getIndicativoMovil())
                        .build());
    }

    @Override
    @WithTransaction
    @WithSession
    public Uni<Void> borrarPais(Long codigoPais) {
        return sqlCountryRepository.findById(codigoPais)
                .onItem().ifNull().failWith(new MyExceptions(ErrorCode.ERROR_C01_COUNTRY_NOT_FOUND.getMessage()))
                .flatMap(sqlCountryRepository::delete);
    }
}
