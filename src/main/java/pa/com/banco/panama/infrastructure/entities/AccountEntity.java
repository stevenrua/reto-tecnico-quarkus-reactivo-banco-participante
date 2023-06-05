package pa.com.banco.panama.infrastructure.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cuentas")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta")
    private Long idCuenta;
    @Column(name = "numero_cuenta", unique = true)
    private String numeroCuenta;
    @Column(name = "id_banco", unique = true)
    private Long idBanco;
}
