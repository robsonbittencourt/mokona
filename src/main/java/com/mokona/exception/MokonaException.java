package com.mokona.exception;

public class MokonaException extends RuntimeException {

    private static final long serialVersionUID = -6034170862415401932L;

    public MokonaException(String message) {
        super(message);
    }

    public MokonaException(String message, Exception cause) {
        super(message, cause);
    }

}
