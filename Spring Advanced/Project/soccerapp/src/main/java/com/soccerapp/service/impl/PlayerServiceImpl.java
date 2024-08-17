package com.soccerapp.service;

import com.soccerapp.model.entity.Player;
import com.soccerapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player addPlayer(String name, UUID teamId) {
        Player player = new Player();
        player.setName(name);
        player.setTeamId(teamId);
        return playerRepository.save(player);
    }

    @Override
    public void removePlayer(UUID playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> getPlayersByTeam(UUID teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void incrementGoals(UUID playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setGoalsScored(player.getGoalsScored() + 1);
        playerRepository.save(player);
    }
}
