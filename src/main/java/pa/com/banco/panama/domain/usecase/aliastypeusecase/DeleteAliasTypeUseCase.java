package pa.com.banco.panama.domain.usecase.aliastypeusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;

@RequiredArgsConstructor
public class DeleteAliasTypeUseCase {
    private final AliasTypeRepository aliasTypeRepository;
    public Uni<Void> borrarTipoAlias(Long id) {
        return aliasTypeRepository.borrarTipoAlias(id);
    }
}
