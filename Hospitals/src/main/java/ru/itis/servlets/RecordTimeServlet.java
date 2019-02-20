package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Doctor;
import ru.itis.models.WorkTime;
import ru.itis.repositories.ComponentsRepository;
import ru.itis.repositories.RecordRepository;
import ru.itis.repositories.RecordRepositoryImpl;
import ru.itis.services.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/recordtime")
public class RecordTimeServlet extends HttpServlet {

    private RecordService recordService;
    private RecordRepository recordRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        recordService = (RecordService) context.getAttribute("recordService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String doctorId = req.getParameter("doctor_id");
        String date = req.getParameter("date");
        if (doctorId != null && date != null){
            List<WorkTime> time = recordService.getTime(Long.parseLong(doctorId), date);
            String resultJson = objectMapper.writeValueAsString(time);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        }
    }
}
