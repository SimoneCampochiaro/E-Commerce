package com.example.demo.exception;

public class CarrelloException extends Exception {

    private static final long serialVersionUID = 2L;

    public CarrelloException(final String message){
        super(message);
    }

    public CarrelloException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
