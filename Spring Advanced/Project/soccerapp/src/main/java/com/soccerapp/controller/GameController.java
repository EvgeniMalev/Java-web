package com.soccerapp.controller;

import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.model.entity.Game;
import com.soccerapp.service.LoggedUser;
import com.soccerapp.service.GameService;
import com.soccerapp.service.TeamService;
import com.soccerapp.service.PlayerService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public GameController(LoggedUser loggedUser, GameService gameService, TeamService teamService, PlayerService playerService, ModelMapper modelMapper) {
        this.loggedUser = loggedUser;
        this.gameService = gameService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.modelMapper = modelMapper;
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

        Game game = modelMapper.map(gameCreateBindingModel, Game.class);
        gameService.createGame(game);

        return "redirect:/games";
    }

    @PostMapping("/start")
    public ModelAndView startGame(@Valid @ModelAttribute("gameCreateBindingModel") GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isStarted = gameService.startGame(gameCreateBindingModel);

        String view = isStarted ? "redirect:/home" : "game-add";
        return new ModelAndView(view);
    }

    @PostMapping("/finish")
    public ModelAndView finishGame(@Valid @ModelAttribute("gameCreateBindingModel") GameCreateBindingModel gameCreateBindingModel) {
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

        gameService.recordGoal(id, playerId);
        return new ModelAndView("redirect:/home");
    }
}
