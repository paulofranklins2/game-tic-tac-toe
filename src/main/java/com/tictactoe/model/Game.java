package com.tictactoe.model;

import lombok.Data;

@Data
public class Game {
    private String gameId;
    private Player playerOne;
    private Player playerTwo;
    private GameStatus gameStatus;
    private int[][] board;
    private TicToe winner;
}
