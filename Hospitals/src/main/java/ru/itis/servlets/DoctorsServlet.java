package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/doctors")
public class DoctorsServlet extends HttpServlet {

    private RecordService recordService;
    private RecordRepository recordRepository;
    private ComponentsRepository componentsRepository;
    private ComponentsService componentsService;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
        recordRepository = new RecordRepositoryImpl(dataSource);
        recordService = new RecordServiceImpl(recordRepository);
        componentsRepository = new ComponentsRepositoryImpl(dataSource);
        componentsService = new ComponentsServiceImpl(componentsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Doctor> doctors = recordService.getDoctors();
        List<Hospital> hospitals = recordService.getHospitals();
        req.setAttribute("doctors", doctors);
        req.setAttribute("hospitals", hospitals);
        req.getRequestDispatcher("ftl/doctors.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Hospital> hospitals = recordService.getHospitals();
        req.setAttribute("hospitals", hospitals);
        String hospitalId = req.getParameter("hospital_id");
        if (hospitalId != null){
            List<Doctor> doctors = componentsService.getDoctors(Long.parseLong(hospitalId));
            String resultJson = objectMapper.writeValueAsString(doctors);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        }
    }
}
