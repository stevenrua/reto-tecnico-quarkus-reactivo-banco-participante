package pa.com.banco.panama.domain.usecase.countryusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Country;
import pa.com.banco.panama.domain.repositories.CountryRepository;
import java.util.List;

@RequiredArgsConstructor
public class ListCountriesUseCase {
    private final CountryRepository countryRepository;

    public Uni<List<Country>> listarBancos() {
        return countryRepository.listarPaises();
    }
}
