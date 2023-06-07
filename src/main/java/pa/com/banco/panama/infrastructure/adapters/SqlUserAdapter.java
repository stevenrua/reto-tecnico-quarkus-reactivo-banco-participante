package pa.com.banco.panama.infrastructure.adapters;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.errorenum.ErrorCode;
import pa.com.banco.panama.domain.exceptions.MyExceptions;
import pa.com.banco.panama.domain.models.*;
import pa.com.banco.panama.domain.repositories.*;
import pa.com.banco.panama.infrastructure.entities.*;
import pa.com.banco.panama.infrastructure.repository.SqlUserRepository;

@RequiredArgsConstructor
@ApplicationScoped
public class SqlUserAdapter implements UserRepository {
    private final SqlUserRepository sqlUserRepository;
    private final AliasTypeRepository aliasTypeRepository;
    private final CountryRepository countryRepository;
    private final AccountRepository accountRepository;
    private final UserStateRepository userStateRepository;
    @Override
    @WithTransaction
    public Uni<User> guardarUsuario(User user) {
        return sqlUserRepository.findByAlias(user.getAlias())
                .onItem().ifNotNull().failWith(new MyExceptions(ErrorCode.ERROR_U01_ALIAS_REGISTERED.getMessage()))
                .flatMap(alias -> {
                    return aliasTypeRepository.buscarTipoAliasPorId(user.getTipoAlias().getIdTipoAlias())
                            .flatMap(aliasType -> {
                                return countryRepository.buscarPorCodigoPais(user.getPais().getCodigoPais())
                                        .flatMap(country -> {
                                            return userStateRepository.buscarEstadoUsuarioPorId(user.getEstadoUsuario().getIdEstado())
                                                    .flatMap(userState -> {
                                                        return accountRepository.guardarCuenta(user.getCuenta())
                                                                .flatMap(account -> {
                                                                    return sqlUserRepository.persist(UserEntity.builder()
                                                                                    .pais(CountryEntity.builder().codigoPais(user.getPais().getCodigoPais()).build())
                                                                                    .alias(user.getAlias())
                                                                                    .cuenta(AccountEntity.builder().idCuenta(account.getIdCuenta()).build())
                                                                                    .estadoUsuario(UserStateEntity.builder().idEstado(user.getEstadoUsuario().getIdEstado()).build())
                                                                                    .tipoAlias(AliasTypeEntity.builder().idTipoAlias(user.getTipoAlias().getIdTipoAlias()).build())
                                                                                    .build())
                                                                            .map(userEntity -> User.builder()
                                                                                    .idUsuario(userEntity.getIdUsuario())
                                                                                    .alias(userEntity.getAlias())
                                                                                    .pais(Country.builder()
                                                                                            .codigoPais(userEntity.getPais().getCodigoPais())
                                                                                            .nombrePais(country.getNombrePais())
                                                                                            .indicativoMovil(country.getIndicativoMovil())
                                                                                            .build())
                                                                                    .cuenta(Account.builder()
                                                                                            .idCuenta(userEntity.getCuenta().getIdCuenta())
                                                                                            .numeroCuenta(account.getNumeroCuenta())
                                                                                            .banco(account.getBanco())
                                                                                            .build())
                                                                                    .estadoUsuario(UserState.builder()
                                                                                            .idEstado(userEntity.getEstadoUsuario().getIdEstado())
                                                                                            .nombre(userState.getNombre())
                                                                                            .build())
                                                                                    .tipoAlias(AliasType.builder()
                                                                                            .idTipoAlias(userEntity.getTipoAlias().getIdTipoAlias())
                                                                                            .descripcion(aliasType.getDescripcion())
                                                                                            .build())
                                                                                    .build())
                                                                            .map(user1 -> user1);
                                                                });
                                                    });
                                        });
                            });
                });
    }
}