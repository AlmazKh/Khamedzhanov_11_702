package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.form.UserForm;
import ru.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SignUpController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUp(UserForm userForm) {
        usersService.signUp(userForm);
        return "redirect:/login";
    }
}
