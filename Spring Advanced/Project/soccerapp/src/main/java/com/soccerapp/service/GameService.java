package com.soccerapp.service;

import com.soccerapp.model.GameCreateBindingModel;
import com.soccerapp.model.GameHomeDTO;

import java.util.UUID;

public interface GameService {

    GameHomeDTO getGameFotHomePage();

    boolean create(GameCreateBindingModel gameCreateBindingModel);

    void buy(UUID id);
}
