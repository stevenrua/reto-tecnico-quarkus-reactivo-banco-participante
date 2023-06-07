package pa.com.banco.panama.infrastructure.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "auditoria_directorio")
public class AuditEntity {
    private Long idAuditoria;
    private UserEntity usuario;
    private AccountEntity cuenta;
    private Timestamp fechaAlta;
    private UserStateEntity estadoUsuario;
}
