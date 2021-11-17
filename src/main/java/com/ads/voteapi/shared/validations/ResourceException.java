package com.ads.voteapi.shared.validations;

/**
 * @author : Anderson S. Andrade
 * @since : 16/11/21, terça-feira
 **/
public class ResourceException extends RuntimeException {

    public ResourceException(String msg){
        super(msg);
    }

    public ResourceException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
