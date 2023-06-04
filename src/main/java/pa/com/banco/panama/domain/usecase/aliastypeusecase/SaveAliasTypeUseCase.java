package pa.com.banco.panama.domain.usecase.aliastypeusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.AliasType;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;

@RequiredArgsConstructor
public class SaveAliasTypeUseCase {
    private final AliasTypeRepository aliasTypeRepository;
    public Uni<AliasType> guardarTiposAlias(AliasType aliasType) {
        return aliasTypeRepository.guardarTipoAlias(aliasType);
    }
}
