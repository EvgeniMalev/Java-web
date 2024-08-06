// app/src/main/java/com/soccerapp/service/MatchService.java
package com.soccerapp.service;

import com.soccerapp.model.entity.Match;

import java.util.List;
import java.util.UUID;

public interface MatchService {
    Match createMatch(Match match);
    Match getMatchById(UUID id);
    List<Match> getAllMatches();
    Match updateMatch(Match match);
    void deleteMatch(UUID id);
}
