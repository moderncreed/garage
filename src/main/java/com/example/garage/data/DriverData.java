package com.example.garage.data;

import com.example.garage.data.mapper.DriverMapper;
import com.example.garage.model.Car;
import com.example.garage.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DriverData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Driver> index() {
        return jdbcTemplate.query("{call getDriver()}", new DriverMapper());
    }

    public void save(Driver driver) {
        jdbcTemplate.update("{call addDriver(?,?,?,?)}", driver.getName(),driver.getAge(),driver.getExp(),driver.getCar().getId());
    }

    public void delete (Long id) {
        jdbcTemplate.update("{call deleteDriver(?)}", id);
    }

    public Driver show(Long id) {
        return jdbcTemplate.queryForObject("{call showDriver(?)}", new Object[]{id}, new DriverMapper());
    }
}