package com.soccerapp.service.impl;

import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.model.GameHomeDTO;
import com.soccerapp.model.MyGameDTO;
import com.soccerapp.model.OtherGamesDTO;
import com.soccerapp.model.WatchedGamesDTO;
import com.soccerapp.model.entity.Game;
import com.soccerapp.model.entity.Result;
import com.soccerapp.model.entity.Team;
import com.soccerapp.model.entity.User;
import com.soccerapp.repository.GameRepository;
import com.soccerapp.repository.ResultRepository;
import com.soccerapp.repository.UserRepository;
import com.soccerapp.repository.TeamRepository;
import com.soccerapp.service.LoggedUser;
import com.soccerapp.service.GameService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final LoggedUser loggedUser;

    public GameServiceImpl(GameRepository gameRepository, ResultRepository resultRepository, UserRepository userRepository, TeamRepository teamRepository, LoggedUser loggedUser) {
        this.gameRepository = gameRepository;
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public GameHomeDTO getGameFotHomePage() {
        List<Game> games = gameRepository.findAll();

        List<MyGameDTO> myGames = new ArrayList<>();
        List<WatchedGamesDTO> watchedGames = new ArrayList<>();
        List<OtherGamesDTO> otherGames = new ArrayList<>();

        String loggedUsername = loggedUser.getUsername();

        for (Game game : games) {
            if (game.getCreatedBy().getUsername().equals(loggedUsername)) {
                myGames.add(new MyGameDTO(game));
            } else if (game.getWatchedBy() != null && game.getWatchedBy().getUsername().equals(loggedUsername)) {
                watchedGames.add(new WatchedGamesDTO(game));
            } else if (game.getWatchedBy() == null) {
                otherGames.add(new OtherGamesDTO(game));
            }
        }

        return new GameHomeDTO(myGames, watchedGames, otherGames);
    }

    @Override
    public boolean create(GameCreateBindingModel gameCreateBindingModel) {
        Result result = resultRepository.findByName(gameCreateBindingModel.getResult());
        User createdBy = userRepository.findByUsername(loggedUser.getUsername());
        Team homeTeam = teamRepository.findById(gameCreateBindingModel.getHomeTeamId()).orElse(null);
        Team awayTeam = teamRepository.findById(gameCreateBindingModel.getAwayTeamId()).orElse(null);

        if (result != null && createdBy != null && homeTeam != null && awayTeam != null) {
            Game game = new Game(gameCreateBindingModel, result, createdBy, homeTeam, awayTeam);
            gameRepository.save(game);
            return true;
        }

        return false;
    }

    @Override
    public void recordGoal(UUID gameId, UUID playerId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            User player = userRepository.findById(playerId).orElse(null);

            if (player != null) {
                Team homeTeam = game.getHomeTeam();
                Team awayTeam = game.getAwayTeam();

                if (homeTeam.getPlayers().contains(player)) {
                    game.setHomeTeamScore(game.getHomeTeamScore() + 1);
                    homeTeam.updateStatistics(1, 0, true);
                } else if (awayTeam.getPlayers().contains(player)) {
                    game.setAwayTeamScore(game.getAwayTeamScore() + 1);
                    awayTeam.updateStatistics(1, 0, false);
                }

                // Save updated game and teams
                gameRepository.save(game);
                teamRepository.save(homeTeam);
                teamRepository.save(awayTeam);
            }
        }
    }

    @Override
    public boolean startGame(GameCreateBindingModel gameCreateBindingModel) {
        Optional<Game> optionalGame = gameRepository.findById(gameCreateBindingModel.getId());

        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setStarted(true);
            gameRepository.save(game);
            return true;
        }

        return false;
    }

    @Override
    public boolean finishGame(GameCreateBindingModel gameCreateBindingModel) {
        Optional<Game> optionalGame = gameRepository.findById(gameCreateBindingModel.getId());

        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.setFinished(true);
            gameRepository.save(game);
            return true;
        }

        return false;
    }
}
