package com.soccerapp.repository;

import com.soccerapp.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    List<Player> findAllByTeamIdOrderByGoalsScoredDesc(UUID teamId);
}
