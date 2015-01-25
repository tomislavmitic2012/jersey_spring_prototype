package edu.depaul.capstone.demo.rest.errorhandling;

/**
 * Created by Tomislav S. Mitic on 1/24/15.
 */
public class CustomReasonPhraseException extends Exception {

    private final int businessCode;

    public CustomReasonPhraseException(int businessCode, String message) {
        super(message);
        this.businessCode = businessCode;
    }

    public int getBusinessCode() {
        return businessCode;
    }
}
