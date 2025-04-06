package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserLogin;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserRegister;

public class UserLogin implements IUserLogin {

    private IUserRepository userRepository;

    public UserLogin(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.find(email);
        if (user != null && password.equals(user.getPassword())) {
            user.setLogin(true);
        }
        return user;
    }
}
