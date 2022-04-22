package com.example.garage.controller;

import com.example.garage.data.CarData;
import com.example.garage.data.FuelData;
import com.example.garage.model.Car;
import com.example.garage.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarData carData;
    @Autowired
    FuelData fuelData;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cars",carData.index());

        return "car/car";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("fuels",fuelData.index());
        return "car/add";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public String add(@ModelAttribute(name = "car") Car car, BindingResult bindingResult,@RequestParam(name = "fuel") Long id,
                      Model model, Authentication authentication) {

            car.setFuel(fuelData.show(id));
            carData.save(car);
            logger.info("Админ " + authentication.getName() + " добавил машину " + car.getBrand());
            return "redirect:/car";
        }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id , Authentication authentication) {
        Car car = carData.show(id);
        carData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил машину " + car.getBrand());
        return "redirect:/car";
    }
}
