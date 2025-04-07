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
    public User registerUser(String name, String lastName, String email, String password, String role) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format. Please provide a valid email address.");
        }

        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one digit.");

        }

       // User user = userRepository.find(email);
        if (userRepository.find(email) != null ) {
            System.out.println("Funcuiones por favor");
            return null;

        }else {
            return userRepository.save(new User(name, lastName, email, password, role));
        }
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
