package com.example.garage.controller;

import com.example.garage.data.CarData;
import com.example.garage.data.DriverData;
import com.example.garage.model.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverData driverData;

    @Autowired
    CarData carData;

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("drivers", driverData.index());
        return "driver/driver";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("driver", new Driver());
        model.addAttribute("cars", carData.index());
        return "driver/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("driver") Driver driver,BindingResult bindingResult, @RequestParam(name = "car") Long id,
                      Model model, Authentication authentication) {
        driver.setCar(carData.show(id));
        driverData.save(driver);
        logger.info("Админ " + authentication.getName() + " добавил водителя " + driver.getName() + " " + driver.getCar().getBrand());
        return "redirect:/driver";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id , Authentication authentication) {
        Driver driver = driverData.show(id);
        driverData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил водителя " + driver.getName());
        return "redirect:/driver";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("driver", driverData.show(id));
        model.addAttribute("count", driverData.count(id));
        return "driver/show";
    }
}
