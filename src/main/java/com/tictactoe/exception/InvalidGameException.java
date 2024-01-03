package com.tictactoe.exception;

import lombok.Getter;

@Getter
public class InvalidGameException extends Exception {
    String message;

    public InvalidGameException(String message) {
        this.message = message;
    }

}
