package com.paintingscollectors.controller;

import com.paintingscollectors.model.User;
import com.paintingscollectors.model.dto.LoginDTO;
import com.paintingscollectors.model.dto.RegisterDTO;
import com.paintingscollectors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @RequestMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("loginDTO")) {
            model.addAttribute("loginDTO", new LoginDTO());
        }
        return "login";
    }

    @Override
    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("loginDTO") LoginDTO loginDTO,
                               BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", result);
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            return "redirect:/users/login";
        }

       
        return "redirect:/home";
    }

    @Override
    @RequestMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("registerDTO")) {
            model.addAttribute("registerDTO", new RegisterDTO());
        }
        return "register";
    }

    @Override
    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO,
                                  BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", result);
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            return "redirect:/users/register";
        }

        
        return "redirect:/users/login";
    }

    @Override
    @RequestMapping("/logout")
    public String logout() {
        // Implement logout logic here
        return "redirect:/users/login";
    }

    @ModelAttribute("loginDTO")
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute("registerDTO")
    public RegisterDTO registerDTO() {
        return new RegisterDTO();
    }
}
