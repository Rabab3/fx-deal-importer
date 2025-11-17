package com.example.fxdeals.exception;

public class DealAlreadyExistsException extends RuntimeException {
    public DealAlreadyExistsException(String id) {
        super("Deal with ID " + id + " already exists");
    }
}
