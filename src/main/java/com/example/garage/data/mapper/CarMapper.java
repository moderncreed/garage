package com.example.garage.data.mapper;

import com.example.garage.model.Car;
import com.example.garage.model.Fuel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        Fuel fuel = new Fuel();
        car.setId(rs.getLong("c2.id"));
        car.setBrand(rs.getString("c2.brand"));
        fuel.setId(rs.getLong("f.id"));
        fuel.setBrand(rs.getString("f.brand"));
        fuel.setOctane(rs.getInt("f.octane"));
        car.setFuel(fuel);
        return car;
    }
}
