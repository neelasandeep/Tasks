package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class InvalidFileTypeException extends RuntimeException {
    String message;
    public InvalidFileTypeException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
