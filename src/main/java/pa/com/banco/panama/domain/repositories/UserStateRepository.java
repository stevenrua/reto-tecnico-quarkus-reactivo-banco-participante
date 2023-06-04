package pa.com.banco.panama.domain.repositories;
import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.UserState;
import java.util.List;

public interface UserStateRepository {
    Uni<List<UserState>> listarEstadoUsuario();
    Uni<UserState> buscarEstadoUsuarioPorId(Long id);
    Uni<UserState> guardarEstadoUsuario(UserState userState);
    Uni<Void> borrarEstadoUsuario(Long id);
}
