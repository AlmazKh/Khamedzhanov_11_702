package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;

public class ProductsRepositoryJdbcTemplateImpl implements ProductsRepository {

    // класс из Spring Framework
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "select * from product";

    //language=SQL
    private static final String SQL_INSERT_PRODUCT =
            "insert into product(name) values (?)";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from product where name = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("product_id"))
            .cost(resultSet.getInt("cost"))
            .build();

    public ProductsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Product findByName(String name) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, productRowMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper);
    }

    @Override
    public Product find(Long id) {
        return null;
    }

    @Override
    public void save(Product model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product model) {

    }
}
