package org.surotec.finalprojectfitnesstracker.domain.service.impl;

//import org.surotec.finalprojectfitnesstracker.application.WorkoutController;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.IGetWorkouts;
import org.surotec.finalprojectfitnesstracker.domain.service.IWorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.MenuService;

import javax.sql.rowset.serial.SerialException;
import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserMenuServiceImpl implements MenuService {

    private IGetWorkouts getWorkouts;
    private IWorkoutLog workoutLog;
    private User user;

    public UserMenuServiceImpl(IGetWorkouts getWorkouts, IWorkoutLog workoutLog, User user) {
        this.getWorkouts = getWorkouts;
        this.workoutLog = workoutLog;
        this.user = user;
    }

    public void printMenu(Scanner input) {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Welcome to Your Personal Fitness Tracker \n" +
                    "\n Please select an option: " +
                    "\n\n 1. Show Workouts " +
                    "\n- View the list of available workouts and see detailed structures to help" +
                    "\n\n 2. Log Workout " +
                    "\n- Select a workout you have performed and enter the time taken for each exercise" +
                    "\n\n 3. View Logged Workouts " +
                    "\n- Review your workout history, including details and total time for each exercise" +
                    "\n\n 4. Exit");

            try {
                String selectedOption = input.nextLine();
                switch (selectedOption) {
                    case "1":
                        boolean showSubMenu = true;
                        while (showSubMenu) {

                            List<Workout> workouts = getWorkouts.searchWorkouts();
                            System.out.println("Available workouts");
                            int i = 1;
                            for (Workout workout : workouts) {
                                System.out.println(i + ". " + workout.getTitle() + " - " + workout.getDescription());
                                i++;
                            }
                            System.out.println("Enter the number of a workout to view its structure, or type 'back' to return");
                            String selectOne = input.nextLine();
                            switch (selectOne) {
                                case "back":
                                    showSubMenu = false;
                                    continue;
                                default:

                                    try {
                                        int value = Integer.parseInt(selectOne);
                                        if (value <= i && value > 0) {
                                            Workout workout = workouts.get(value -1);
                                            System.out.println("Workout structure: " + workout.getTitle() + "\n" + "Description: " + workout.getDescription() +
                                                    "\n\nExercises");
                                            for (Exercise exercise : workout.getExercises()) {
                                                System.out.println("- " + exercise.getTitle() + ": " + exercise.getDescription());
                                            }
                                            System.out.println("\nNotes: Ensure proper form and take 1-minute rest between sets.");
                                            System.out.println("Press any key return to the workout list... ");
                                            input.nextLine();
                                            showSubMenu = true;
                                            continue;

                                        } else {
                                            System.out.println("Choose a correct option");
                                            showSubMenu = true;
                                            continue;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Choose a correct option");
                                        showSubMenu = true;
                                        continue;
                                    }
                            }
                        }
                        break;

                    case "2":
                        boolean showLogWorkoutMenu = true;
                        while (showLogWorkoutMenu) {
                            int i = 1;
                            List<Workout> workouts = getWorkouts.searchWorkouts();
                            System.out.println("Choose a workout to log");
                            for (Workout workout : workouts) {
                                System.out.println(i + ". " + workout.getTitle() + " - " + workout.getDescription());
                                i++;
                            }
                            String select = input.nextLine();
                            try {
                                int value = Integer.parseInt(select);
                                if (value <= i && value > 0) {
                                    Workout workout = workouts.get(value - 1);
                                    System.out.println("Logging " + workout.getTitle() + ": ");
                                    String exerciseMinutes;

                                    for (Exercise exercise : workout.getExercises()) {
                                        boolean showTimeExerciseMenu = true;
                                        System.out.println("Enter time taken for " + exercise.getTitle() + " (in minutes) ");
                                        exerciseMinutes = input.nextLine();
                                        while (showTimeExerciseMenu) {
                                            try {
                                                int exerciseMinutesInt = Integer.parseInt(exerciseMinutes);
                                                exercise.setTime(exerciseMinutesInt);

                                                showTimeExerciseMenu = false;

                                            } catch (Exception e) {
                                                System.out.println("Write a valid number");
                                                showTimeExerciseMenu = true;
                                            }

                                        }

                                    }

                                    workoutLog.logWorkout(workout.getTitle(), user.getEmail(), workout.getExercises(), LocalDateTime.now());

                                    showLogWorkoutMenu = false;
                                    showMenu = true;


                                } else {
                                    System.out.println("Choose a correct option");
                                    showLogWorkoutMenu = true;

                                }
                            } catch (Exception e) {
                                System.out.println("Choose a correct option");
                                showLogWorkoutMenu = true;

                            }


                        }
                        break;

                    case "3":
                        boolean showWorkoutDetails = true;
                        while (showWorkoutDetails) {

                            List<WorkoutLog> workoutLogs = workoutLog.searchWorkoutLog(user.getEmail());
                            System.out.println("Workout History (Sorted by Date Descending)");
                            int i = 1;
                            workoutLogs.sort(Comparator.comparing(WorkoutLog::getDate));
                            for (WorkoutLog workoutLog1 : workoutLogs) {
                                System.out.println(i + "." + " Date: " + workoutLog1.getDate() + "\nWorkout: " + workoutLog1.getWorkoutTitle());
                                i++;
                            }
                            String select = input.nextLine();


                            try {
                                int value = Integer.parseInt(select);
                                if (value <= i && value > 0) {
                                    WorkoutLog workoutLog = workoutLogs.get(value - 1);
                                    System.out.println("Workout Details for " + workoutLog.getWorkoutTitle() + " on " + workoutLog.getDate());
                                    int totalTime = 0;
                                    for (Exercise exercise : workoutLog.getExerciseList()) {
                                        System.out.println("- " + exercise.getTitle() + ": " + exercise.getTime() + " minutes");
                                        totalTime = +exercise.getTime();
                                    }
                                    System.out.println("Total Time: " + totalTime);
                                    System.out.println("Calories: " + totalTime * 10);
                                    System.out.println("\nPress any key to return the workout history...");
                                    showWorkoutDetails = false;

                                } else {
                                    System.out.println("Choose a correct option");
                                    showWorkoutDetails = true;

                                }
                            } catch (Exception e) {
                                System.out.println("Choose a correct option");
                                showWorkoutDetails = true;

                            }

                        }
                        break;

                    case "4":
                        System.out.println("Exiting the program. Goodbye");
                        showMenu = false;
                        input.close();
                        break;

                    default:
                        throw new SerialException("The option is not available");
                }
            } catch (SerialException ex) {
                System.out.println(ex.getMessage()); //message from the throw
            }

        }


   /* private void showWorkout(Scanner input) {
        WorkoutController workoutController = new WorkoutController();
        List<Workout> workoutList = workoutController.findAll();
        System.out.println("The available Workouts: ");
        int i = 1;
        for (Workout workout : workoutList) {
            System.out.println(i + ". " + workout.getTitle() + " " + workout.getDescription());
            i++;
        }


        System.out.println("Please select a workout by entering its number (1-" + (i - 1) + "): or if you regreat write back ");
        String userInput = input.nextLine();
        int workoutChoice = 0;
        try {
            workoutChoice = Integer.parseInt(userInput);

        } catch (NumberFormatException woC) {
            returnToMainMenu(input, userInput); //si es una cadena cae aqui. El condicional ya está hecho abajo
        }

        // get workout selected
        showWorkoutExercises(input, workoutChoice, i, workoutList);
    }

    private void returnToMainMenu(Scanner input, String text) {
        if (isUserMovingBack(text)) {
            getMainMenu(input);
        } else {
            System.out.println("Please choose other option, This is not value ");
        }
    }

    private void showWorkoutExercises(Scanner input, int workoutChoice, int i, List<Workout> workoutList) {
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
            if (isUserMovingBack(message)) {
                showWorkout(input);
            } else {
                System.out.println("Option is not value");
            }

        } else {
            System.out.println("Invalid choice, please select a number between 1 and " + (i - 1) + ".");
        }
    }*/


    }


}

