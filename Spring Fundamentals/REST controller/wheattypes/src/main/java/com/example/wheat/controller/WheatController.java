package com.example.wheat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.wheat.entity.Wheat;
import com.example.wheat.service.WheatService;
import com.example.wheat.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wheat")
public class WheatController {

    @Autowired
    private WheatService wheatService;

    @GetMapping
    public List<Wheat> getAllWheats() {
        return wheatService.getAllWheats();
    }

    @GetMapping("/{id}")
    public Optional<Wheat> getWheatById(@PathVariable Long id) {
        return wheatService.getWheatById(id);
    }

    @PostMapping
    public Wheat createWheat(@RequestBody Wheat wheat) {
        return wheatService.saveWheat(wheat);
    }

    @PutMapping("/{id}")
    public Wheat updateWheat(@PathVariable Long id, @RequestBody Wheat wheatDetails) {
        Wheat wheat = wheatService.getWheatById(id).orElseThrow(() -> new ResourceNotFoundException("Wheat not found for this id :: " + id));
        
        wheat.setType(wheatDetails.getType());
        wheat.setDescription(wheatDetails.getDescription());

        return wheatService.saveWheat(wheat);
    }

    @DeleteMapping("/{id}")
    public void deleteWheat(@PathVariable Long id) {
        wheatService.deleteWheat(id);
    }
}
