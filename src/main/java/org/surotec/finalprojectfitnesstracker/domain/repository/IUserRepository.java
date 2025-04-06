package org.surotec.finalprojectfitnesstracker.domain.repository;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;

public interface IUserRepository {
    public User save(User user);
    public User find(String email);
}
