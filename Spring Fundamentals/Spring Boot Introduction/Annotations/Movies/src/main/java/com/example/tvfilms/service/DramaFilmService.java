package com.example.tvfilms.service;

import org.springframework.stereotype.Service;

@Service
public class DramaFilmService implements FilmService {
    @Override
    public String getFilmRecommendation() {
        return "Recommended Drama Film: 'Breaking Bad'";
    }
}
