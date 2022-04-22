package com.example.garage.data;

import com.example.garage.data.mapper.DriverMapper;
import com.example.garage.data.mapper.FuelMapper;
import com.example.garage.model.Driver;
import com.example.garage.model.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuelData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FuelData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Fuel> index() {
        return jdbcTemplate.query("{call getFuel()}", new FuelMapper());
    }
    public void save(Fuel fuel) {
        jdbcTemplate.update("{call addFuel(?,?)}", fuel.getBrand(),fuel.getOctane());
    }

    public void delete (Long id) {
        jdbcTemplate.update("{call deleteFuel(?)}", id);
    }

     public Fuel show(Long id) {
        return jdbcTemplate.queryForObject("{call showFuel(?)}", new Object[]{id}, new FuelMapper());
     }

}
