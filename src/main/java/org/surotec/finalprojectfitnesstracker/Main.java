package org.surotec.finalprojectfitnesstracker;

import javax.sql.rowset.serial.SerialException;
import java.util.Scanner;

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
                break;

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
