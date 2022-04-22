package com.example.garage.data;

import com.example.garage.data.mapper.FuelMapper;
import com.example.garage.data.mapper.OrderMapper;
import com.example.garage.model.Fuel;
import com.example.garage.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> index() {
        return jdbcTemplate.query("{call getOrder()}", new OrderMapper());
    }

    public void save(Order order) {
        jdbcTemplate.update("{call addOrder(?,?,?,?)}", order.getPrice(),order.getDate(),order.getCity().getId(),order.getDriver().getId());
    }


}