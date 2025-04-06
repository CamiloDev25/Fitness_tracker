package org.surotec.finalprojectfitnesstracker.domain.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;

public interface IUserLogin {
    public User loginUser(String email, String password);
}
