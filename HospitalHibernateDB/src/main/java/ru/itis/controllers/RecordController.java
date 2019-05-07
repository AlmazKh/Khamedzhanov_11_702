package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.RecordForm;
import ru.itis.models.*;
import ru.itis.security.UserDetailsImpl;
import ru.itis.services.ComponentsService;
import ru.itis.services.RecordService;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private ComponentsService componentsService;

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
    public List<Procedure> getProcedures(@RequestParam(value = "hospital_id") Long hospitalId) {
        if (hospitalId != null) {
//            List<Procedure> list = componentsService.getProcedures(hospitalId);
            return componentsService.getProcedures(hospitalId);
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

    @GetMapping(value = "/record/time")
    @ResponseBody
    public List<WorkTime> getWorkTime(@RequestParam(value = "doctor_id") Long doctorId,
                                      @RequestParam(value = "date") String date) {
        if (doctorId != null && date != null) {
            return recordService.getTime(doctorId, date);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/record")
//    @ResponseBody
    public String getResponseForRecording(ModelMap modelMap, Authentication authentication, RecordForm recordForm) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        modelMap.addAttribute("user", user);
        recordService.addReception(recordForm, user.getId());
        return "redirect:/record";
    }
}
