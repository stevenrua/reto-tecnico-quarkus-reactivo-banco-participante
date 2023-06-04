package pa.com.banco.panama.infrastructure.controllers;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.repositories.BankRepository;
import pa.com.banco.panama.domain.models.Bank;
import java.util.List;

@Path("/banco")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class BankController {
    private final BankRepository bankPort;
    @GET
    public Uni<List<Bank>> listarBancos(){
        return bankPort.listarBancos();
    }

    @GET
    @Path("/{id}")
    public Uni<Bank> buscarBancoPorId(@PathParam("id") Long id){
        return bankPort.buscarBancoPorId(id);
    }

    @POST
    public Uni<Bank> guardarBanco(Bank bank){
        return bankPort.guardarBanco(bank);
    }

    @PUT
    @Path("/{id}")
    public Uni<Bank> actualizarBanco(@PathParam("id") Long id, Bank bank){
        return bankPort.actualizarBanco(id, bank);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Void> borrarBanco(@PathParam("id") Long id){
        return bankPort.borrarBanco(id);
    }
}
