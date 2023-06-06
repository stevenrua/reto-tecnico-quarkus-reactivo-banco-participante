package pa.com.banco.panama.domain.usecase.userusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.User;
import pa.com.banco.panama.domain.repositories.UserRepository;

@RequiredArgsConstructor
public class SaveUserUseCase {
    private final UserRepository userRepository;
    public Uni<User> guardarUsuario(User user) {
        return userRepository.guardarUsuario(user);
    }
}
