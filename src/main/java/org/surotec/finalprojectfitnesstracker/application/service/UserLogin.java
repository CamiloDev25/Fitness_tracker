package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserLogin;

public class UserLogin implements IUserLogin {

    private IUserRepository userRepository;

    public UserLogin(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userRepository.find(email);

        if (user == null) {
            throw new IllegalArgumentException("Email not found.");
        }

        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password.");
        }

        user.setLogin(true);
        return user;
    }
}
