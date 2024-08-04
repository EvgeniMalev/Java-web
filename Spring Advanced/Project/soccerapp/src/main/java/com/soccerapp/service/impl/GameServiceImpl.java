package com.soccerapp.service.impl;

import com.soccerapp.model.*;
import com.soccerapp.model.entity.Result;
import com.soccerapp.model.entity.Game;
import com.soccerapp.model.entity.User;
import com.soccerapp.repository.ResultRepository;
import com.soccerapp.repository.GameRepository;
import com.soccerapp.repository.UserRepository;
import com.soccerapp.service.LoggedUser;
import com.soccerapp.service.OfferService;
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
    private final LoggedUser loggedUser;

    public GameServiceImpl(GameRepository gameRepository, ResultRepository resultRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.gameRepository = gameRepository;
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public GameHomeDTO getGameFotHomePage() {
        List<Offer> games = gameRepository.findAll();

        List<MyGameDTO> myOffers = new ArrayList<>();
        List<WatchedGamesDTO> watchedgames = new ArrayList<>();
        List<OtherGamesDTO> otherGames = new ArrayList<>();

        for (Game game : games) {
            String loggedUsername = loggedUser.getUsername();

            if (offer.getWatchedBy() == null && game.getCreatedBy().getUsername().equals(loggedUsername)) {
                myGame.add(new MyGameDTO(game));
            } else if (game.getWatchedBy() != null && game.getWatchedBy().getUsername().equals(loggedUsername)) {
                watchedgames.add(new WatchedGamesDTO(game));
            } else if (offer.getBoughtBy() == null) {
                otherGames.add(new OtherGamessDTO(game));
            }
        }

        return new GameHomeDTO(myGame, watchGames, otherGames);
    }

    @Override
    public boolean create(GamesCreateBindingModel gamesCreateBindingModel) {
        Result result = resultRepository.findByName(gameCreateBindingModel.getResult());
        User user = userRepository.findByUsername(loggedUser.getUsername());

        if (result != null && user != null) {
            Game game = new Game(gameCreateBindingModel, result, user);

            gameRepository.save(game);
            return true;
        }

        return false;
    }

    @Override
    public void buy(UUID id) {
        Optional<Game> optionalGame = gameRepository.findById(id);

        if (optionalGame.isPresent()) {
            User user = userRepository.findByUsername(loggedUser.getUsername());
            Game game = optionalGame.get();

            game.setBoughtBy(user);

            game.Repository.save(game);
        }
    }
}
