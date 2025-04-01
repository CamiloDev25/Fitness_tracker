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
        switch (selectedOption){
            case "1":
                WorkoutController workoutController = new WorkoutController();
                List<Workout> workoutList = workoutController.findAll();
                System.out.println("The available Workouts: ");
                int i = 1;
                for (Workout workout : workoutList){
                    System.out.println( i + ". " + workout.getTitle() + " " + workout.getDescription());
                    i++;
                }

                //switch to exercises
                selectedOption = input.nextLine();
                switch (selectedOption){
                    case "1":
                       ExerciseController exerciseController = new ExerciseController();
                       List<Exercise> exerciseList = exerciseController.routine();
                        System.out.println("Workout structure: Cardio Resistance " +
                                "\n Description: A cardio routine focused on the lower body" +
                                "\n\n Exercises: ");

                        int j = 0;
                        for (Exercise exercise : exerciseList){
                            if (j<3){ //show online three elements
                                System.out.println(exercise.getExercise());
                                j++;

                            }
                            else{
                                break;
                            }
                        }
                        System.out.println("\nNotes: Take a 2-minutes break between sets and hydrate adequately");
                        break;

                    case "2":
                        ExerciseController exerciseController2 = new ExerciseController();
                        List<Exercise> exerciseList2 = exerciseController2.routine();
                        System.out.println("Workout structure: ExplosiveStrenght " +
                                "\n Description: A full-body explosive strenght routine" +
                                "\n\n Exercises: ");

                        int k = 3;
                        for (int index = k; index < exerciseList2.size(); index++) {
                            if (k < 6) {
                                System.out.println(exerciseList2.get(index).getExercise());
                                k++;

                            } else {
                                break;
                            }
                        }
                        System.out.println("\nNotes: Remember to have a good position for the exercises");
                        break;

                    case "3":
                        ExerciseController exerciseController3 = new ExerciseController();
                        List<Exercise> exerciseList3 = exerciseController3.routine();
                        System.out.println("Workout structure: Endurance Challenge " +
                                "\n Description: An intense routine to improve whole body endurance" +
                                "\n\n Exercises: ");

                        int l = 6;
                        for (int index = l; index < exerciseList3.size(); index++) {
                            if (l < 8) {
                                System.out.println(exerciseList3.get(index).getExercise());
                                l++;

                            } else {
                                break;
                            }
                        }
                        System.out.println("\nNotes: Remember to warm up your joints and stay hydrated");
                        break;
                }
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
