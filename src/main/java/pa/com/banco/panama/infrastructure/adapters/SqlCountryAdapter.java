package pa.com.banco.panama.infrastructure.adapters;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
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
                        throw new WebApplicationException("ERR-C00: Lista de pais sin contenido");
                    }
                    return listaPaises;
                });
    }

    @Override
    @WithSession
    public Uni<Country> buscarPorCodigoPais(Long codigoPais) {
        return sqlCountryRepository.findById(codigoPais)
                .onItem().ifNull().failWith(new WebApplicationException("ERR-C01: País con ese id no encontrado"))
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
                .onItem().ifNull().failWith(new WebApplicationException("ERR-C01: País con ese id no encontrado"))
                .flatMap(countryEntity -> {
                    return sqlCountryRepository.delete(countryEntity);
                });
    }
}
