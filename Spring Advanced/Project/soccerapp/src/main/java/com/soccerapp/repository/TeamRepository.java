// app/src/main/java/com/soccerapp/repository/TeamRepository.java
package com.soccerapp.repository;

import com.soccerapp.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
}
