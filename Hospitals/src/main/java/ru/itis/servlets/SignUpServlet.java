package ru.itis.servlets;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.form.UserForm;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.services.UsersService;
import ru.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        this.usersService = new UsersServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserForm userForm = UserForm.builder()
                .firstName(req.getParameter("first_name"))
                .lastName(req.getParameter("last_name"))
                .gender(req.getParameter("gender"))
                .phone(req.getParameter("phone"))
                .password(req.getParameter("password"))
                .build();

        usersService.signUp(userForm);
        resp.sendRedirect("/login");
    }
}
