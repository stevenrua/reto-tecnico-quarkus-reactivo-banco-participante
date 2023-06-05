package pa.com.banco.panama.infrastructure.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;
import pa.com.banco.panama.domain.models.Account;
import pa.com.banco.panama.domain.repositories.AccountRepository;

@Path("/cuenta")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Provider
public class AccountController {
    private final AccountRepository accountRepository;
    @GET
    @Path("/{idBanco}")
    public Uni<Account> buscarCuentaPorIdBanco(@PathParam("idBanco") Long idBanco){
        return accountRepository.buscarCuentaPorIdBanco(idBanco);
    }
    @GET
    @Path("/{numeroCuenta}")
    public Uni<Account> buscarCuentaPorNumeroDeCuenta(@PathParam("numeroCuenta") String numeroCuenta){
        return accountRepository.buscarCuentaPorNumeroCuenta(numeroCuenta);
    }
    @POST
    public Uni<Account> guardarCuenta(Account account){
        return accountRepository.guardarCuenta(account);
    }
}
