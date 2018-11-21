package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Basket;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.util.List;

public class BasketRepositoryJdbcTemplateImpl implements BasketRepository {


    // класс из Spring Framework
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "SELECT\n" +
                    "  shop_user.name,\n" +
                    "  p2.name AS product\n" +
                    "FROM shop_user\n" +
                    "  JOIN basket b ON shop_user.id = b.user_id\n" +
                    "  JOIN basket_product p ON b.id = p.basket_id\n" +
                    "  JOIN product p2 ON p.product_id = p2.id WHERE shop_user.name = ?";

    //language=SQL
    private static final String SQL_INSERT_PRODUCT =
            "insert into product(name) values (?)";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from product where name = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
//            .id(resultSet.getLong("id"))
            .name(resultSet.getString("product"))
//            .cost(resultSet.getInt("cost"))
            .build();

    public BasketRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Product> findProductsByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper, name);
    }

    @Override
    public List<Basket> findAll() {
        return null;
    }

    @Override
    public Basket find(Long id) {
        return null;
    }

    @Override
    public void save(Basket model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Basket model) {

    }
}
