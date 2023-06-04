package pa.com.banco.panama.domain.usecase.countryusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.repositories.CountryRepository;

@RequiredArgsConstructor
public class DeleteCountryUseCase {
    private final CountryRepository countryRepository;

    public Uni<Void> borrarPais(Long codigoPais) {
        return countryRepository.borrarPais(codigoPais);
    }
}
