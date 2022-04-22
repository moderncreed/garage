package com.example.garage.controller;

import com.example.garage.data.CityData;
import com.example.garage.data.DriverData;
import com.example.garage.data.OrderData;
import com.example.garage.model.Order;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderData orderData;
    @Autowired
    DriverData driverData;
    @Autowired
    CityData cityData;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("orders", orderData.index());
        return "order/order";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("order",new Order());
        model.addAttribute("drivers", driverData.index());
        model.addAttribute("cities", cityData.index());
        return "order/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("order") Order order, BindingResult bindingResult, @RequestParam("driver") Long id, @RequestParam("city") Long idC,
                      Authentication authentication) {
        order.setDriver(driverData.show(id));
        order.setCity(cityData.show(idC));
        orderData.save(order);
        logger.info("Админ " + authentication.getName() + " добавил заказ " + order.getDate() + " " + order.getDriver().getName() + " " +
                        order.getDriver().getCar().getBrand()+ " цена " + order.getPrice());
        return "redirect:/order";

    }



}
