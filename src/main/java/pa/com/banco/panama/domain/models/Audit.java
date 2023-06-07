package pa.com.banco.panama.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
public class Audit {
    private Long idAuditoria;
    private User usuario;
    private Account cuenta;
    private Timestamp fechaAlta;
    private UserState estadoUsuario;
}
