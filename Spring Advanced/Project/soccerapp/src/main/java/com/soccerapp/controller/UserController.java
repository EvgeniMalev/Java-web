package com.soccerapp.controller;

import com.soccerapp.model.dto.user.UserLoginBindingModel;
import com.soccerapp.model.dto.user.UserRegisterBindingModel;
import com.soccerapp.service.UserService;
import com.soccerapp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLogin", new UserLoginBindingModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userLogin") UserLoginBindingModel userLogin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        boolean loginSuccessful = userService.authenticate(userLogin.getUsername(), userLogin.getPassword());
        if (loginSuccessful) {
            return "redirect:/home";
        }
        model.addAttribute("hasLoginError", true);
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userRegister", new UserRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegister") UserRegisterBindingModel userRegister, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.register(userRegister);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate the session
        request.getSession().invalidate();
        return "redirect:/login"; // Redirect to login page
    }
}
