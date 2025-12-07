package ru.skriagin.ParkinSystemBack.repository.CarOwner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.repository.Base.BaseRepository;

@Repository
public class CarOwnerRepository extends BaseRepository<CarOwner> {

    private static final String INSERT_QUERY = "INSERT INTO owners(full_name) VALUES(?) returning id;";


    public CarOwnerRepository(JdbcTemplate jdbcTemplate, RowMapper<CarOwner> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public CarOwner
}
