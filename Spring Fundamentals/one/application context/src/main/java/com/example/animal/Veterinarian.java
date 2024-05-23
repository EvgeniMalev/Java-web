package com.example.animal;

import java.util.List;

public class Veterinarian {
    private List<Animal> animals;

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
