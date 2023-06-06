package pa.com.banco.panama.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private Long idUsuario;
    private Country pais;
    private String alias;
    private Account cuenta;
    private UserState estadoUsuario;
    private AliasType tipoAlias;
}
