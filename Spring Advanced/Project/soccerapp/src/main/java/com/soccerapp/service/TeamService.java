package com.soccerapp.service;

import com.soccerapp.model.entity.Team;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    Team createTeam(Team team);
    Team getTeamById(UUID id);
    List<Team> getAllTeams();
    Team updateTeam(Team team);
    void deleteTeam(UUID id);
}
