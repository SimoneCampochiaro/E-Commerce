package com.example.demo.exception;

public class InventarioException extends Exception{.

    private static final long serialVersionUID = 4L;

    public InventarioException(final String message) {
        super(message);
    }

    public InventarioException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
