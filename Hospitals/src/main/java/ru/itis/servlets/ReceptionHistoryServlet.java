package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Reception;
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
import java.util.List;

@WebServlet("/historyServlet")
public class ReceptionHistoryServlet extends HttpServlet {

    private ComponentsService componentsService;
    private LoginService loginService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        loginService = (LoginService) context.getAttribute("loginService");
        componentsService = (ComponentsService) context.getAttribute("componentsService");
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
