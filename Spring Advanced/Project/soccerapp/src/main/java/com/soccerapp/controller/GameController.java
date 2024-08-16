package com.soccerapp.controller;

import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.service.LoggedUser;
import com.soccerapp.service.GameService;
import com.soccerapp.service.TeamService;
import com.soccerapp.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/games")
public class GameController {

    private final LoggedUser loggedUser;
    private final GameService gameService;
    private final TeamService teamService;
    private final PlayerService playerService;

    public GameController(LoggedUser loggedUser, GameService gameService, TeamService teamService, PlayerService playerService) {
        this.loggedUser = loggedUser;
        this.gameService = gameService;
        this.teamService = teamService;
        this.playerService = playerService;
    }
    
    @GetMapping("/create")
    public ModelAndView create() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("game-add");
    }

    @PostMapping("/add-game")
    public String addGame(@Valid @ModelAttribute("gameCreateBindingModel") GameCreateBindingModel gameCreateBindingModel,
                          BindingResult bindingResult, Model model) {

        if (gameCreateBindingModel.getHomeTeamPlayers().size() > 12) {
            bindingResult.rejectValue("homeTeamPlayers", "error.homeTeamPlayers", "Home team cannot have more than 12 players.");
        }

        if (gameCreateBindingModel.getAwayTeamPlayers().size() > 12) {
            bindingResult.rejectValue("awayTeamPlayers", "error.awayTeamPlayers", "Away team cannot have more than 12 players.");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("teams", teamService.findAllTeams());
            return "game-add";
        }

        gameService.createGame(gameCreateBindingModel);
        return "redirect:/games";
    }

    @PostMapping("/start")
    public ModelAndView startGame(GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isStarted = gameService.startGame(gameCreateBindingModel);

        String view = isStarted ? "redirect:/home" : "game-add";
        return new ModelAndView(view);
    }

    @PostMapping("/finish")
    public ModelAndView finishGame(GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isFinished = gameService.finishGame(gameCreateBindingModel);

        String view = isFinished ? "redirect:/home" : "game-add";
        return new ModelAndView(view);
    }

    @PostMapping("/record/{id}")
    public ModelAndView recordGoal(@PathVariable("id") UUID id, @RequestParam("scoringPlayerId") UUID playerId) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isRecorded = gameService.recordGoal(id);
        if (isRecorded) {
            playerService.incrementGoals(playerId);
        }

        return new ModelAndView("redirect:/home");
    }
}
