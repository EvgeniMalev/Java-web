package com.soccerapp.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;

public class GameCreateBindingModel {

    @NotEmpty
    private String matchComment;

    @NotNull
    private Duration duration;

    @NotEmpty
    private String homeTeamName;

    @NotEmpty
    private String awayTeamName;

    @NotNull
    private Integer homeScore;

    @NotNull
    private Integer awayScore;

    private Float fieldTemperature;

    @NotNull
    private Integer fansWatched;

    public String getMatchComment() {
        return matchComment;
    }

    public void setMatchComment(String matchComment) {
        this.matchComment = matchComment;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
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

    public Float getFieldTemperature() {
        return fieldTemperature;
    }

    public void setFieldTemperature(Float fieldTemperature) {
        this.fieldTemperature = fieldTemperature;
    }

    public Integer getFansWatched() {
        return fansWatched;
    }

    public void setFansWatched(Integer fansWatched) {
        this.fansWatched = fansWatched;
    }
}
