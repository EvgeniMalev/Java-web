package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/add")
    public ModelAndView showAddCarForm() {
        ModelAndView modelAndView = new ModelAndView("addCar");
        modelAndView.addObject("car", new Car());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCar(@RequestParam String model) {
        Car car = new Car();
        car.setModel(model);
        carService.saveCar(car);
        return "redirect:/car/add";
    }
}
