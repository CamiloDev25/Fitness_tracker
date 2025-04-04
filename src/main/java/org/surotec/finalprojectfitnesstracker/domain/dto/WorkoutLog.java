package org.surotec.finalprojectfitnesstracker.domain.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkoutLog {
    private String workoutTitle;
    private Map<String, Integer> exerciseTimes; // Exercise title -> time in minutes
    private Workout workout;
    private List<WorkoutLogDetail> workoutLogDetails;
    private int totalTime;
    private String date;

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public List<WorkoutLogDetail> getWorkoutLogDetails() {
        return workoutLogDetails;
    }

    public void setWorkoutLogDetails(List<WorkoutLogDetail> workoutLogDetails) {
        this.workoutLogDetails = workoutLogDetails;
    }

    public WorkoutLog() {
        exerciseTimes = new HashMap<>();
    }

    public String getWorkoutTitle() {
        return workoutTitle;
    }

    public void setWorkoutTitle(String workoutTitle) {
        this.workoutTitle = workoutTitle;
    }

    public Map<String, Integer> getExerciseTimes() {
        return exerciseTimes;
    }

    public void setExerciseTimes(Map<String, Integer> exerciseTimes) {
        this.exerciseTimes = exerciseTimes;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Method to calculate total time
    public void calculateTotalTime() {
        totalTime = exerciseTimes.values().stream().mapToInt(Integer::intValue).sum();
    }
}
