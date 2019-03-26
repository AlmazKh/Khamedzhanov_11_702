package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Hospital;
import ru.itis.models.Procedure;
import ru.itis.models.User;
import ru.itis.services.ComponentsService;
import ru.itis.services.LoginService;
import ru.itis.services.RecordService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ComponentsService componentsService;

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

    @RequestMapping(value = "/record", method = RequestMethod.GET)
    public ModelAndView getRecordPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("record");
        List<Hospital> hospitals = recordService.getHospitals();
        modelAndView.addObject("hospitals", hospitals);
        return modelAndView;
    }

    @RequestMapping(value = "/recordprocedures", method = RequestMethod.GET)
    @ResponseBody
    public List<Procedure> getProcedures(HttpServletRequest req) {
        String hosptalId = req.getParameter("hospital_id");
        if (hosptalId != null){
            return componentsService.getProcedures(Long.parseLong(hosptalId));
        } else {
            return null;
        }
    }

//    @RequestMapping(value = "/recorddoctors")
//    protected void getDoctors(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String hospitalId = req.getParameter("hospital_id");
//        String procedureId = req.getParameter("procedure_id");
//        if (hospitalId != null && procedureId != null){
//            List<Doctor> doctors = recordService.getDoctors(Long.parseLong(hospitalId), Long.parseLong(procedureId));
//            String resultJson = objectMapper.writeValueAsString(doctors);
//            resp.setStatus(200);
//            resp.setContentType("application/json");
//            PrintWriter writer = resp.getWriter();
//            writer.write(resultJson);
//        }
//    }
}
