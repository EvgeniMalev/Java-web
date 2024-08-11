package com.soccerapp.service;

import com.soccerapp.model.entity.Player;
import com.soccerapp.model.entity.Team;
import com.soccerapp.repository.PlayerRepository;
import com.soccerapp.repository.TeamRepository;
import com.soccerapp.service.impl.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPlayer() {
        UUID teamId = UUID.randomUUID();
        Team team = new Team();
        team.setId(teamId);

        when(teamRepository.findById(teamId)).thenReturn(Optional.of(team));
        when(playerRepository.save(any(Player.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Player player = playerService.addPlayer("John Doe", teamId);

        assertNotNull(player);
        assertEquals("John Doe", player.getName());
        assertEquals(team, player.getTeam());

        verify(teamRepository, times(1)).findById(teamId);
        verify(playerRepository, times(1)).save(any(Player.class));
    }

    @Test
    void testIncrementGoals() {
        UUID playerId = UUID.randomUUID();
        Player player = new Player();
        player.setId(playerId);
        player.setGoalsScored(2);

        when(playerRepository.findById(playerId)).thenReturn(Optional.of(player));

        playerService.incrementGoals(playerId);

        assertEquals(3, player.getGoalsScored());

        verify(playerRepository, times(1)).findById(playerId);
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    void testGetPlayersByTeam() {
        UUID teamId = UUID.randomUUID();

        playerService.getPlayersByTeam(teamId);

        verify(playerRepository, times(1)).findAllByTeamIdOrderByGoalsScoredDesc(teamId);
    }
}
