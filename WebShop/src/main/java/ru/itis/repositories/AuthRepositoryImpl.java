package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auth;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl implements AuthRepository {

    private JdbcTemplate template;

    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(user_id, cookie_value) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookie_value = ?";

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from auth JOIN shop_user u ON auth.user_id = u.id where auth.cookie_value = ?";

    public AuthRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Auth> authRowMapper = (rs, rowNum) -> Auth.builder()
            .id(rs.getLong("id"))
            .cookieValue(rs.getString("cookie_value"))
            .build();

    private RowMapper<User> userRowMapper = (rs, rowNum) -> User.builder()
            .name(rs.getString("name"))
            .build();

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Auth find(Long id) {
        return null;
    }

    @Override
    public void save(Auth model) {
        template.update(SQL_INSERT, model.getUser().getId(), model.getCookieValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Auth model) {

    }

    @Override
    public Optional<Auth> findByCookieValue(String cookieValue) {
        try {
            return Optional.of(template.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findOneByCookie(String cookieValue) {
        return Optional.of(template.queryForObject(SQL_SELECT_USER_BY_ID, userRowMapper, cookieValue));
    }
}
