package pa.com.banco.panama.infrastructure.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Country;
import pa.com.banco.panama.domain.repositories.CountryRepository;

import java.util.List;

@Path("/pais")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class CountryController {
    private final CountryRepository countryRepository;
    @GET
    public Uni<List<Country>> listarPaises(){
        return countryRepository.listarPaises();
    }
    @GET
    @Path("/{codigopais}")
    public Uni<Country> buscarPorCodigoPais(@PathParam("codigopais") Long codigoPais){
        return countryRepository.buscarPorCodigoPais(codigoPais);
    }
    @POST
    public Uni<Country> guardarPais(Country country){
        return countryRepository.guardarPais(country);
    }
    @DELETE
    @Path("/{codigopais}")
    public Uni<Void> borrarPais(@PathParam("codigopais") Long codigoPais){
        return countryRepository.borrarPais(codigoPais);
    }
}
