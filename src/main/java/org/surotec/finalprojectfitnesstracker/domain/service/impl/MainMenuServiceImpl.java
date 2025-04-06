package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.service.*;

import java.util.Scanner;

public class MainMenuServiceImpl implements MenuService {

    private IUserRegister userRegister;
    private IUserLogin userLogin;
    private IGetWorkouts getWorkouts;
    private IWorkoutLog workoutLog;

    public MainMenuServiceImpl(IUserRegister userRegister, IUserLogin userLogin, IGetWorkouts getWorkouts, IWorkoutLog workoutLog) {
        this.userRegister = userRegister;
        this.userLogin = userLogin;
        this.getWorkouts = getWorkouts;
        this.workoutLog = workoutLog;
    }

    @Override
    public void printMenu(Scanner input) {


        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nWelcome to the Personal Fitness Tracker!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please select an option: \n ");

            String option = input.nextLine();

            if (option.equals("1")) {
                try {
                    System.out.println("Note: the password must have one digit, one uppercase and one lowercase letter and have a minimum length of 8 characters");
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Last name: ");
                    String lastName = input.nextLine();
                    System.out.print("Email address: ");
                    String email = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();
                    String role = "Usuario";
                    userRegister.registerUser(name, lastName, email, password, role);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("2")) {
                try {
                    System.out.print("Email address: ");
                    String email = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();
                  User user = userLogin.loginUser(email, password);
                    if (user != null && user.isLogin()){
                        System.out.println("The user is register");
                        UserMenuServiceImpl userMenuService = new UserMenuServiceImpl(getWorkouts, workoutLog, user);
                        userMenuService.printMenu(input);
                    }else {
                        System.out.println("The user doesn't exist");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("3")) {
                System.out.println("Exiting...");
                continueRunning = false;  // Cambiar la variable a false para salir del bucle
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }

        }
        // UserServiceImpl userService = new UserServiceImpl();




