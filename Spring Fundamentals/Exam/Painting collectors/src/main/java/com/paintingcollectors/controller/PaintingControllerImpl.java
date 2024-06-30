package com.paintingscollectors.controller;

import com.paintingscollectors.model.Painting;
import com.paintingscollectors.model.User;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paintings")
public class PaintingControllerImpl implements PaintingController {

    private final PaintingService paintingService;
    private final UserService userService;

    @Autowired
    public PaintingControllerImpl(PaintingService paintingService, UserService userService) {
        this.paintingService = paintingService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Override
    public String viewPaintingDetails(@PathVariable String id, Model model) {
        Painting painting = paintingService.findById(id);
        model.addAttribute("painting", painting);
        return "painting-details";
    }

    @PostMapping("/{id}/favorite")
    @Override
    public String addToFavorites(@PathVariable String id) {
        Painting painting = paintingService.findById(id);
        User currentUser = userService.getCurrentUser();
        
        if (currentUser != null) {
            currentUser.addToFavorites(painting);
            userService.save(currentUser);
        }
        
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    @Override
    public String editPainting(@PathVariable String id, Model model) {
        Painting painting = paintingService.findById(id);
        model.addAttribute("painting", painting);
        return "edit-painting";
    }

    @PostMapping("/{id}/edit")
    @Override
    public String updatePainting(@PathVariable String id, @Valid Painting painting, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-painting";
        }
        
        paintingService.save(painting);
        return "redirect:/paintings/" + id;
    }

    @GetMapping("/{id}/delete")
    @Override
    public String deletePainting(@PathVariable String id) {
        paintingService.deleteById(id);
        return "redirect:/home";
    }
}
