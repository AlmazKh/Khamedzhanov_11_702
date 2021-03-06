package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.repositories.ComponentsRepository;
import ru.itis.repositories.ComponentsRepositoryImpl;
import ru.itis.repositories.RecordRepository;
import ru.itis.repositories.RecordRepositoryImpl;
import ru.itis.services.ComponentsService;
import ru.itis.services.ComponentsServiceImpl;
import ru.itis.services.RecordService;
import ru.itis.services.RecordServiceImpl;

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

@WebServlet("/proceduresServlet")
public class  ProceduresServlet extends HttpServlet {
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
        List<Procedure> procedures = recordService.getProcedures();
        List<Hospital> hospitals = recordService.getHospitals();
        req.setAttribute("procedures", procedures);
        req.setAttribute("hospitals", hospitals);
        req.getRequestDispatcher("ftl/procedures.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Hospital> hospitals = recordService.getHospitals();
        req.setAttribute("hospitals", hospitals);
        String hospitalId = req.getParameter("hospital_id");
        if (hospitalId != null){
            List<Procedure> procedures = componentsService.getProcedures(Long.parseLong(hospitalId));
            String resultJson = objectMapper.writeValueAsString(procedures);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        }
    }
}
