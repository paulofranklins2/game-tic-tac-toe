package com.tictactoe.controller;

import com.tictactoe.exception.GameNotFoundException;
import com.tictactoe.exception.InvalidGameException;
import com.tictactoe.exception.InvalidParamException;
import com.tictactoe.model.Game;
import com.tictactoe.model.GamePlay;
import com.tictactoe.model.Player;
import com.tictactoe.response.ConnectRequest;
import com.tictactoe.service.GameService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class GameController {
    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/startGame")
    public ResponseEntity<Game> startGame(@RequestBody Player player) {
        log.info("start game request: {}", player);
        return ResponseEntity.ok(gameService.createGame(player));
    }

    @PostMapping("/connect")
    public ResponseEntity<Game> connect(@RequestBody ConnectRequest connectRequest) throws InvalidParamException, InvalidGameException {
        log.info("connect request: {}", connectRequest);
        return ResponseEntity.ok(gameService.connectToGame(connectRequest.getPlayer(), connectRequest.getGameId()));
    }

    @PostMapping("/connect/random")
    public ResponseEntity<Game> connectRandom(@RequestBody Player player) throws GameNotFoundException {
        log.info("connect random request: {}", player);
        return ResponseEntity.ok(gameService.connectToRandomGame(player));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> gamePlay(@RequestBody GamePlay gamePlay) throws InvalidGameException, GameNotFoundException {
        log.info("gameplay: {}", gamePlay);
        Game game = gameService.gamePlay(gamePlay);
        simpMessagingTemplate.convertAndSend("/topic/game-progress/" +game.getGameId(), game);
        return ResponseEntity.ok(game);
    }
}
