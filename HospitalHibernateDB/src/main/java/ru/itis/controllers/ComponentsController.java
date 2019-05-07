package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.*;
import ru.itis.security.UserDetailsImpl;
import ru.itis.services.ComponentsService;
import ru.itis.services.RecordService;

import java.util.List;

@Controller
public class ComponentsController {

    @Autowired
    private ComponentsService componentsService;
    @Autowired
    private RecordService recordService;

    @GetMapping(value = "/history")
    public ModelAndView getHistoryPage(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        List<Reception> receptions = componentsService.getReception(user.getId());
        List<Doctor> doctors = componentsService.getDoctorsByPatientId(user.getId());
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
    private String getProceduresPage (ModelMap modelMap) {
        List<Procedure> procedures = recordService.getProcedures();
        List<Hospital> hospitals = recordService.getHospitals();
        modelMap.addAttribute("procedures", procedures);
        modelMap.addAttribute("hospitals", hospitals);
        return "procedures";
    }

    @PostMapping(value = "/procedures",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Procedure> showProceduresTable(@RequestParam("hospital_id") String hospitalId) {
        if (hospitalId != null){
            return componentsService.getProcedures(Long.parseLong(hospitalId));
        } else {
            return null;
        }
    }

    @GetMapping(value = "/hospitals")
    public String getHospitalsPage() {
        return "hospitals";
    }

    @GetMapping(value = "/hospitals/search",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Hospital> getHospitals(@RequestParam("q") String query) {
        if (query != null) {
//            List<Hospital> list = componentsService.getHospitalsByAddress(query);
            return componentsService.getHospitalsByAddress(query);
        }
        return null;
    }
}
