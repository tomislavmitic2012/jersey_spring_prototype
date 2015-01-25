package edu.depaul.capstone.demo.rest.errorhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Response;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
@Provider
public class AppExceptionMapper {

    public Response toResponse(AppException ex) {
        return Response.status(ex.getStatus())
                .entity(new ErrorMessage(ex))
                .type(MediaType.APPLICATION_JSON).
                        build();
    }
}
