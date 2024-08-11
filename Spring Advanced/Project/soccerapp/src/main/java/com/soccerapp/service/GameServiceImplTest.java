package com.soccerapp.service;

import com.soccerapp.model.entity.Match;
import com.soccerapp.repository.MatchRepository;
import com.soccerapp.service.impl.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

class GameServiceImplTest {

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRecord() {
        UUID gameId = UUID.randomUUID();
        UUID playerId = UUID.randomUUID();

        Match match = new Match();
        match.setId(gameId);

        when(matchRepository.findById(gameId)).thenReturn(Optional.of(match));

        gameService.record(gameId, playerId);

        verify(matchRepository, times(1)).findById(gameId);
        verify(playerService, times(1)).incrementGoals(playerId);
    }
}
