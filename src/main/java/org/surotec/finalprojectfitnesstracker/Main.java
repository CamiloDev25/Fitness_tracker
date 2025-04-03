package org.surotec.finalprojectfitnesstracker;

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

        System.out.println("Please select a workout by entering its number (1-" + (i -1) + "): or return to the previous menu by typing 'back' ");
        String  userInput = input.nextLine();
        int workoutChoice = 0;
        try {
            workoutChoice = Integer.parseInt(userInput);

        }catch (NumberFormatException woC){
                returnToMainMenu( input, userInput);
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
            System.out.println("\ntype 'back' if you want to return to the previous menu...");
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
                "\n\n 4. Exit \n");

        try{
           String selectedOption = input.nextLine();
            switch (selectedOption) {
                case "1":
                    showWorkout(input);

                case "2":
                    System.out.println("Log workout selected");
                    break;

                case "3":
                    System.out.println("View logged workouts selected");
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
}
