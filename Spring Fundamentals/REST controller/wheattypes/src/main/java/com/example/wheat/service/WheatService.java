package com.example.wheat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wheat.entity.Wheat;
import com.example.wheat.repository.WheatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WheatService {

    @Autowired
    private WheatRepository wheatRepository;

    public List<Wheat> getAllWheats() {
        return wheatRepository.findAll();
    }

    public Optional<Wheat> getWheatById(Long id) {
        return wheatRepository.findById(id);
    }

    public Wheat saveWheat(Wheat wheat) {
        return wheatRepository.save(wheat);
    }

    public void deleteWheat(Long id) {
        wheatRepository.deleteById(id);
    }
}
