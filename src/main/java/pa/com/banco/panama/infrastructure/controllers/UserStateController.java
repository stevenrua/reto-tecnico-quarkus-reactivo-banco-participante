package pa.com.banco.panama.infrastructure.controllers;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.UserState;
import pa.com.banco.panama.domain.repositories.UserStateRepository;
import java.util.List;

@Path("/estado")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class UserStateController {
    private final UserStateRepository userStateRepository;
    @GET
    public Uni<List<UserState>> listarEstadoUsuario(){
        return userStateRepository.listarEstadoUsuario();
    }
    @GET
    @Path("/{id}")
    public Uni<UserState> buscarEstadoUsuarioPorId(Long id){
        return userStateRepository.buscarEstadoUsuarioPorId(id);
    }
    @POST
    public Uni<UserState> guardarEstadoUsuario(UserState userState){
        return userStateRepository.guardarEstadoUsuario(userState);
    }
    @DELETE
    @Path("/{id}")
    public Uni<Void> borrarEstadoUsuario(Long id){
        return userStateRepository.borrarEstadoUsuario(id);
    }
}
