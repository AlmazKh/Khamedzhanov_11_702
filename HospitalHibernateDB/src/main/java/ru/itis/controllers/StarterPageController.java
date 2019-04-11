package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StarterPageController {
    @GetMapping("/starterPage")
    public String getStarterPage() {
        return "starterPage";
    }
//    @Autowired
//    private LoginService loginService;
////    @Autowired
////    private FeedbackService feedbackService;
//
//    private User currentUser(HttpServletRequest req) {
//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            if (cookie.getName().equals("auth")) {
//                if (loginService.isExistByCookie(cookie.getValue())) {
//                    return loginService.getIdByCookie(cookie.getValue());
//                }
//            }
//        }
//        return User.builder().firstName("***").build();
//    }
//
//    @RequestMapping(value = "/starterPage", method = RequestMethod.GET)
//    public ModelAndView getStarterPage(HttpServletRequest request, HttpServletResponse response) {
//        User user = currentUser(request);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("starterPage");
//        if (!user.getFirstName().equals("***")) {
//            modelAndView.addObject("user", user);
//        }
//        return modelAndView;
//    }

//    @RequestMapping(value = "/starterPage", method = RequestMethod.POST)
//    public String getFeedback(FeedbackForm feedbackForm) {
//        feedbackService.addFeedback(feedbackForm);
//        return "redirect:/starterPage";
//    }
}
