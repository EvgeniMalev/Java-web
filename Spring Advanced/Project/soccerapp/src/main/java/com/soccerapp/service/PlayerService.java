package com.soccerapp.service;

import com.soccerapp.model.entity.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    Player addPlayer(String name, UUID teamId);
    void removePlayer(UUID playerId);
    List<Player> getPlayersByTeam(UUID teamId);
    List<Player> getAllPlayers();
    void incrementGoals(UUID playerId);
}
