package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserRegister;

public class UserRegister implements IUserRegister {

    private IUserRepository userRepository;

    public UserRegister(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchUser(String email) {
        return userRepository.find(email);
    }

    @Override
    public User registerUser(String email, String password, String name, String lastName, String role) {

        User user = userRepository.find(email);
        if (user == null){
            return userRepository.save(new User(email, password, name, lastName, role));
        }
        return null;
    }

}
