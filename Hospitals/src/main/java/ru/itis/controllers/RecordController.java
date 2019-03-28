package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.form.RecordForm;
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

    @RequestMapping(value = "/record/procedures", method = RequestMethod.GET)
    @ResponseBody
    public List<Procedure> getProcedures(@RequestParam(value = "hospital_id") Long hosptalId) {
        if (hosptalId != null){
            return componentsService.getProcedures(hosptalId);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/record/doctors")
    @ResponseBody
    public List<Doctor> getDoctors(@RequestParam(value = "hospital_id") Long hospitalId,
                                   @RequestParam(value = "procedure_id") Long procedureId) {
        if (hospitalId != null && procedureId != null) {
            return recordService.getDoctors(hospitalId, procedureId);
        } else {
            return null;
        }
    }

    @GetMapping(value ="/record/time")
    @ResponseBody
    public List<WorkTime> getWorkTime(@RequestParam(value = "doctor_id") Long doctorId,
                                      @RequestParam(value = "date") String date) {
        if (doctorId != null && date != null){
            return recordService.getTime(doctorId, date);
        } else {
            return null;
        }
    }

//    @PostMapping(value = "/record")
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    @ResponseBody
//    public String getResponseForRecording(RecordForm recordForm, HttpServletRequest req) {
    public String getResponseForRecording(HttpServletRequest req,
                                          @RequestParam(value = "doctor_id") Long doctorId,
                                          @RequestParam(value = "date") String date,
                                          @RequestParam(value = "time") String time) {
        User user = currentUser(req);
        req.setAttribute("user", user);
        recordService.addReception(doctorId, date, time, user.getId());
//        recordService.addReception(recordForm.getDoctorId(), recordForm.getDate(), recordForm.getTime(), user.getId());
        return "redirect:/record";
    }
//    @RequestMapping(value = "/starterPage", method = RequestMethod.POST)
//    public String getFeedback(FeedbackForm feedbackForm) {
//        feedbackService.addFeedback(feedbackForm);
//        return "redirect:/starterPage";
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Long hospitalId = Long.valueOf(req.getParameter("hospital_id"));
//        Long doctorId = Long.valueOf(req.getParameter("doctor_id"));
//        Long procedureId = Long.valueOf(req.getParameter("procedure_id"));
//        String date = req.getParameter("date");
//        String time = req.getParameter("time");
//        User user = currentUser(req);
//        req.setAttribute("user", user);
//        recordService.addReception(doctorId, date, time, user.getId());
//        req.getRequestDispatcher("ftl/record.ftl").forward(req, resp);
//    }
}
