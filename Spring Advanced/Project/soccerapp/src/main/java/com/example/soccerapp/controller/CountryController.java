package com.example.soccerapp.controller;

import com.example.soccerapp.entity.Country;
import com.example.soccerapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public String listCountries(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "country-list";
    }

    @PostMapping
    public String saveCountry(@ModelAttribute Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/{id}")
    public String getCountry(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryService.findById(id));
        return "country-details";
    }

    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
        return "redirect:/countries";
    }
}
