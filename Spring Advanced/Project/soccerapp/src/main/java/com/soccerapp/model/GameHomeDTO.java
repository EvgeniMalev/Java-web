package com.soccerapp.model;

import java.util.List;

public class GameHomeDTO {

    private List<MyGameDTO> myGame;

    private List<WatchedGamesDTO> watchedGames;

    private List<OtherGamesDTO> allOtherGames;

    private long totalOtherGames;

    public GameHomeDTO(List<MyGamesDTO> myGames, List<WatchedGamesDTO> watchedGames, List<OtherGamesDTO> otherGames) {
        this.myGames = myGames;
        this.watchedGames = watchedGames;
        this.allOtherGames = otherGames;
        this.totalOtherGames = otherGames.size();
    }

    public List<MyGamesDTO> getMyGames() {
        return myGames;
    }

    public void setMyGames(List<MyGamesDTO> myGames) {
        this.myGames = myGames;
    }

    public List<WatchedGamesDTO> getWatchedGames() {
        return watchedGames;
    }

    public void setWatchedGames(List<WatchedGamesDTO> watchedGames) {
        this.watchedGames =  watchedGames;
    }

    public List<OtherGamesDTO> getAllOtherGames() {
        return allOtherGames;
    }

    public void setAllOtherGames(List<OtherGamesDTO> allOtherGames) {
        this.allOtherGames = allOtherGames;
    }

    public long getTotalOtherGames() {
        return totalOtherGames;
    }

    public void setTotalOtherGames(long totalOtherGames) {
        this.totalOtherGames = totalOtherGames;
    }
}
