package com.soccerapp.dto;

public class PlayerDTO {
    private UUID id;
    private String name;
    private int goalsScored;

    public PlayerDTO() {
    }

    public PlayerDTO(UUID id, String name, int goalsScored) {
        this.id = id;
        this.name = name;
        this.goalsScored = goalsScored;
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

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
}
