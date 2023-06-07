package pa.com.banco.panama.infrastructure.controllers;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.UserState;
import pa.com.banco.panama.domain.usecase.userstateusecase.DeleteUserStateUseCase;
import pa.com.banco.panama.domain.usecase.userstateusecase.GetUserStateUseCase;
import pa.com.banco.panama.domain.usecase.userstateusecase.ListUserStateUSeCase;
import pa.com.banco.panama.domain.usecase.userstateusecase.SaveUserStateUseCase;

import java.util.List;

@Path("/estado")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserStateController {
    private final ListUserStateUSeCase listUserStateUSeCase;
    private final GetUserStateUseCase getUserStateUseCase;
    private final SaveUserStateUseCase saveUserStateUseCase;
    private final DeleteUserStateUseCase deleteUserStateUseCase;
    @GET
    public Uni<List<UserState>> listarEstadoUsuario(){
        return listUserStateUSeCase.listarEstadoUsuario();
    }
    @GET
    @Path("/{id}")
    public Uni<UserState> buscarEstadoUsuarioPorId(Long id){
        return getUserStateUseCase.buscarEstadoUsuarioPoId(id);
    }
    @POST
    public Uni<UserState> guardarEstadoUsuario(UserState userState){
        return saveUserStateUseCase.guardarEstadoUsuario(userState);
    }
    @DELETE
    @Path("/{id}")
    public Uni<Void> borrarEstadoUsuario(Long id){
        return deleteUserStateUseCase.borrarEstadoUsuario(id);
    }
}
