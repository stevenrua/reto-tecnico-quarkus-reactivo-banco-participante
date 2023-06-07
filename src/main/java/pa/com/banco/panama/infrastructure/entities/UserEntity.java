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
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "codigo_pais")
    private CountryEntity pais;
    @Column(unique = true)
    private String alias;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_cuenta")
    private AccountEntity cuenta;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_estado")
    private UserStateEntity estadoUsuario;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_tipo_alias")
    private AliasTypeEntity tipoAlias;
}
