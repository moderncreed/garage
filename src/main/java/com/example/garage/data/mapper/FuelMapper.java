package com.example.garage.data.mapper;

import com.example.garage.model.Fuel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuelMapper implements RowMapper<Fuel> {
    @Override
    public Fuel mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fuel fuel = new Fuel();
        fuel.setId(rs.getLong("f.id"));
        fuel.setBrand(rs.getString("f.brand"));
        fuel.setOctane(rs.getInt("f.octane"));
        return fuel;
    }
}
