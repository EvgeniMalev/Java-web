package com.paintingscollectors.controller;

import com.paintingscollectors.model.Painting;
import com.paintingscollectors.model.User;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeControllerImpl implements HomeController {

    private final UserService userService;
    private final PaintingService paintingService;

    public HomeControllerImpl(UserService userService, PaintingService paintingService) {
        this.userService = userService;
        this.paintingService = paintingService;
    }

    @GetMapping
    @Override
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    @Override
    public String home(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        List<Painting> myPaintings = paintingService.findByOwner(user);
        List<Painting> myFavoritePaintings = user.getFavoritePaintings();
        List<Painting> otherPaintings = paintingService.findAllOtherPaintings(user.getId());

        model.addAttribute("myPaintings", myPaintings);
        model.addAttribute("myFavoritePaintings", myFavoritePaintings);
        model.addAttribute("otherPaintings", otherPaintings);

        return "home";
    }

    @GetMapping("/add-painting")
    public String addPaintingForm(Model model) {
        model.addAttribute("painting", new Painting());
        return "add-painting";
    }

    @PostMapping("/add-painting")
    public String addPaintingSubmit(@ModelAttribute Painting painting, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        painting.setOwner(user);
        paintingService.save(painting);

        return "redirect:/home";
    }

}
