package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.Doctor;
import ru.itis.models.Hospital;
import ru.itis.services.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/doctorsServlet")
public class DoctorsServlet extends HttpServlet {

    private RecordService recordService;
    private ComponentsService componentsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        recordService = (RecordService) context.getAttribute("recordService");
        componentsService = (ComponentsService) context.getAttribute("componentsService");
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
