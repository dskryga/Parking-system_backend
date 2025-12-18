package ru.skriagin.ParkinSystemBack.repository.CarOwner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.skriagin.ParkinSystemBack.Exception.NotFoundException;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.repository.Base.BaseRepository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class CarOwnerRepository extends BaseRepository<CarOwner> {

    private static final String INSERT_QUERY = "INSERT INTO owners(full_name) VALUES(?) returning id;";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM owners WHERE ID = ?;";
    private static final String GET_BY_FULLNAME_QUERY = "SELECT * FROM owners WHERE full_name ILIKE ?;";
    private static final String GET_ALL = "SELECT * FROM owners";
    private static final String UPDATE_QUERY = "UPDATE owners SET full_name =? WHERE id=?;";
    private static final String DELETE_QUERY = "DELETE FROM owners WHERE id = ?;";
    private static final String CHECK_EXISTS_QUERY = "SELECT COUNT(*)>0 FROM owners where id = ?;";


    public CarOwnerRepository(JdbcTemplate jdbcTemplate, RowMapper<CarOwner> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public CarOwner create(CarOwner carOwner) {
        Integer id = insertAndReturnId(INSERT_QUERY, Integer.class, carOwner.getFullName());
        if (id == null) return null;
        carOwner.setId(id);
        return carOwner;
    }

    public CarOwner getById(int id) {
        Optional<CarOwner> carOwnerOpt = getOne(GET_BY_ID_QUERY, id);
        return carOwnerOpt.orElseThrow(() -> new NotFoundException("CarOwner not found. Id: " + id));
    }

    public CarOwner update(CarOwner carOwner) {
        super.update(UPDATE_QUERY, carOwner.getFullName(), carOwner.getId());
        return getById(carOwner.getId());
    }

    public Collection<CarOwner> getByFullName(String fullName) {
        String searchPattern = "%" + fullName + "%";
        return getMany(GET_BY_FULLNAME_QUERY, searchPattern);
    }

    public Collection<CarOwner> getAll() {
        return getMany(GET_ALL);
    }

    public void delete(int id) {
        super.delete(DELETE_QUERY, id);
    }

    public boolean isExists(CarOwner carOwner) {
        return super.isExists(CHECK_EXISTS_QUERY, carOwner.getId());
    }
}
