package com.example.garage.data.mapper;

import com.example.garage.model.Car;
import com.example.garage.model.Driver;
import com.example.garage.model.Fuel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverMapper implements RowMapper<Driver> {
    @Override
    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
        Driver driver = new Driver();
        Car car = new Car();
        Fuel fuel = new Fuel();
        car.setId(rs.getLong("c.id"));
        car.setBrand(rs.getString("c.brand"));
        fuel.setId(rs.getLong("f.id"));
        fuel.setBrand(rs.getString("f.brand"));
        fuel.setOctane(rs.getInt("f.octane"));
        car.setFuel(fuel);
        driver.setId(rs.getLong("d.id"));
        driver.setName(rs.getString("d.name"));
        driver.setAge(rs.getInt("d.age"));
        driver.setExp(rs.getInt("d.exp"));
        driver.setCar(car);
        return driver;
    }
}
