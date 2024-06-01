package com.example.workhours.controller;

import com.example.workhours.model.Workhours;
import com.example.workhours.service.WorkhoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkhoursController {

    @Autowired
    private WorkhoursService workhoursService;

    @GetMapping("/workhours")
    public String getWorkhours(Model model) {
        List<Workhours> workhoursList = workhoursService.getAllWorkhours();
        model.addAttribute("workhoursList", workhoursList);
        return "workhours";
    }
}
