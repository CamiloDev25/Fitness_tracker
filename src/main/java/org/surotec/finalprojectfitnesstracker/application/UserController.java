package org.surotec.finalprojectfitnesstracker.application;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.UserService;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.UserServiceImpl;

public class UserController {
    private final UserService userService = new UserServiceImpl();

    public void registerUser(User user) {
        try {
            userService.register(user);
            System.out.println("User registered successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public User loginUser(String email, String password) {
        try {
            return userService.login(email, password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
