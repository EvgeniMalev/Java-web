package com.soccerapp.controller;

import com.soccerapp.model.entity.Player;
import com.soccerapp.service.PlayerService;
import com.soccerapp.service.impl.LoggedUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private LoggedUser loggedUser;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPlayersWhenLogged() {
        UUID teamId = UUID.randomUUID();
        List<Player> players = new ArrayList<>();
        when(loggedUser.isLogged()).thenReturn(true);
        when(playerService.getPlayersByTeam(teamId)).thenReturn(players);

        ModelAndView mav = playerController.getPlayers(teamId);

        assertEquals("player", mav.getViewName());
        assertEquals(players, mav.getModel().get("players"));

        verify(playerService, times(1)).getPlayersByTeam(teamId);
    }

    @Test
    void testGetPlayersWhenNotLogged() {
        when(loggedUser.isLogged()).thenReturn(false);

        ModelAndView mav = playerController.getPlayers(UUID.randomUUID());

        assertEquals("redirect:/login", mav.getViewName());

        verify(playerService, never()).getPlayersByTeam(any());
    }
}
