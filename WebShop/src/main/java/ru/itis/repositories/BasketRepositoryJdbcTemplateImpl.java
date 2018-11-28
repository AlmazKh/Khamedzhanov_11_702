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
    private static final String SQL_SELECT_USER_BASKET =
            "SELECT basket.user_id FROM basket WHERE user_id = ?";

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO basket (user_id) VALUES (?)";

    //language=SQL
    private static final String SQL_SELECT_BASKET_BY_ID =
            "SELECT id FROM basket WHERE user_id = ?";

    //language=SQL
    private static final String SQL_INSERT_BASKET_PRODUCT =
            "INSERT INTO basket_product (basket_id, product_id, count) VALUES (?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "SELECT * FROM basket\n"+
                    "JOIN basket_product bp ON bp.basket_id = basket.id\n" +
                    "JOIN product p ON bp.product_id = p.id\n WHERE user_id = ?";

    //language=SQL
    private static final String SQL_DELETE_PRODUCT =
            "DELETE FROM basket_product WHERE basket_id = ? AND product_id = ?";

    //language=SQL
    private static final String SQL_SELECT_COUNT =
            "SELECT count FROM basket_product WHERE basket_id = ? AND product_id = ?";

    //language=SQL
    private static final String SQL_UPDATE_COUNT =
            "UPDATE basket_product SET count = ? WHERE basket_id = ? AND product_id = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .name(resultSet.getString("name"))
//            .cost(resultSet.getInt("cost"))
            .build();

    private RowMapper<Product> productWithCountRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .name(resultSet.getString("name"))
            .count(resultSet.getInt("count"))
//            .cost(resultSet.getInt("cost"))
            .build();

    private RowMapper<Long> basketIdRowMapper = (resultSet, i) -> resultSet.getLong("id");

    private RowMapper<Integer> countRowMapper = (resultSet, i) -> resultSet.getInt("count");

    @Override
    public List<Product> findProductsByName(String name) {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper, name);
    }

    public BasketRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addBasket(Long userId, Long productId) {
        jdbcTemplate.update(SQL_INSERT_USER, userId);
    }

    @Override
    public void addProduct(Long userId, Long productId) {
        Long basketId = jdbcTemplate.query(SQL_SELECT_BASKET_BY_ID, basketIdRowMapper, userId).get(0);
        jdbcTemplate.update(SQL_INSERT_BASKET_PRODUCT, basketId, productId, 1);
//        jdbcTemplate.update(SQL_UPDATE_COUNT, getProductsByUserId(userId).size() + 1);
    }

    @Override
    public void deleteProduct(Long userId, Long productId) {
        Long basketId = jdbcTemplate.query(SQL_SELECT_BASKET_BY_ID, basketIdRowMapper, userId).get(0);
        jdbcTemplate.update(SQL_DELETE_PRODUCT, basketId, productId);
    }


    @Override
    public List<Product> getProductsByUserId(Long userId) {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productWithCountRowMapper, userId);
    }

    @Override
    public Integer getCount(Long userId, Long productId) {
        Long basketId = jdbcTemplate.query(SQL_SELECT_BASKET_BY_ID, basketIdRowMapper, userId).get(0);
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_COUNT, countRowMapper, basketId, productId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateCount(Long userId, Long productId, Integer count) {
        Long basketId = jdbcTemplate.query(SQL_SELECT_BASKET_BY_ID, basketIdRowMapper, userId).get(0);
        jdbcTemplate.update(SQL_UPDATE_COUNT, count, basketId, productId);
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
