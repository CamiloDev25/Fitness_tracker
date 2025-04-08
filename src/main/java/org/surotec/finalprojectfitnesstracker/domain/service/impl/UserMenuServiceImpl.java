package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.application.service.WorkoutCreator;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.IGetWorkouts;
import org.surotec.finalprojectfitnesstracker.domain.service.IWorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.MenuService;

import javax.sql.rowset.serial.SerialException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserMenuServiceImpl implements MenuService {

    private IGetWorkouts getWorkouts;
    private IWorkoutLog workoutLog;
    private User user;
    private WorkoutCreator workoutCreator;

    public UserMenuServiceImpl(IGetWorkouts getWorkouts, IWorkoutLog workoutLog, User user, WorkoutCreator workoutCreator) {
        this.getWorkouts = getWorkouts;
        this.workoutLog = workoutLog;
        this.user = user;
        this.workoutCreator = workoutCreator;
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
                    "\n\n 4. Exit" +
                    "\n\n 5. Create Workout");

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
                                            Workout workout = workouts.get(value - 1);
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
                                        totalTime += exercise.getTime();
                                    }
                                    System.out.println("Total Time: " + totalTime);
                                    System.out.println("Calories: " + totalTime * 10);
                                    //System.out.println("\nPress any key to return the workout history...");
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

                    case "5":
                        if (user.getRole().equals("Admin")) {
                            System.out.print("Enter workout title: ");
                            String title = input.nextLine();
                            System.out.print("Enter workout description: ");
                            String description = input.nextLine();

                            List<Exercise> exercises = new ArrayList<>();

                            boolean addingExercises = true;
                            while (addingExercises) {
                                System.out.print("Add exercise title (or type 'done' to finish): ");
                                String exerciseTitle = input.nextLine();
                                if (exerciseTitle.equalsIgnoreCase("done")) {
                                    addingExercises = false;
                                } else {
                                    System.out.print("Add exercise description: ");
                                    String exerciseDescription = input.nextLine();
                                    Exercise exercise = new Exercise();
                                    exercise.setTitle(exerciseTitle);
                                    exercise.setDescription(exerciseDescription);
                                    exercises.add(exercise);
                                }
                            }

                            workoutCreator.createWorkout(title, description, exercises);
                        } else {
                            System.out.println("You do not have permission to create workouts.");
                        }
                        break;

                }
            } catch (SerialException ex) {
                System.out.println(ex.getMessage());
            }


        }


    }


}

