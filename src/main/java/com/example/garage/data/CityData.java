package com.example.garage.data;

import com.example.garage.data.mapper.CityMapper;
import com.example.garage.data.mapper.FuelMapper;
import com.example.garage.model.City;
import com.example.garage.model.Fuel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> index() {
        return jdbcTemplate.query("{call getCity()}", new CityMapper());
    }
    public void save(City city) {
        jdbcTemplate.update("{call addCity(?)}", city.getName());
    }

    public void delete (Long id) {
        jdbcTemplate.update("{call deleteCity(?)}", id);
    }

    public City show(Long id) {
        return jdbcTemplate.queryForObject("{call showCity(?)}", new Object[]{id}, new CityMapper());
    }

}