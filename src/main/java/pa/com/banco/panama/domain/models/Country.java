package pa.com.banco.panama.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Country {
    private Long codigoPais;
    private String nombrePais;
    private Integer indicativoMovil;
}
