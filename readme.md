
# Tic Tac Toe Multiplayer Game

This project is a simple implementation of a multiplayer Tic Tac Toe game using Spring Boot and WebSocket. It allows players to start a game, connect to existing games, make moves, and determine the winner. The communication between the server and clients is facilitated through WebSocket.

## Table of Contents

- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [WebSocket Configuration](#websocket-configuration)
- [Game Controller](#game-controller)
- [Game Service](#game-service)
- [Application Structure](#application-structure)

## Getting Started

To run the Tic Tac Toe application, make sure you have [Java](https://www.java.com/en/download/) and [Maven](https://maven.apache.org/install.html) installed on your machine. Clone the repository and navigate to the project directory. Then, run the following command:

```bash
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Endpoints

- **POST /startGame**
    - Start a new game by providing the player details.

- **POST /connect**
    - Connect to an existing game by providing the player and game ID.

- **POST /connect/random**
    - Connect to a random available game by providing the player details.

- **POST /gameplay**
    - Make a move during the game by providing the game play details.

## WebSocket Configuration

The WebSocket configuration is defined in the `WebSocketConfig` class. It enables WebSocket message broker functionality and registers Stomp endpoints for communication.

## Game Controller

The `GameController` class defines REST endpoints for starting a game, connecting to a game, connecting to a random game, and making moves during the game. WebSocket messaging is used to update clients about game progress.

## Game Service

The `GameService` class contains business logic for creating games, connecting players, handling random game connections, and processing game moves. It also checks for the winner based on the Tic Tac Toe rules.

## Application Structure

- **TicTacToeApplication.java**
    - The main class to run the Spring Boot application.

- **WebSocketConfig.java**
    - Configuration class for WebSocket.

- **GameController.java**
    - REST controller class handling game-related endpoints.

- **GameService.java**
    - Service class containing game-related business logic.

This project provides a foundation for a simple multiplayer Tic Tac Toe game and can be extended for more features and enhancements.