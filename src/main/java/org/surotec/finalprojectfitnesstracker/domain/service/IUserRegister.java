package org.surotec.finalprojectfitnesstracker.domain.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;

public interface IUserRegister {
    public User searchUser(String email);
    public User registerUser(String email, String password, String name, String lastName, String role);
}
