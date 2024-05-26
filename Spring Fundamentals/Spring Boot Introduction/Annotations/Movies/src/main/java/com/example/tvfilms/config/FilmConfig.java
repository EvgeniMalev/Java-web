package com.example.tvfilms.config;

import com.example.tvfilms.service.DramaFilmService;
import com.example.tvfilms.service.FilmService;
import com.example.tvfilms.service.SciFiFilmService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmConfig {

    @Bean
    @ConditionalOnProperty(name = "film.type", havingValue = "scifi", matchIfMissing = true)
    public FilmService sciFiFilmService() {
        return new SciFiFilmService();
    }

    @Bean
    @ConditionalOnProperty(name = "film.type", havingValue = "drama")
    public FilmService dramaFilmService() {
        return new DramaFilmService();
    }

    @Bean
    @ConditionalOnResource(resources = "classpath:customResource.txt")
    public FilmService resourceDependentFilmService() {
        return () -> "Recommended Film based on resource availability: 'Resource Driven Film'";
    }
}
