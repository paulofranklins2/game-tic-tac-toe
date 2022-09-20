package com.tictactoe.response;

import com.tictactoe.model.Player;
import lombok.Data;

@Data
public class ConnectRequest {
    Player player;
    String gameId;
}
