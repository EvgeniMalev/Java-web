package com.soccerapp.model.entity;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "match_comment")
    private String matchComment;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "home_team_name")
    private String homeTeamName;

    @Column(name = "away_team_name")
    private String awayTeamName;

    @Column(name = "home_score")
    private Integer homeScore;

    @Column(name = "away_score")
    private Integer awayScore;

    @Column(name = "field_temperature")
    private Float fieldTemperature;

    @Column(name = "fans_watched")
    private Integer fansWatched;


    public Game() {}

    public Game(String matchComment, Duration duration, String homeTeamName, String awayTeamName, Integer homeScore, Integer awayScore, Float fieldTemperature, Integer fansWatched) {
        this.matchComment = matchComment;
        this.duration = duration;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.fieldTemperature = fieldTemperature;
        this.fansWatched = fansWatched;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", matchComment='" + matchComment + '\'' +
                ", duration=" + duration +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", fieldTemperature=" + fieldTemperature +
                ", fansWatched=" + fansWatched +
                '}';
    }
}
