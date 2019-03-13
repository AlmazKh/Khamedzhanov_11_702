package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Doctor;
import ru.itis.models.Reception;
import ru.itis.models.User;
import ru.itis.services.ComponentsService;
import ru.itis.services.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ReceptionHistoryController {

    @Autowired
    private ComponentsService componentsService;
    @Autowired
    private LoginService loginService;

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
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Reception> receptions = componentsService.getReception(currentUser(httpServletRequest).getId());
        List<Doctor> doctors = componentsService.getDoctorsNameById(currentUser(httpServletRequest).getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("reception_history");
        modelAndView.addObject("receptions", receptions);
        modelAndView.addObject("doctors", doctors);
        return modelAndView;
    }
}
