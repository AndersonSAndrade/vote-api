package com.ads.voteapi.shared.validations;

/**
 * @author : Anderson S. Andrade
 * @since : 18/11/21, quinta-feira
 **/
public class VoteException extends RuntimeException {

    public VoteException(String message) {
        super(message);
    }

    public VoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
