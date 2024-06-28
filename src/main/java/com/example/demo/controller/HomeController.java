package com.example.demo.controller;

import com.example.demo.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserSession userSession;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("userSession", userSession);
        return "home"; // Assumes a home.jsp or home.html in templates
    }

    @GetMapping("/viewGradesStudent")
    public String viewGrades(Model model) {
        model.addAttribute("userSession", userSession);
        return "viewGradesStudent"; // Assumes a grades.jsp or grades.html in templates
    }

}
