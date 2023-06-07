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
@Table(name = "paises")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_pais")
    private Long codigoPais;
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Column(name = "indicativo_movil")
    private Integer indicativoMovil;
}
