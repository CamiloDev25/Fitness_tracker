package org.surotec.finalprojectfitnesstracker;
import org.surotec.finalprojectfitnesstracker.application.service.GetWorkouts;
import org.surotec.finalprojectfitnesstracker.application.service.LogWorkout;
import org.surotec.finalprojectfitnesstracker.application.service.UserLogin;
import org.surotec.finalprojectfitnesstracker.application.service.UserRegister;
import org.surotec.finalprojectfitnesstracker.domain.repository.IUserRepository;
import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutLogsRepository;
import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IGetWorkouts;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserLogin;
import org.surotec.finalprojectfitnesstracker.domain.service.IUserRegister;
import org.surotec.finalprojectfitnesstracker.domain.service.IWorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.MainMenuServiceImpl;
import org.surotec.finalprojectfitnesstracker.infraestructure.repository.UserRepository;
import org.surotec.finalprojectfitnesstracker.infraestructure.repository.WorkoutLogsRepository;
import org.surotec.finalprojectfitnesstracker.infraestructure.repository.WorkoutRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)){

        IUserRepository userRepository = new UserRepository();
        IWorkoutRepository workoutRepository = new WorkoutRepository();
        IWorkoutLogsRepository workoutLogsRepository = new WorkoutLogsRepository();
        IUserRegister userRegister = new UserRegister(userRepository);
        IUserLogin userLogin = new UserLogin(userRepository);
        IGetWorkouts getWorkouts = new GetWorkouts(workoutRepository);
        IWorkoutLog workoutLog = new LogWorkout(workoutLogsRepository);

        MainMenuServiceImpl mainMenuService = new MainMenuServiceImpl(userRegister, userLogin, getWorkouts, workoutLog);
        mainMenuService.printMenu(input);
        }catch (Exception e){
            System.out.println("There was an error in the application");
        }

    }
}
 