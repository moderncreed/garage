package com.example.garage.data.mapper;

import com.example.garage.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        Driver driver = new Driver();
        City city = new City();
        Car car = new Car();
        Fuel fuel = new Fuel();
        car.setId(rs.getLong("c2.id"));
        car.setBrand(rs.getString("c2.brand"));
        fuel.setId(rs.getLong("f.id"));
        fuel.setBrand(rs.getString("f.brand"));
        fuel.setOctane(rs.getInt("f.octane"));
        car.setFuel(fuel);
        driver.setId(rs.getLong("d.id"));
        driver.setName(rs.getString("d.name"));
        driver.setAge(rs.getInt("d.age"));
        driver.setExp(rs.getInt("d.exp"));
        driver.setCar(car);
        city.setId(rs.getLong("c.id"));
        city.setName(rs.getString("c.name"));
        order.setPrice(rs.getInt("o.price"));
        order.setDate(rs.getDate("o.date"));
        order.setCity(city);
        order.setDriver(driver);

        return order;
    }
}
