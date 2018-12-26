package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.form.FeedbackForm;
import ru.itis.models.Feedback;

import javax.sql.DataSource;
import java.util.List;

public class FeedbackRepositoryImpl implements FeedbackRepository {

    JdbcTemplate jdbcTemplate;

    public FeedbackRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_INSERT_FEEDBACK=
            "INSERT INTO feedback (name, phone, email, text) VALUES (?, ?, ?, ?)";


    @Override
    public List<Feedback> findAll() {
        return null;
    }

    @Override
    public Feedback find(Long id) {
        return null;
    }

    @Override
    public void save(Feedback model) {
        jdbcTemplate.update(SQL_INSERT_FEEDBACK, model.getName(), model.getPhone(), model.getEmail(), model.getText());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Feedback model) {

    }
}
