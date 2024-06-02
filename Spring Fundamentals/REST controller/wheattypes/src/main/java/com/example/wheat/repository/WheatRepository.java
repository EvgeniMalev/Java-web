package com.example.wheat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wheat.entity.Wheat;

public interface WheatRepository extends JpaRepository<Wheat, Long> {
}
