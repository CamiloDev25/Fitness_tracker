package org.surotec.finalprojectfitnesstracker;
import org.surotec.finalprojectfitnesstracker.application.service.UserLogin;
import org.surotec.finalprojectfitnesstracker.application.service.UserRegister;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserLogin;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserRegister;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.MainMenuServiceImpl;
import org.surotec.finalprojectfitnesstracker.infraestructure.repository.UserRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        IUserRepository userRepository = new UserRepository();
        IUserRegister userRegister = new UserRegister(userRepository);

        IUserLogin userLogin = new UserLogin(userRepository);

        MainMenuServiceImpl mainMenuService = new MainMenuServiceImpl(userRegister, userLogin);
        mainMenuService.printMenu(input);

    }
}
