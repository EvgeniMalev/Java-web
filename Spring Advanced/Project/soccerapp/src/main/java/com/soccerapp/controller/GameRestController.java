package com.soccerapp.controller;

import com.soccerapp.model.dto.GameDTO;
import com.soccerapp.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class GameRestController {

    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO gameDTO) {
        return gameService.createGame(gameDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable UUID id) {
        gameService.deleteGame(id);
    }
}
