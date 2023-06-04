package pa.com.banco.panama.domain.usecase.userstateusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.repositories.UserStateRepository;

@RequiredArgsConstructor
public class DeleteUserStateUseCase {
    private final UserStateRepository userStateRepository;
    public Uni<Void> borrarEstadoUsuario(Long id) {
        return userStateRepository.borrarEstadoUsuario(id);
    }
}
