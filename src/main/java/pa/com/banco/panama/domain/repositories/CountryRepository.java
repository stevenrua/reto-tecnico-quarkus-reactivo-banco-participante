package pa.com.banco.panama.domain.repositories;

import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.Country;

import java.util.List;

public interface CountryRepository {
    Uni<List<Country>> listarPaises();
    Uni<Country> buscarPorCodigoPais(Long codigoPais);
    Uni<Country> guardarPais(Country country);
    Uni<Void> borrarPais(Long codigoPais);
}
