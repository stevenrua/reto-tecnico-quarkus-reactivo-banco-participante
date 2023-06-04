package pa.com.banco.panama.domain.usecase.userstateusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.UserState;
import pa.com.banco.panama.domain.repositories.UserStateRepository;
import java.util.List;

@RequiredArgsConstructor
public class ListUserStateUSeCase {
    private final UserStateRepository userStateRepository;
    public Uni<List<UserState>> listarEstadoUsuario() {
        return userStateRepository.listarEstadoUsuario();
    }
}
