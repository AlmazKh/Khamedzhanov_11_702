package ru.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.*;
import ru.itis.services.ComponentsService;
import ru.itis.services.LoginService;
import ru.itis.services.RecordService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ComponentsController {

    @Autowired
    private ComponentsService componentsService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private RecordService recordService;

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

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView getHistoryPage(HttpServletRequest req) throws Exception {
        List<Reception> receptions = componentsService.getReception(currentUser(req).getId());
        List<Doctor> doctors = componentsService.getDoctorsNameById(currentUser(req).getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reception_history");
        modelAndView.addObject("receptions", receptions);
        modelAndView.addObject("doctors", doctors);
        return modelAndView;
    }


    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public ModelAndView getDoctorsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("doctors");
        List<Doctor> doctors = recordService.getDoctors();
        List<Hospital> hospitals = recordService.getHospitals();
        modelAndView.addObject("doctors", doctors);
        modelAndView.addObject("hospitals", hospitals);
        return modelAndView;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Doctor> showDoctorsTable(@RequestBody String hospital_id) {
        if (hospital_id != null){
            return componentsService.getDoctors(Long.parseLong(hospital_id.replaceAll("\\D+","")));
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/procedures", method = RequestMethod.GET)
    private ModelAndView getProceduresPage () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("procedures");
        List<Procedure> procedures = recordService.getProcedures();
        List<Hospital> hospitals = recordService.getHospitals();
        modelAndView.addObject("procedures", procedures);
        modelAndView.addObject("hospitals", hospitals);
        return modelAndView;
    }

    @RequestMapping(value = "/procedures", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Procedure> showProceduresTable(@RequestBody String hospital_id) {
        if (hospital_id != null){
            return componentsService.getProcedures(Long.parseLong(hospital_id.replaceAll("\\D+","")));
        } else {
            return null;
        }
    }
}
