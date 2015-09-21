package com.mokona.exception;

public class MokonaException extends RuntimeException {

    private static final long serialVersionUID = 4995950178981016435L;

    public MokonaException(String message) {
        super(message);
    }

    public MokonaException(String message, Exception cause) {
        super(message, cause);
    }

}
