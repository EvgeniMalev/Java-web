package com.soccerapp.service;

import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.model.entity.Game;
import com.soccerapp.model.entity.Result;
import com.soccerapp.model.entity.Team;
import com.soccerapp.repository.GameRepository;
import com.soccerapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public boolean startGame(GameCreateBindingModel gameCreateBindingModel) {
        Game game = gameRepository.findById(gameCreateBindingModel.getId()).orElse(null);
        if (game == null) {
            return false;
        }

        game.setStatus("Started"); 
        gameRepository.save(game);

        return true;
    }

    @Transactional
    public boolean finishGame(GameCreateBindingModel gameCreateBindingModel) {
        Game game = gameRepository.findById(gameCreateBindingModel.getId()).orElse(null);
        if (game == null) {
            return false;
        }

        int homeGoals = gameCreateBindingModel.getHomeScore();
        int awayGoals = gameCreateBindingModel.getAwayScore();

        Team homeTeam = game.getHomeTeam();
        Team awayTeam = game.getAwayTeam();

        homeTeam.updateStatistics(homeGoals, awayGoals, true);
        awayTeam.updateStatistics(awayGoals, homeGoals, false);

        Result result;
        if (homeGoals > awayGoals) {
            result = ResultName.WIN;
        } else if (homeGoals < awayGoals) {
            result = ResultName.LOSE;
        } else {
            result = ResultName.DRAW;
        }

        game.setResult(result);
        gameRepository.save(game);
        teamRepository.save(homeTeam);
        teamRepository.save(awayTeam);

        return true;
    }
}
