package com.example.soccerapp.controller;

import com.example.soccerapp.entity.Stadium;
import com.example.soccerapp.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @GetMapping
    public String listStadiums(Model model) {
        model.addAttribute("stadiums", stadiumService.findAll());
        return "stadium-list";
    }

    @PostMapping
    public String saveStadium(@ModelAttribute Stadium stadium) {
        stadiumService.save(stadium);
        return "redirect:/stadiums";
    }

    @GetMapping("/{id}")
    public String getStadium(@PathVariable Long id, Model model) {
        model.addAttribute("stadium", stadiumService.findById(id));
        return "stadium-details";
    }

    @DeleteMapping("/{id}")
    public String deleteStadium(@PathVariable Long id) {
        stadiumService.deleteById(id);
        return "redirect:/stadiums";
    }
}
