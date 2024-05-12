package org.example.exception;

public class FlightCannotCreateException extends RuntimeException {
    public FlightCannotCreateException(String message) {
        super(message);

    }
}