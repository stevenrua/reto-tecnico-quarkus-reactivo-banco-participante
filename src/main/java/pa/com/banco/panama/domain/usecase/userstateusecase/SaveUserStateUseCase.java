package pa.com.banco.panama.domain.usecase.userstateusecase;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.UserState;
import pa.com.banco.panama.domain.repositories.UserStateRepository;

@RequiredArgsConstructor
public class SaveUserStateUseCase {
    private final UserStateRepository userStateRepository;
    public Uni<UserState> guardarEstadoUsuario(UserState userState) {
        return userStateRepository.guardarEstadoUsuario(userState);
    }
}
