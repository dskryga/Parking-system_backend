package ru.skriagin.ParkinSystemBack.repository.Car;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.model.CarOwner;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setNumber(rs.getString("number"));

        CarOwner owner = new CarOwner();
        owner.setId(rs.getInt("owner_id"));
        owner.setFullName(rs.getString("full_name"));

        car.setOwner(owner);

        return car;
    }
}
