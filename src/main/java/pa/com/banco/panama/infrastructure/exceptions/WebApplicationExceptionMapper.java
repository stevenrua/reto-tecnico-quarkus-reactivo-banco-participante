package pa.com.banco.panama.infrastructure.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        String errorMessage = exception.getMessage();
        int statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        return Response.status(statusCode)
                .entity(errorMessage)
                .build();
    }
}
