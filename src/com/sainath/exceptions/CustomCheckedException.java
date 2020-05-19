package com.sainath.exceptions;

public class CustomCheckedException extends Exception {

    public CustomCheckedException() {
    }

    public CustomCheckedException(String message) {
        super(message);
    }

    public CustomCheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
