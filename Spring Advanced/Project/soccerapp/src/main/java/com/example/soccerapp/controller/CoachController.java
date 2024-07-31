package com.example.soccerapp.controller;

import com.example.soccerapp.entity.Coach;
import com.example.soccerapp.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping
    public String listCoaches(Model model) {
        model.addAttribute("coaches", coachService.findAll());
        return "coach-list";
    }

    @PostMapping
    public String saveCoach(@ModelAttribute Coach coach) {
        coachService.save(coach);
        return "redirect:/coaches";
    }

    @GetMapping("/{id}")
    public String getCoach(@PathVariable Long id, Model model) {
        model.addAttribute("coach", coachService.findById(id));
        return "coach-details";
    }

    @DeleteMapping("/{id}")
    public String deleteCoach(@PathVariable Long id) {
        coachService.deleteById(id);
        return "redirect:/coaches";
    }
}
