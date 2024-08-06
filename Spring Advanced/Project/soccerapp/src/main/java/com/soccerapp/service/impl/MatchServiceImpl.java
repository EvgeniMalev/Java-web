// app/src/main/java/com/soccerapp/service/impl/MatchServiceImpl.java
package com.soccerapp.service.impl;

import com.soccerapp.model.entity.Match;
import com.soccerapp.repository.MatchRepository;
import com.soccerapp.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match getMatchById(UUID id) {
        return matchRepository.findById(id).orElse(null);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match updateMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(UUID id) {
        matchRepository.deleteById(id);
    }
}
