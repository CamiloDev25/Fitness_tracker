package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.service.MenuService;

import java.util.Scanner;

public class MainMenuServiceImpl implements MenuService {


    @Override
    public void printMenu(Scanner input) {
        UserServiceImpl userService = new UserServiceImpl();
        UserMenuServiceImpl userMenuService = new UserMenuServiceImpl();



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
                    userService.registerUser(name, lastName, email, password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("2")) {
                try {
                    System.out.print("Email address: ");
                    String email = input.nextLine();
                    System.out.print("Password: ");
                    String password = input.nextLine();
                    userService.logIn(email, password);
                userMenuService.printMenu(input);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }  else if (option.equals("3")) {
                System.out.println("Exiting...");
                continueRunning = false;  // Cambiar la variable a false para salir del bucle
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}



