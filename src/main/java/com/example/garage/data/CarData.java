package com.example.garage.data;

import com.example.garage.data.mapper.CarMapper;
import com.example.garage.data.mapper.FuelMapper;
import com.example.garage.model.Car;
import com.example.garage.model.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> index() {
        return jdbcTemplate.query("{call getCar()}", new CarMapper());
    }

    public void save(Car car) {
        jdbcTemplate.update("{call addCar(?,?)}",car.getBrand(),car.getFuel().getId());
    }

    public void delete (Long id) {
        jdbcTemplate.update("{call deleteCar(?)}", id);
    }

    public Car show(Long id) {
        return jdbcTemplate.queryForObject("{call showCar(?)}", new Object[]{id}, new CarMapper());
    }

}
