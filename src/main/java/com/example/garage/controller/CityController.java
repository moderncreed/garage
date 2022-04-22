package com.example.garage.controller;

import com.example.garage.data.CityData;
import com.example.garage.data.FuelData;
import com.example.garage.model.City;
import com.example.garage.model.Fuel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityData cityData;

    private static final Logger logger = LoggerFactory.getLogger(FuelController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cities",cityData.index());
        return "city/city";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("city", new City());
        return "city/add";
    }

    @PostMapping("/add")
    public String add(@Valid City city, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);
            return "city/add";
        } else {
            cityData.save(city);
            logger.info("Админ " + authentication.getName() + " добавил город " + city.getName());
            return "redirect:/city";
        }

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id , Authentication authentication) {
        City city = cityData.show(id);
        cityData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил город " + city.getName());
        return "redirect:/city";
    }
}
