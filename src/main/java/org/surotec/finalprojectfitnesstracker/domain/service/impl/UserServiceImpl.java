package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    //implementación de UserService
    private Map<String, User> users = new HashMap<>();

    @Override
    public void register(User user) throws Exception {
        if(users.containsKey(user.getEmail())){
            throw new Exception("User already exists");
        }
        users.put(user.getEmail(), user);
    }

    @Override
    public User login(String email, String password) throws Exception {
        User user = users.get(email);
        if(user==null || !user.getPassword().equals(password)){
            throw  new Exception("Invalid email or password");
        }
        return user;
    }

}
