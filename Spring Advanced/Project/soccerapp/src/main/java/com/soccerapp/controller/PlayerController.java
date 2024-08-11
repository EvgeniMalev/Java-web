package com.soccerapp.controller;

import com.soccerapp.model.entity.Player;
import com.soccerapp.service.PlayerService;
import com.soccerapp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
public class PlayerController {

    private final PlayerService playerService;
    private final LoggedUser loggedUser;

    public PlayerController(PlayerService playerService, LoggedUser loggedUser) {
        this.playerService = playerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/players")
    public ModelAndView getPlayers(UUID teamId) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        List<Player> players = playerService.getPlayersByTeam(teamId);
        return new ModelAndView("player", "players", players);
    }
}  
