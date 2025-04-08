package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.service.IWorkoutCreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WorkoutCreator implements IWorkoutCreator {

    private String fileName = "Workout.txt";

    @Override
    public Workout createWorkout(String title, String description, List<Exercise> exercises) {
        Workout workout = new Workout();
        workout.setTitle(title);
        workout.setDescription(description);
        workout.setExercises(exercises);

        saveWorkoutToFile(workout);
        return workout;
    }

    private void saveWorkoutToFile(Workout workout) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(workout.toString());
            writer.newLine();
            System.out.println("Workout created successfully.");
        } catch (IOException e) {
            System.out.println("Error saving workout: " + e.getMessage());
        }
    }
}