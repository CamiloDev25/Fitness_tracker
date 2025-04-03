package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;

public interface UserService {
    //para definir los metodos de registro y login
    void register(User user) throws Exception;
    User login(String email, String password) throws Exception;
}
