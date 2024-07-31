package com.example.soccerapp.controller;

import com.example.soccerapp.entity.Player;
import com.example.soccerapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerService.findAll());
        return "player-list";
    }

    @PostMapping
    public String savePlayer(@ModelAttribute Player player) {
        playerService.save(player);
        return "redirect:/players";
    }

    @GetMapping("/{id}")
    public String getPlayer(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.findById(id));
        return "player-details";
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
        return "redirect:/players";
    }
}
