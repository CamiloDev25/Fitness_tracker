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
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format. Please provide a valid email address.");
        }

        if (isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one digit.");
        }

        User user = userRepository.find(email);
        if (user == null) {
            return userRepository.save(new User(name, lastName, email, password, role));
        }
        return null;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isLowerCase) &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isDigit);
    }

}
