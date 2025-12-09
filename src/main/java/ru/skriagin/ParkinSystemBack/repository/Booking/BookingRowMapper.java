package ru.skriagin.ParkinSystemBack.repository.Booking;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.skriagin.ParkinSystemBack.model.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookingRowMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        Booking booking = new Booking();
        booking.setId(rs.getLong("id"));
        booking.setCarId(rs.getInt("car_id"));
        booking.setParkingSpaceId(rs.getInt("space_id"));
        booking.setPaid(rs.getBoolean("is_paid"));
        return booking;
    }
}
