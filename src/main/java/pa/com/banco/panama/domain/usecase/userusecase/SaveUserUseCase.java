package pa.com.banco.panama.domain.usecase.userusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.errorenum.ErrorCode;
import pa.com.banco.panama.domain.exceptions.MyExceptions;
import pa.com.banco.panama.domain.models.User;
import pa.com.banco.panama.domain.repositories.UserRepository;
import pa.com.banco.panama.domain.validalias.ValidationAlias;

@RequiredArgsConstructor
public class SaveUserUseCase {
    private final UserRepository userRepository;
    public Uni<User> guardarUsuario(User user) {
        return ValidationAlias.isValidAlias(user.getAlias())
                ?  userRepository.guardarUsuario(user)
                : Uni.createFrom().failure(new MyExceptions(ErrorCode.ERROR_U00_INVALID_FORMAT_ALIAS.getMessage()));
    }
}
