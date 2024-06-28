package com.example.demo.controller;

import com.example.demo.model.UserSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserCredentials userCredentials;

    @Autowired
    private UserSessionModel userSessionModel;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    //Check if Session Exists
    @GetMapping("/")
    public String home(Model model) {
        if(userSessionModel.getUsername()==null) return "redirect:/login";
        model.addAttribute("userSession", userSessionModel);
        return "home";
    }
    //Form Validation
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if (userCredentials.validateUser(username, password)) {
            userSessionModel.setUsername(username);
            model.addAttribute("userSession", userSessionModel);
            return "redirect:/";
        } else {
            model.addAttribute("message", "Invalid username or password.");
            return "redirect:/login?error=invalid username or password";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userSessionModel.setUsername(null);
        return "redirect:/login";
    }

}
