package pa.com.banco.panama.infrastructure.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.User;
import pa.com.banco.panama.domain.repositories.UserRepository;

@Path("/usuario")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserRepository userRepository;
    @POST
    public Uni<User> guardarUsuario(User user){
        return userRepository.guardarUsuario(user);
    }
}
