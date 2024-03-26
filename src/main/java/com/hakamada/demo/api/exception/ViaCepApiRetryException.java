package com.hakamada.demo.api.exception;


public class ViaCepApiRetryException extends RuntimeException {

    public ViaCepApiRetryException() {
    }

    public ViaCepApiRetryException(Throwable cause) {
        super(cause);
    }

    public ViaCepApiRetryException(String message) {
        super(message);
    }


}
