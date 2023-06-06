package pa.com.banco.panama.domain.repositories;
import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.User;

public interface UserRepository {
    Uni<User> guardarUsuario(User user);
}
