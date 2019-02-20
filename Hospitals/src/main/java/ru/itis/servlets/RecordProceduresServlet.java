package ru.itis.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
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

@WebServlet("/recordprocedures")
public class RecordProceduresServlet extends HttpServlet {

    private LoginService loginService;
    private ComponentsService componentsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        loginService = (LoginService) context.getAttribute("loginService");
        componentsService = (ComponentsService) context.getAttribute("componentsService");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String hosptalId = req.getParameter("hospital_id");
        if (hosptalId != null){
            List<Procedure> procedures = componentsService.getProcedures(Long.parseLong(hosptalId));
            String resultJson = objectMapper.writeValueAsString(procedures);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        }
    }
}
