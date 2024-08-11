package com.soccerapp.service.impl;

import com.soccerapp.model.entity.Player;
import com.soccerapp.repository.PlayerRepository;
import com.soccerapp.repository.TeamRepository;
import com.soccerapp.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Player addPlayer(String name, UUID teamId) {
        Player player = new Player();
        player.setName(name);
        player.setTeam(teamRepository.findById(teamId).orElseThrow());
        return playerRepository.save(player);
    }

    @Override
    public void removePlayer(UUID playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> getPlayersByTeam(UUID teamId) {
        return playerRepository.findAllByTeamIdOrderByGoalsScoredDesc(teamId);
    }

    @Override
    public void incrementGoals(UUID playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setGoalsScored(player.getGoalsScored() + 1);
        playerRepository.save(player);
    }
}
