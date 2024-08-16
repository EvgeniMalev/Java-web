package com.example.soccerclient.controller;

import com.example.soccerclient.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class SoccerController {

    private final RestTemplate restTemplate;

    @Value("${soccerapp.api.url}")
    private String apiUrl;

    public SoccerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Game> getAllGames() {
        ResponseEntity<List<Game>> response = restTemplate.exchange(
                apiUrl + "/games",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Game>>() {}
        );
        return response.getBody();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return restTemplate.postForObject(apiUrl + "/games", game, Game.class);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        restTemplate.delete(apiUrl + "/games/" + id);
    }
}
