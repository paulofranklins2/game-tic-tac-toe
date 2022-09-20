package com.tictactoe.exception;

public class InvalidGameException extends Exception {
    String message;

    public InvalidGameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
