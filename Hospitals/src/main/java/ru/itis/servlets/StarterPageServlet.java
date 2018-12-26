package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.form.FeedbackForm;
import ru.itis.form.UserForm;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/starterPage")
public class StarterPageServlet extends HttpServlet {

    private UsersService usersService;
    private LoginService loginService;
    private FeedbackRepository feedbackRepository;
    private FeedbackService feedbackService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        this.usersService = new UsersServiceImpl(usersRepository);
        this.loginService = new LoginServiceImpl(authRepository, usersRepository);
        feedbackRepository = new FeedbackRepositoryImpl(dataSource);
        feedbackService = new FeedbackServiceImpl(feedbackRepository);
    }

    private User currentUser(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    return loginService.getIdByCookie(cookie.getValue());
                }
            }
        }
        return User.builder().firstName("***").build();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = currentUser(request);
        if (!user.getFirstName().equals("***")) {
            request.setAttribute("user", user);
        }
        request.getRequestDispatcher("ftl/starterPage.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackForm feedbackForm = FeedbackForm.builder()
                .name(req.getParameter("name"))
                .phone(req.getParameter("phone"))
                .email(req.getParameter("email"))
                .text(req.getParameter("text"))
                .build();
        feedbackService.addFeedback(feedbackForm);
        User user = currentUser(req);
        if (!user.getFirstName().equals("***")) {
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher("ftl/starterPage.ftl").forward(req, resp);
    }
}
