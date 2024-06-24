package com.paintingscollectors.init;

import com.paintingscollectors.service.StyleService;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstInit implements CommandLineRunner {

    private final StyleService styleService;
    private final UserService userService;
    private final PaintingService paintingService;

    public FirstInit(StyleService styleService,
                     UserService userService,
                     PaintingService paintingService) {
        this.styleService = styleService;
        this.userService = userService;
        this.paintingService = paintingService;
    }

    @Override
    public void run(String... args) {
        this.userService.initAdmin();
        this.userService.initTest();
        this.styleService.initStyles();
        this.paintingService.addTestPainting();
    }
}
