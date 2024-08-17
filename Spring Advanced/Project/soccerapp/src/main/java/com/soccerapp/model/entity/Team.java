package com.soccerapp.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private int goalsScored = 0;
    private int goalsConceded = 0;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    @OneToMany(mappedBy = "homeTeam")
    private List<Game> homeGames;

    @OneToMany(mappedBy = "awayTeam")
    private List<Game> awayGames;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public List<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(List<Game> awayGames) {
        this.awayGames = awayGames;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void updateStatistics(int goalsScored, int goalsConceded, boolean isHomeTeam) {
        this.goalsScored += goalsScored;
        this.goalsConceded += goalsConceded;

        if (goalsScored > goalsConceded) {
            this.wins++;
        } else if (goalsScored < goalsConceded) {
            this.losses++;
        } else {
            this.draws++;
        }
    }
}
