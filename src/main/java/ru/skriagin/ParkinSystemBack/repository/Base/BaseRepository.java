package ru.skriagin.ParkinSystemBack.repository.Base;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepository<T> {
    protected final JdbcTemplate jdbcTemplate;
    protected final RowMapper<T> rowMapper;


    protected <K> K insertAndReturnId(String sql, Class<K> clazz, Object... args) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps;
        }, keyHolder);
        return keyHolder.getKeyAs(clazz);
    }

    protected Optional<T> getOne(String sql, Object... args) {
        try {
            T result = jdbcTemplate.queryForObject(sql, rowMapper, args);
            return Optional.ofNullable(result);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    protected Collection<T> getMany(String sql, Object... args) {
        return jdbcTemplate.query(sql, rowMapper, args);
    }

    protected int update(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }

    protected int delete(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }
}
