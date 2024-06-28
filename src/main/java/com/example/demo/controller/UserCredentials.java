package com.example.demo.controller;

import com.example.demo.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCredentials {

    private List<UserModel> users;

    public UserCredentials() {
        users = new ArrayList<>();

        users.add(new UserModel("student1", "1234"));
        users.add(new UserModel("student2", "1234"));
    }

    public UserModel findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean validateUser(String username, String password) {
        UserModel user = findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }


}
