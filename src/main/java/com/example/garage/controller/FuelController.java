package com.example.garage.controller;

import com.example.garage.data.FuelData;
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
@RequestMapping("/fuel")
public class FuelController {

    @Autowired
    FuelData fuelData;

    private static final Logger logger = LoggerFactory.getLogger(FuelController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("fuels",fuelData.index());
        return "fuel/fuel";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("fuel", new Fuel());
        return "fuel/add";
    }

    @PostMapping("/add")
    public String add(@Valid Fuel fuel, BindingResult bindingResult, Model model, Authentication authentication) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);
            return "fuel/add";
        } else {
            fuelData.save(fuel);
            logger.info("Админ " + authentication.getName() + " добавил топливо " + fuel.getBrand() + " " + fuel.getOctane());
            return "redirect:/fuel";
        }

    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id , Authentication authentication) {
        Fuel fuel = fuelData.show(id);
        fuelData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил топливо " + fuel.getBrand() + " " + fuel.getOctane());
        return "redirect:/fuel";
    }
}
