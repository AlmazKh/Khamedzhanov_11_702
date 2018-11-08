package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.repositories.ProductsRepository;
import ru.itis.repositories.ProductsRepositoryJdbcTemplateImpl;
import ru.itis.services.ProductsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/products")
public class BasketServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/web_shop");
        ProductsRepository productsRepository = new ProductsRepositoryJdbcTemplateImpl(dataSource);
        this.service = new ProductsServiceImpl(productsRepository);
    }


}
