package com.soccerapp.controller;

import com.soccerapp.dto.PlayerDTO;
import com.soccerapp.dto.TeamDTO;
import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.model.entity.Game;
import com.soccerapp.model.entity.Player;
import com.soccerapp.model.entity.Team;
import com.soccerapp.service.GameService;
import com.soccerapp.service.PlayerService;
import com.soccerapp.service.TeamService;
import com.soccerapp.service.LoggedUser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        if (bindingResult.hasErrors()) {
            model.addAttribute("teams", teamService.findAllTeams());
            return "game-add";
        }
        Game game = new Game();
        game.setMatchComment(gameCreateBindingModel.getMatchComment());
        game.setDuration(gameCreateBindingModel.getDuration());
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

    @GetMapping("/player-ranking")
    public ModelAndView playerRanking() {
        List<Player> players = playerService.getAllPlayers(); 
        List<PlayerDTO> playerDTOs = players.stream()
                .map(player -> new PlayerDTO(player.getId(), player.getName(), player.getGoalsScored()))
                .collect(Collectors.toList());
        return new ModelAndView("player-ranking", "players", playerDTOs);
    }

    @GetMapping("/team-ranking")
    public ModelAndView teamRanking() {
        List<Team> teams = teamService.getAllTeams(); 
        List<TeamDTO> teamDTOs = teams.stream()
                .map(team -> new TeamDTO(team.getId(), team.getName(), team.getWins(), team.getDraws(), team.getLosses()))
                .collect(Collectors.toList());
        return new ModelAndView("team-ranking", "teams", teamDTOs);
    }

    @Scheduled(fixedRate = 86400000) 
    public void scheduledJob() {
        System.out.println("The rankist is updated!");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @PostMapping("/add-player")
    public String addPlayer(@RequestParam String playerName, @RequestParam UUID teamId, Model model) {
        if (playerService.getPlayersByTeam(teamId).size() >= 12) {
            throw new IllegalArgumentException("Cannot add more than 12 players to a team.");
        }
        playerService.addPlayer(playerName, teamId);
        return "redirect:/players";
    }
}
