package com.example;

import com.example.animal.AnimalShelter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        AnimalShelter animalShelter = context.getBean("animalShelter", AnimalShelter.class);
        System.out.println("Veterinarian has the following animals:");
        animalShelter.getVeterinarian().getAnimals().forEach(animal -> 
            System.out.println(animal.getName() + " (" + animal.getAge() + " years old)")
        );
    }
}
