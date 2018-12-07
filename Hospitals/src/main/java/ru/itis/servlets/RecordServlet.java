package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
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

@WebServlet("/record")
public class RecordServlet extends HttpServlet {

    private RecordService recordService;
    private RecordRepository recordRepository;
    private UsersService usersService;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
        recordRepository = new RecordRepositoryImpl(dataSource);
        recordService = new RecordServiceImpl(recordRepository);
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepository);
        loginService = new LoginServiceImpl(authRepository, usersRepository);
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
        List<Doctor> doctors = recordService.getDoctors();
        List<Procedure> procedures = recordService.getProcedures();
        req.setAttribute("hospitals", hospitals);
        req.setAttribute("doctors", doctors);
        req.setAttribute("procedures", procedures);
        req.getRequestDispatcher("ftl/record.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long hospitalId = Long.valueOf(req.getParameter("hospital_id"));
        Long doctorId = Long.valueOf(req.getParameter("doctor_id"));
        Long procedureId = Long.valueOf(req.getParameter("procedure_id"));
        String calendar = req.getParameter("calendar");

        User user = currentUser(req);
        req.setAttribute("user", user);
        recordService.addReception(doctorId, calendar,user.getId());

        //TODO: подача данных в if блок после сабмита формы
//        List<Hospital> hospitals = recordService.getHospitals();


//        req.setAttribute("hospital", );

        req.getRequestDispatcher("ftl/record.ftl").forward(req, resp);

//        resp.setStatus(200);


    }
}