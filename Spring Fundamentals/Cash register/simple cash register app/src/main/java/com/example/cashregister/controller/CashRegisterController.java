package com.example.cashregister.controller;

import com.example.cashregister.model.Item;
import com.example.cashregister.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CashRegisterController {

    @Autowired
    private CashRegisterService cashRegisterService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("items", cashRegisterService.getItems());
        model.addAttribute("totalSum", cashRegisterService.getTotalSum());
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute Item item) {
        cashRegisterService.addItem(item);
        return "redirect:/";
    }

    @PostMapping("/finish")
    public String finishTransaction(Model model) {
        model.addAttribute("items", cashRegisterService.getItems());
        model.addAttribute("totalSum", cashRegisterService.getTotalSum());
        cashRegisterService.clearItems();
        return "index";
    }
}
