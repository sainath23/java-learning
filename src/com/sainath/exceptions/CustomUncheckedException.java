package com.sainath.exceptions;

public class CustomUncheckedException extends RuntimeException {

    public CustomUncheckedException() {
    }

    public CustomUncheckedException(String message) {
        super(message);
    }

    public CustomUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
