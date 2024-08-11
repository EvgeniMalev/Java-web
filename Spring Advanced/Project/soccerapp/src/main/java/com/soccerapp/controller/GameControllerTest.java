package com.soccerapp.controller;

import com.soccerapp.service.GameService;
import com.soccerapp.service.PlayerService;
import com.soccerapp.service.impl.LoggedUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameControllerTest {

    @Mock
    private GameService gameService;

    @Mock
    private PlayerService playerService;

    @Mock
    private LoggedUser loggedUser;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRecordGoalWhenLogged() {
        UUID gameId = UUID.randomUUID();
        UUID playerId = UUID.randomUUID();

        when(loggedUser.isLogged()).thenReturn(true);

        ModelAndView mav = gameController.recordGoal(gameId, playerId);

        assertEquals("redirect:/home", mav.getViewName());

        verify(gameService, times(1)).record(gameId);
        verify(playerService, times(1)).incrementGoals(playerId);
    }

    @Test
    void testRecordGoalWhenNotLogged() {
        when(loggedUser.isLogged()).thenReturn(false);

        ModelAndView mav = gameController.recordGoal(UUID.randomUUID(), UUID.randomUUID());

        assertEquals("redirect:/login", mav.getViewName());

        verify(gameService, never()).record(any());
        verify(playerService, never()).incrementGoals(any());
    }
}
