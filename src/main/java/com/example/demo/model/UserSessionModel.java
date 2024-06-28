package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSessionModel {
    private String username;

    public UserSessionModel(){}

    public UserSessionModel(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Needs to have a boolean parameter wherein we can chceck if the user is logged in
}
