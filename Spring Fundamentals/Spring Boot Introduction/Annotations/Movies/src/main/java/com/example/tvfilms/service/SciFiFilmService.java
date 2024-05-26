package com.example.tvfilms.service;

import org.springframework.stereotype.Service;

@Service
public class SciFiFilmService implements FilmService {
    @Override
    public String getFilmRecommendation() {
        return "Recommended Sci-Fi Film: 'Star Trek: The Next Generation'";
    }
}
