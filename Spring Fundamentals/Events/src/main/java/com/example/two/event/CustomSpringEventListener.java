package com.example.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomSpringEventListener {
    @EventListener
    public void handleCustomEvent(CustomSpringEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }
}
