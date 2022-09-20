package com.tictactoe.exception;

public class GameNotFoundException extends Exception {
    String message;

    public GameNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
