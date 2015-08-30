package com.mokona.exception;

public class MokonaException extends RuntimeException {
    
    private static final long serialVersionUID = -6034170862415401932L;
    
    private String message;
    
    public MokonaException(String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }

}
