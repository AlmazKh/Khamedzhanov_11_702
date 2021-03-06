package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.form.FeedbackForm;
import ru.itis.form.UserForm;
import ru.itis.models.User;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/starterPageServlet")
public class StarterPageServlet extends HttpServlet {

    private LoginService loginService;
    private FeedbackService feedbackService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        loginService = (LoginService) context.getAttribute("loginService");
        feedbackService = (FeedbackService) context.getAttribute("feedbackService");
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
