package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.form.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.UserServiceImpl;
import ru.itis.services.UsersService;

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
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\Almaz\\Desktop\\Khamedzhanov_11_702\\Hospitals\\src\\main\\resources\\application.properties"));
        Connection connection =
                DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        usersService = new UserServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserForm userForm = UserForm.builder()
                .firstName(req.getParameter("firstname"))
                .lastName(req.getParameter("lastname"))
                .password(req.getParameter("password"))
                .build();

        usersService.signUp(userForm);
        resp.sendRedirect("/signUp");
    }
}
