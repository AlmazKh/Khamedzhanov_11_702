package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Reception;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class ReceptionHistoryServlet extends HttpServlet {

    private ComponentsRepository componentsRepository;
    private ComponentsService componentsService;
    private LoginService loginService;
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
        componentsRepository = new ComponentsRepositoryImpl(dataSource);
        componentsService = new ComponentsServiceImpl(componentsRepository);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepository);
        loginService = new LoginServiceImpl(authRepository, usersRepository);
    }

    private User currentUser(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        try {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    if (loginService.isExistByCookie(cookie.getValue())) {
                        return loginService.getIdByCookie(cookie.getValue());
                    }
                }
            }
            return null;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Reception> receptions = componentsService.getReception(currentUser(req).getId());
        List<Doctor> doctors = componentsService.getDoctorsNameById(currentUser(req).getId());
        req.setAttribute("receptions", receptions);
        req.setAttribute("doctors", doctors);
        req.getRequestDispatcher("ftl/reception_history.ftl").forward(req, resp);
    }
}
