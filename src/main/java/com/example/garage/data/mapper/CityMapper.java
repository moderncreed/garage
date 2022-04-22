package com.example.garage.data.mapper;

import com.example.garage.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setId(rs.getLong("c.id"));
        city.setName(rs.getString("c.name"));
        return city;
    }
}
