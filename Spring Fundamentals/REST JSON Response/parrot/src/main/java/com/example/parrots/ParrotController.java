package com.example.parrots;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParrotController {

    @GetMapping("/parrot")
    public Parrot getParrot() {
        return new Parrot("Polly", "African Grey", 3);
    }
}
