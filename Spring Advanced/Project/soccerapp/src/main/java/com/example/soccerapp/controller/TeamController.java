package com.example.soccerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.soccerapp.entity.Team;
import com.example.soccerapp.service.TeamService;

import java.util.List;

@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String listTeams(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "teams/list";
    }

    @GetMapping("/{id}")
    public String viewTeam(@PathVariable Long id, Model model) {
        Team team = teamService.findById(id);
        if (team == null) {
            return "error/404";
        }
        model.addAttribute("team", team);
        return "teams/view";
    }

    @GetMapping("/new")
    public String newTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "teams/new";
    }

    @PostMapping
    public String createTeam(@ModelAttribute Team team) {
        teamService.save(team);
        return "redirect:/teams";
    }

    @GetMapping("/{id}/edit")
    public String editTeamForm(@PathVariable Long id, Model model) {
        Team team = teamService.findById(id);
        if (team == null) {
            return "error/404";
        }
        model.addAttribute("team", team);
        return "teams/edit";
    }

    @PostMapping("/{id}")
    public String updateTeam(@PathVariable Long id, @ModelAttribute Team team) {
        Team existingTeam = teamService.findById(id);
        if (existingTeam == null) {
            return "error/404";
        }
        existingTeam.setName(team.getName());
        existingTeam.setGamesWon(team.getGamesWon());
        existingTeam.setCountry(team.getCountry());
        existingTeam.setCoach(team.getCoach());
        existingTeam.setStadium(team.getStadium());
        teamService.save(existingTeam);
        return "redirect:/teams";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return "redirect:/teams";
    }

    @GetMapping("/rankings")
    public String viewRankings(Model model) {
        List<Team> teams = teamService.findAll();
        teams.sort((t1, t2) -> Integer.compare(t2.getGamesWon(), t1.getGamesWon()));
        model.addAttribute("teams", teams);
        return "teams/rankings";
    }
}
