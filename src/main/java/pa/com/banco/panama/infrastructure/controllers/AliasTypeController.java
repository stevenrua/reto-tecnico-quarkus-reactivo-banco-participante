package pa.com.banco.panama.infrastructure.controllers;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.AliasType;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;
import java.util.List;

@Path("/tipoalias")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class AliasTypeController {
    private final AliasTypeRepository aliasTypeRepository;

    @GET
    public Uni<List<AliasType>> listarTipoAlias(){
        return aliasTypeRepository.listarTiposAlias();
    }
    @GET
    @Path("/{id}")
    public Uni<AliasType> buscarTipoAliasPorId(@PathParam("id") Long id){
        return aliasTypeRepository.buscarTipoAliasPorId(id);
    }
    @POST
    public Uni<AliasType> guardarTipoAlias(AliasType aliasType){
        return aliasTypeRepository.guardarTipoAlias(aliasType);
    }
    @DELETE
    @Path("/{id}")
    public Uni<Void> borrarTipoAlias(@PathParam(("id")) Long id){
        return aliasTypeRepository.borrarTipoAlias(id);
    }
}
