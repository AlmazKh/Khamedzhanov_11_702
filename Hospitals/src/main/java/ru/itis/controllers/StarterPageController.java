package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.form.FeedbackForm;
import ru.itis.models.User;
import ru.itis.services.FeedbackService;
import ru.itis.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StarterPageController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private FeedbackService feedbackService;

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

    @RequestMapping(value = "/starterPage", method = RequestMethod.GET)
    public ModelAndView getStarterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = currentUser(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("starterPage");
        if (!user.getFirstName().equals("***")) {
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/starterPage", method = RequestMethod.POST)
    public  ModelAndView getFeedback(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("starterPage");
        FeedbackForm feedbackForm = FeedbackForm.builder()
                .name(request.getParameter("name"))
                .phone(request.getParameter("phone"))
                .email(request.getParameter("email"))
                .text(request.getParameter("text"))
                .build();
        feedbackService.addFeedback(feedbackForm);
        User user = currentUser(request);
        if (!user.getFirstName().equals("***")) {
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        FeedbackForm feedbackForm = FeedbackForm.builder()
//                .name(req.getParameter("name"))
//                .phone(req.getParameter("phone"))
//                .email(req.getParameter("email"))
//                .text(req.getParameter("text"))
//                .build();
//        feedbackService.addFeedback(feedbackForm);
//        User user = currentUser(req);
//        if (!user.getFirstName().equals("***")) {
//            req.setAttribute("user", user);
//        }
//        req.getRequestDispatcher("ftl/starterPage.ftl").forward(req, resp);
//    }
}
