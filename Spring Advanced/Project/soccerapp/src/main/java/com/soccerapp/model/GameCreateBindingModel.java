package com.soccerapp.model;

import com.soccerapp.model.enums.ResultName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class GameCreateBindingModel {

    @NotNull(message = "Home team is required")
    private UUID homeTeamId;

    @NotNull(message = "Away team is required")
    private UUID awayTeamId;

    @NotNull(message = "Home score is required")
    @Positive(message = "Home score must be a positive number")
    private Integer homeScore;

    @NotNull(message = "Away score is required")
    @Positive(message = "Away score must be a positive number")
    private Integer awayScore;

    private String matchComment;

    @NotNull(message = "Duration is required")
    private BigDecimal duration;

    @NotNull(message = "Result is required")
    private ResultName result;

    @NotNull(message = "Home team players are required")
    private List<UUID> homeTeamPlayers;

    @NotNull(message = "Away team players are required")
    private List<UUID> awayTeamPlayers;


    public UUID getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(UUID homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public UUID getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(UUID awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public String getMatchComment() {
        return matchComment;
    }

    public void setMatchComment(String matchComment) {
        this.matchComment = matchComment;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public ResultName getResult() {
        return result;
    }

    public void setResult(ResultName result) {
        this.result = result;
    }

    public List<UUID> getHomeTeamPlayers() {
        return homeTeamPlayers;
    }

    public void setHomeTeamPlayers(List<UUID> homeTeamPlayers) {
        this.homeTeamPlayers = homeTeamPlayers;
    }

    public List<UUID> getAwayTeamPlayers() {
        return awayTeamPlayers;
    }

    public void setAwayTeamPlayers(List<UUID> awayTeamPlayers) {
        this.awayTeamPlayers = awayTeamPlayers;
    }
}
