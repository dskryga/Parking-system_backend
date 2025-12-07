package ru.skriagin.ParkinSystemBack.repository.CarOwner;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.skriagin.ParkinSystemBack.model.CarOwner;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class CarOwnerRowMapper implements RowMapper<CarOwner> {

    @Override
    public CarOwner mapRow(ResultSet rs, int rowNum) throws SQLException {
        CarOwner carOwner = new CarOwner();
        carOwner.setFullName(rs.getString("full_name"));
        return carOwner;
    }
}
