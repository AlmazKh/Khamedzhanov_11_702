package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.form.UserForm;
import ru.itis.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements Controller {

    @Autowired
    private UsersService usersService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        UserForm userForm = UserForm.builder()
                .firstName(httpServletRequest.getParameter("first_name"))
                .lastName(httpServletRequest.getParameter("last_name"))
                .gender(httpServletRequest.getParameter("gender"))
                .phone(httpServletRequest.getParameter("phone"))
                .password(httpServletRequest.getParameter("password"))
                .build();
        usersService.signUp(userForm);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("singUp");
        return modelAndView;
    }
}
