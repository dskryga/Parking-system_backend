package ru.skriagin.ParkinSystemBack.repository.Car;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.skriagin.ParkinSystemBack.Exception.NotFoundException;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.repository.Base.BaseRepository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class CarRepository extends BaseRepository<Car> {

    private static final String CREATE_QUERY = "INSERT INTO cars(number, owner_id) VALUES(?, ?) returning id;";
    private static final String GET_BY_ID_QUERY = """
            SELECT cars.id, number, owner_id, o.full_name FROM cars
            LEFT JOIN owners as o on cars.owner_id = o.id WHERE cars.id = ?;""";
    private static final String UPDATE_QUERY = "UPDATE cars SET number = ?, owner_id =? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM cars WHERE id = ?";
    private static final String SEARCH_BY_NUMBER_QUERY = """
            SELECT cars.id, number, owner_id, o.full_name
            FROM cars LEFT JOIN owners as o on cars.owner_id = o.id
            WHERE cars.number ILIKE ?;""";

    public CarRepository(JdbcTemplate jdbcTemplate, RowMapper<Car> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public Car create(Car car) {
        Integer id = insertAndReturnId(CREATE_QUERY, Integer.class, car.getNumber(), car.getOwner().getId());
        if (id == null) return null;
        car.setId(id);
        return car;
    }

    public Car getById(int id) {
        Optional<Car> carOpt = getOne(GET_BY_ID_QUERY, id);
        return carOpt.orElseThrow(() -> new NotFoundException("Car not found. Id: " + id));
    }

    public Car update(Car car) {
        super.update(UPDATE_QUERY, car.getNumber(), car.getOwner().getId(), car.getId());
        return getById(car.getId());
    }

    public void delete(int id) {
        super.delete(DELETE_QUERY, id);
    }

    public Collection<Car> searchByNumber(String number) {
        String searchPattern = "%" + number + "%";
        return getMany(SEARCH_BY_NUMBER_QUERY, searchPattern);
    }
}
