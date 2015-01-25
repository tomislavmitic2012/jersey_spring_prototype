package edu.depaul.capstone.demo.rest.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
public class CustomReasonPhraseExceptionMapper
        implements ExceptionMapper<CustomReasonPhraseException> {

    public Response toResponse(CustomReasonPhraseException bex) {
        return Response.status(new CustomReasonPhraseExceptionStatusType(Response.Status.BAD_REQUEST))
                .entity("Custom Reason Phrase exception occured : " + bex.getMessage())
                .build();
    }
}
