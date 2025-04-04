package org.surotec.finalprojectfitnesstracker;/*package org.surotec.finalprojectfitnesstracker;

import org.surotec.finalprojectfitnesstracker.application.WorkoutController;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

        getMainMenu(input);
    }

    private static void showWorkout(Scanner input) {
        WorkoutController workoutController = new WorkoutController();
        List<Workout> workoutList = workoutController.findAll();
        System.out.println("The available Workouts: ");
        int i = 1;
        for (Workout workout : workoutList) {
            System.out.println(i + ". " + workout.getTitle() + " " + workout.getDescription());
            i++;
        }

        //while (true){
        System.out.println("Please select a workout by entering its number (1-" + (i -1) + "): or if you regreat write back ");
        String  userInput = input.nextLine();
        int workoutChoice = 0;
        try {
            workoutChoice = Integer.parseInt(userInput);

        }catch (NumberFormatException woC){
                returnToMainMenu( input, userInput); //si es una cadena cae aqui. El condicional ya está hecho abajo
        }

        // get workout selected
        showWorkoutExercises(input, workoutChoice, i, workoutList);
    }

    private static void showWorkoutExercises(Scanner input, int workoutChoice, int i, List<Workout> workoutList) {
        if (workoutChoice >= 1 && workoutChoice < i) {
            Workout selectedWorkout = workoutList.get(workoutChoice - 1);

            // workout details
            System.out.println("\nWorkout Structure: " + selectedWorkout.getTitle());
            System.out.println("Description: " + selectedWorkout.getDescription());
            System.out.println("Exercises:");

            // show workout exercises
            for (Exercise exercise : selectedWorkout.getExercises()) {
                System.out.println(" - " + exercise.getTitle() + ": " + exercise.getDescription());
            }

            System.out.println("\nNotes: Ensure proper form and take 1-minute rest between sets.");
            System.out.println("Write 'back' to return the menu...");
             String message = input.nextLine();
            if ( isUserMovingBack(message)){
                showWorkout(input);
            }else {
                System.out.println("Option is not value");
            }

        } else {
            System.out.println("Invalid choice, please select a number between 1 and " + (i - 1) + ".");
        }
    }

    private static void getMainMenu(Scanner input) {

        System.out.println("Welcome to Your Personal Fitness Tracker \n" +
                "\n Please select an option: " +
                "\n\n 1. Show Workouts " +
                "\n- View the list of available workouts and see detailed structures to help" +
                "\n\n 2. Log Workout " +
                "\n- Select a workout you have performed and enter the time taken for each exercise" +
                "\n\n 3. View Logged Workouts " +
                "\n- Review your workout history, including details and total time for each exercise" +
                "\n\n 4. Exit");

        try{
           String selectedOption = input.nextLine();
            switch (selectedOption) {
                case "1":
                    showWorkout(input);

                case "2":

                    break;

                case "3":

                    break;

                case "4":
                    System.out.println("Exiting the program. Goodbye");
                    input.close();
                    return;

                default:
                    throw new SerialException("The option is not available");
            }
        } catch (SerialException ex){
            System.out.println(ex.getMessage()); //message from the throw
        };
    }
    private static void returnToMainMenu(Scanner input, String text){
        if (isUserMovingBack(text)){
            getMainMenu(input);
        }else {
            System.out.println("Please choose other option, This is not value ");
        }
    }
    private static boolean isUserMovingBack(String text){
        return  text.equals("back");

    }
}*/


import org.surotec.finalprojectfitnesstracker.domain.service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        //LOGICA EN EL MAIN PARA EL REGISTRO DEL USUARIO
        Scanner scanner = new Scanner(System.in);

        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("\nWelcome to the Personal Fitness Tracker!");
            System.out.println("1. Register");
            System.out.println("2. Login as User");
            System.out.println("3. Login as Admin");
            System.out.println("4. Exit");
            System.out.print("Please select an option: \n ");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                try {
                    System.out.println("Note: the password must have one digit, one uppercase and one lowercase letter and have a minimum length of 8 characters");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    userService.registerUser(name, lastName, email, password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("2")) {
                try {
                    System.out.print("Email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    userService.logIn(email, password);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("3")) {
                try {
                    System.out.print("Admin Email address: ");
                    String email = scanner.nextLine();
                    System.out.print("Admin Password: ");
                    String password = scanner.nextLine();
                    // Verificar admin
                    if (email.equals(UserServiceImpl.getEmailAdmin()) && password.equals(UserServiceImpl.getPasswordAdmin())) {
                        System.out.println("Welcome Admin!");
                        // Aquí va la logica que tendra el admin
                    } else {
                        System.out.println("Invalid admin credentials.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (option.equals("4")) {
                System.out.println("Exiting...");
                continueRunning = false;  // Cambiar la variable a false para salir del bucle
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}