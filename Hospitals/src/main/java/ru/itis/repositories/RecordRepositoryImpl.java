package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Hospital;

import javax.sql.DataSource;
import java.util.List;

public class RecordRepositoryImpl implements RecordRepository {

    // класс из Spring Framework
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_HOSPITALS=
            "SELECT * FROM hospital";

    public RecordRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Hospital> hospitalRowMapper = (resultSet, i) -> Hospital.builder()
            .id(resultSet.getLong("id"))
            .address(resultSet.getString("address"))
            .phone(resultSet.getString("phone"))
            .build();

    @Override
    public List<Hospital> getHospitals() {
        return jdbcTemplate.query(SQL_SELECT_HOSPITALS, hospitalRowMapper);
    }

    @Override
    public List<Hospital> findAll() {
        return null;
    }

    @Override
    public Hospital find(Long id) {
        return null;
    }

    @Override
    public void save(Hospital model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Hospital model) {

    }
}
