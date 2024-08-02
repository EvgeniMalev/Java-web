
package com.soccerapp.controller;

import com.soccerapp.model.OfferCreateBindingModel;
import com.soccerapp.service.LoggedUser;
import com.soccerapp.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class GameController {

    private final LoggedUser loggedUser;
    private final OfferService offerService;

    public GameController(LoggedUser loggedUser, GameService gameService) {
        this.loggedUser = loggedUser;
        this.gameService = gameService;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("offer-add");
    }

    @PostMapping("/create")
    public ModelAndView create(GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isCreated = gameService.create(gameCreateBindingModel);

        String view = isCreated ? "redirect:/home" : "create";
        return new ModelAndView(view);
    }

    @PostMapping("/start")
    public ModelAndView create(GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isStarted = gameService.create(gameStartedBindingModel);

        String view = isStarted ? "redirect:/home" : "start";
        return new ModelAndView(view);
    }

    @PostMapping("/finish")
    public ModelAndView create(GameCreateBindingModel gameCreateBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isFininsh = gameService.create(gameFinishedBindingModel);

        String view = isFinished ? "redirect:/home" : "start";
        return new ModelAndView(view);
    }


    @PostMapping("/record/{id}")
    public ModelAndView buyOffer(@PathVariable("id") UUID id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        
        gameService.record(id);
        return new ModelAndView("redirect:/home");
    }
}
