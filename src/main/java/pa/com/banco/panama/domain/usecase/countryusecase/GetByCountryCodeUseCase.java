package pa.com.banco.panama.domain.usecase.countryusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Country;
import pa.com.banco.panama.domain.repositories.CountryRepository;

@RequiredArgsConstructor
public class GetByCountryCodeUseCase {
    private final CountryRepository countryRepository;

    public Uni<Country> buscarPorCodigoPais(Long codigoPais) {
        return countryRepository.buscarPorCodigoPais(codigoPais);
    }
}
