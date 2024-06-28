package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCredentials {

    private List<User> users;

    public UserCredentials() {
        users = new ArrayList<>();

        users.add(new User("student1", "1234"));
        users.add(new User("student2", "1234"));
    }

    public User findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean validateUser(String username, String password) {
        User user = findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }


}
