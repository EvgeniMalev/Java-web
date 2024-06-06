package com.example.demo.controller;

import com.example.demo.entity.Furniture;
import com.example.demo.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    @Autowired
    private FurnitureRepository furnitureRepository;

    @PostMapping("/add")
    public Furniture addFurniture(@RequestParam String name) {
        Furniture furniture = new Furniture(name);
        return furnitureRepository.save(furniture);
    }

    @GetMapping("/all")
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }
}
