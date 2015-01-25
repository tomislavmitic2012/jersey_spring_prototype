package edu.depaul.capstone.demo.rest.errorhandling;

import javax.ws.rs.core.Response;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
public class CustomReasonPhraseExceptionStatusType extends AbstractStatusType {

    private static final String CUSTOM_EXCEPTION_REASON_PHRASE = "Custom error message";

    public CustomReasonPhraseExceptionStatusType(Response.Status httpStatus) {
        super(httpStatus, CUSTOM_EXCEPTION_REASON_PHRASE);
    }
}
