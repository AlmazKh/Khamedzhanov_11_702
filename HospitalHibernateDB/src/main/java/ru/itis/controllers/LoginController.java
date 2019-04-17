package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.LoginForm;
import ru.itis.services.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    private String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    private String login(LoginForm loginForm, HttpServletResponse resp) {
        Optional<String> optionalCookieValue = loginService.login(loginForm);
        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("auth", optionalCookieValue.get());
            resp.addCookie(cookie);
            resp.setStatus(201);
            return "redirect:/starterPage";
        } else {
            resp.setStatus(403);
            return null;
        }
    }
}
