package org.surotec.finalprojectfitnesstracker.application;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.WorkoutLogService;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.WorkoutLogServiceImpl;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.WorkoutServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class WorkoutController {

    WorkoutService workoutService = new WorkoutServiceImpl();
    private final WorkoutLogService workoutLogService = new WorkoutLogServiceImpl();

    public List<Workout> findAll(){
        //return of training list
        return workoutService.findAll();
    }


   public void logWorkout(User user, Workout workout, Map<String, Integer> times) {
       WorkoutLog log = new WorkoutLog();
       log.setUser(user);
       log.setWorkout(workout);
       log.setExerciseTimes(times);
       log.setDate(new Date());

       //calcular calorias
       int totalTime = times.values().stream().mapToInt(Integer::intValue).sum();
       log.setTotalTime(totalTime);
       log.setCaloriesBurned(calculateCaloriesBurned(workout, times));

       workoutLogService.logWorkout(log);
       System.out.println("Workout logged successfully!");
   }

    private int calculateCaloriesBurned(Workout workout, Map<String, Integer> times) {
        return times.size() * 10; // Ejemplo: 10 calorías por ejercicio
    }

    public void viewLoggedWorkouts(User user) {
        List<WorkoutLog> logs = workoutLogService.getWorkoutLogs(user);
        System.out.println("Logged Workouts for " + user.getFirstName() + ":");
        for (WorkoutLog log : logs) {
            System.out.println("Workout: " + log.getWorkout().getTitle() +
                    ", Date: " + log.getDate() +
                    ", Total Time: " + log.getTotalTime() +
                    ", Calories Burned: " + log.getCaloriesBurned());
        }
    }

}
