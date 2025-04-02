package org.surotec.finalprojectfitnesstracker;

import org.surotec.finalprojectfitnesstracker.application.ExerciseController;
import org.surotec.finalprojectfitnesstracker.application.WorkoutController;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

        String selectedOption;
        System.out.println("Welcome to Your Personal Fitness Tracker \n" +
                "\n Please select an option: " +
                "\n\n 1. Show Workouts " +
                "\n- View the list of available workouts and see detailed structures to help" +
                "\n\n 2. Log Workout " +
                "\n- Select a workout you have performed and enter the time taken for each exercise" +
                "\n\n 3. View Logged Workouts " +
                "\n- Review your workout history, including details and total time for each exercise");

        try{
       selectedOption = input.nextLine();
        switch (selectedOption) {
            case "1":
                WorkoutController workoutController = new WorkoutController();
                List<Workout> workoutList = workoutController.findAll();
                System.out.println("The available Workouts: ");
                int i = 1;
                for (Workout workout : workoutList) {
                    System.out.println(i + ". " + workout.getTitle() + " " + workout.getDescription());
                    i++;
                }

                int workoutChoice;
                while (true){
                    System.out.println("Please select a workout by entering its number (1-" + (i - 1) + "): ");
                    workoutChoice = input.nextInt();
                input.nextLine();

                // get workout selected
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
                    System.out.println("Press any key to return to the workout list...");
                    input.nextLine();
                } else {
                    System.out.println("Invalid choice, please select a number between 1 and " + (i - 1) + ".");
                }
        }
                
               /* selectedOption = input.nextLine();

                workoutList.get(1);*/
                        // the main switch continues

            case "2":
                break;

            case "3":
            break;

            default:
                throw new SerialException("The option is not available");
        }
        } catch (SerialException ex){
            System.out.println(ex.getMessage()); //message from the throw
        };
        
    }
}
