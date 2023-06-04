package pa.com.banco.panama.domain.usecase.aliastypeusecase;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.AliasType;
import pa.com.banco.panama.domain.repositories.AliasTypeRepository;
import java.util.List;

@RequiredArgsConstructor
public class ListAliasTypeUseCase {
    private final AliasTypeRepository aliasTypeRepository;

    public Uni<List<AliasType>> listarTiposAlias() {
        return aliasTypeRepository.listarTiposAlias();
    }
}
