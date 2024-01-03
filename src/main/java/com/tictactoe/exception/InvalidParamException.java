package com.tictactoe.exception;

import lombok.Getter;

@Getter
public class InvalidParamException extends Exception {
    private final String message;

    public InvalidParamException(String message) {
        this.message = message;
    }

}
