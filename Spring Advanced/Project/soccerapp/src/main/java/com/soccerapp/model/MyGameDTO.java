package com.soccerapp.model;

import com.soccerapp.model.entity.Game;
import com.soccerapp.model.enums.ResultName;

import java.math.BigDecimal;
import java.util.UUID;

public class MyGameDTO extends WatchedGamesDTO {

    private UUID id;
    private ResultName result;

    public MyGameDTO() {
    }

    public MyGameDTO(Game game) {
        super(game);
        id = game.getId();
        result = game.getCondition().getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ResultName getResult() {
        return result;
    }

    public void setResult(ResultName result) {
        this.result = result;
    }
}
