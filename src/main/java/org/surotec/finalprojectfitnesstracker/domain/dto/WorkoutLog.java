package org.surotec.finalprojectfitnesstracker.domain.dto;

import java.util.Date;
import java.util.Map;

public class WorkoutLog {
    //clase para registrar los logs de los workouts

    private User user;
    private Workout workout;
    private Date date;
    private Map<String, Integer> exerciseTimes;
    private int totalTime;
    private int caloriesBurned;

    // Constructor por defecto
    public WorkoutLog() {
    }

    // Constructor con parámetros
    public WorkoutLog(User user, Workout workout, Date date, Map<String, Integer> exerciseTimes, int totalTime, int caloriesBurned) {
        this.user = user;
        this.workout = workout;
        this.date = date;
        this.exerciseTimes = exerciseTimes;
        this.totalTime = totalTime;
        this.caloriesBurned = caloriesBurned;
    }

    // User
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    // Workout
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Workout getWorkout() {
        return workout;
    }

    // Date
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    // ExerciseTimes
    public void setExerciseTimes(Map<String, Integer> exerciseTimes) {
        this.exerciseTimes = exerciseTimes;
    }

    public Map<String, Integer> getExerciseTimes() {
        return exerciseTimes;
    }

    // TotalTime
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    // CaloriesBurned
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

}
