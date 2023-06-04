package pa.com.banco.panama.domain.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AliasType {
    private Long idTipoAlias;
    private String descripcion;
}
