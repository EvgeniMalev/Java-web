package com.soccerapp.dto;

public class TeamDTO {
    private UUID id;
    private String name;
    private int wins;
    private int draws;
    private int losses;

    public TeamDTO() {
    }

    public TeamDTO(UUID id, String name, int wins, int draws, int losses) {
        this.id = id;
        this.name = name;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
