package pa.com.banco.panama.domain.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {
    private Long idCuenta;
    private String numeroCuenta;
    private Bank banco;
}
