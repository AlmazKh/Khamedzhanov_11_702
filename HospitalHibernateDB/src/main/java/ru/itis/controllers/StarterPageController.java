package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.forms.FeedbackForm;
import ru.itis.models.User;
import ru.itis.security.UserDetailsImpl;
import ru.itis.services.FeedbackService;
import ru.itis.services.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class StarterPageController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping(value = "/starterPage")
    public String getStarterPage(Authentication authentication, ModelMap modelMap){
        if (authentication.getPrincipal() != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            modelMap.addAttribute("user", user);
        }
        return "starterPage";
    }

    @PostMapping(value = "/starterPage")
    public String getFeedback(FeedbackForm feedbackForm) {
        feedbackService.addFeedback(feedbackForm);
        return "redirect:/starterPage";
    }
}
