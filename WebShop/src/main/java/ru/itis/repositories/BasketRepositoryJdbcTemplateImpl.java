//package ru.itis.repositories;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import ru.itis.models.Basket;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//public class BasketRepositoryJdbcTemplateImpl implements BasketRepository {
//
//
//    // класс из Spring Framework
//    private JdbcTemplate jdbcTemplate;
//
//    //language=SQL
//    private static final String SQL_SELECT_PRODUCT_BY_ID =
//            "select * from product where id = ?";
//
//    //language=SQL
//    private static final String SQL_SELECT_ALL_PRODUCTS =
//            "select * from product";
//
//    //language=SQL
//    private static final String SQL_INSERT_PRODUCT =
//            "insert into product(name) values (?)";
//
//    //language=SQL
//    private static final String SQL_SELECT_BY_NAME =
//            "select * from product where name = ?";
//
//    private RowMapper<P> productRowMapper = (resultSet, i) -> Product.builder()
//            .id(resultSet.getLong("id"))
//            .name(resultSet.getString("name"))
//            .cost(resultSet.getInt("cost"))
//            .build();
//
//    public ProductsRepositoryJdbcTemplateImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//    @Override
//    public Basket findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public List<Basket> findAll() {
//        return null;
//    }
//
//    @Override
//    public Basket find(Long id) {
//        return null;
//    }
//
//    @Override
//    public void save(Basket model) {
//
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public void update(Basket model) {
//
//    }
//}
