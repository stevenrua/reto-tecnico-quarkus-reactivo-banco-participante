package pa.com.banco.panama.domain.repositories;
import io.smallrye.mutiny.Uni;
import pa.com.banco.panama.domain.models.AliasType;
import java.util.List;

public interface AliasTypeRepository {
    Uni<List<AliasType>> listarTiposAlias();
    Uni<AliasType> buscarTipoAliasPorId(Long id);
    Uni<AliasType> guardarTipoAlias(AliasType aliasType);
    Uni<Void> borrarTipoAlias(Long id);
}
