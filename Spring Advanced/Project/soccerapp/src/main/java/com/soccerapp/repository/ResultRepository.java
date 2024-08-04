package com.soccerapp.repository;

import com.soccerapp.model.entity.Result;
import com.soccerapp.model.enums.ResultName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResultRepository extends JpaRepository<Result, UUID> {
    Condition findByName(ResultName result);
}
