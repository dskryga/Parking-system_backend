package ru.skriagin.ParkinSystemBack.repository.ParkingSpace;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ParkingSpaceRowMapper implements RowMapper<ParkingSpace> {
    @Override
    public ParkingSpace mapRow(ResultSet rs, int rowNum) throws SQLException {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setId(rs.getInt("id"));
        parkingSpace.setAvailable(rs.getBoolean("is_available"));
        parkingSpace.setNumber(rs.getString("number"));
        return parkingSpace;
    }
}
