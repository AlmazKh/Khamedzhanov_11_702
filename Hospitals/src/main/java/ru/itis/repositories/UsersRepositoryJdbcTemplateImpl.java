package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;


public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    // класс из Spring Framework
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from patient where id = ?";

    //language=SQL
    private static final String SQL_INSERT_USER =
            "insert into patient(first_name, last_name, gender, phone, password_hash) values (?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_PHONE =
            "select * from patient where phone = ?";

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .gender(resultSet.getString("gender"))
            .phone(resultSet.getString("phone"))
            .hashPassword(resultSet.getString("password_hash"))
            .build();

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, id);
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(SQL_INSERT_USER, model.getFirstName(), model.getLastName(), model.getGender(), model.getPhone(), model.getHashPassword());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findByPhone(String phone) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_PHONE, userRowMapper, phone);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}