package com.example.demo.controller;

import com.example.demo.model.UserSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserSessionModel userSessionModel;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("userSession", userSessionModel);
        return "home"; // Assumes a home.jsp or home.html in templates
    }

    @GetMapping("/viewGradesStudent")
    public String viewGrades(Model model) {
        model.addAttribute("userSession", userSessionModel);
        return "viewGradesStudent"; // Assumes a grades.jsp or grades.html in templates
    }

}
