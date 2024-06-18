package com.example;

import com.example.event.CustomSpringEventPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEventApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomSpringEventPublisher publisher) {
        return args -> {
            publisher.publishEvent("Hello, this is a custom event!");
        };
    }
}
