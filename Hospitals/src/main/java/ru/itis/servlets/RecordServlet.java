package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
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
import java.util.Optional;

@WebServlet("/record")
public class RecordServlet extends HttpServlet {

    private RecordService recordService;
    private LoginService loginService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        recordService = (RecordService) context.getAttribute("recordService");
        loginService = (LoginService) context.getAttribute("loginService");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hospital> hospitals = recordService.getHospitals();
        req.setAttribute("hospitals", hospitals);
        req.getRequestDispatcher("ftl/record.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long hospitalId = Long.valueOf(req.getParameter("hospital_id"));
        Long doctorId = Long.valueOf(req.getParameter("doctor_id"));
        Long procedureId = Long.valueOf(req.getParameter("procedure_id"));
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        User user = currentUser(req);
        req.setAttribute("user", user);
        recordService.addReception(doctorId, date, time, user.getId());
        req.getRequestDispatcher("ftl/record.ftl").forward(req, resp);
    }
}
