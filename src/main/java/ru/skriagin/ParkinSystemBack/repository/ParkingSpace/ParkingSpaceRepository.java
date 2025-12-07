package ru.skriagin.ParkinSystemBack.repository.ParkingSpace;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.skriagin.ParkinSystemBack.Exception.NotFoundException;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.repository.Base.BaseRepository;

import java.util.Optional;

@Repository
public class ParkingSpaceRepository extends BaseRepository<ParkingSpace> {

    private static final String INSERT_QUERY = "INSERT INTO parking_spaces(is_available, number) VALUES (?, ?) returning id;";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM parking_spaces WHERE id = ?;";
    private static final String UPDATE_QUERY = "UPDATE parking_spaces SET is_available = ?, number = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM parking_spaces WHERE id = ?";

    public ParkingSpaceRepository(JdbcTemplate jdbcTemplate, RowMapper<ParkingSpace> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public ParkingSpace create(ParkingSpace parkingSpace) {
        Integer id = insertAndReturnId(INSERT_QUERY, Integer.class, parkingSpace.isAvailable(), parkingSpace.getNumber());
        if (id == null) return null;
        parkingSpace.setId(id);
        return parkingSpace;
    }

    public ParkingSpace getById(int id) {
        Optional<ParkingSpace> parkingSpaceOpt = getOne(GET_BY_ID_QUERY, id);
        return parkingSpaceOpt.orElseThrow(() -> new NotFoundException("Parking space not found. Id: " + id));
    }

    public ParkingSpace update(ParkingSpace parkingSpace) {
        super.update(UPDATE_QUERY, parkingSpace.isAvailable(), parkingSpace.getNumber(), parkingSpace.getId());
        return getById(parkingSpace.getId());
    }

    public void delete(int id) {
        super.delete(DELETE_QUERY, id);
    }
}
