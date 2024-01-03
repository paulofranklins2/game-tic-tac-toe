package com.tictactoe.exception;

import lombok.Getter;

@Getter
public class GameNotFoundException extends Exception {
    String message;

    public GameNotFoundException(String message) {
        this.message = message;
    }

}
