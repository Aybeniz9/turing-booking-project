package org.example.exception;

public class NoSuchReservationException extends RuntimeException{
    public NoSuchReservationException(String message) {
        super(message);
    }

}
