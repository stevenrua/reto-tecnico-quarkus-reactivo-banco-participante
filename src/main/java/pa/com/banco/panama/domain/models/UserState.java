package pa.com.banco.panama.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserState {
    private Long idEstado;
    private String nombre;
}
