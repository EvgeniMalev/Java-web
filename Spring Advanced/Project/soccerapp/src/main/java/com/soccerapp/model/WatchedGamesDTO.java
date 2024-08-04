package com.soccerapp.model;

import com.soccerapp.model.entity.Game;

import java.math.BigDecimal;

public class WatchedGamesDTO {

    private String matchcomment;

    private BigDecimal duration;

    public WatchedGamesDTO() {
    }

    public WatchedGamesDTO(Game game) {
        matchcomment = game.getDescription();
        duration = game.getDuration();
    }

    public String getMatchComment() {
        return matchcomment;
    }

    public void setMatchComment(String matchcomment) {
        this.matchcomment = matchcomment;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }
}
