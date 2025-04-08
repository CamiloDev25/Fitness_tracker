package org.surotec.finalprojectfitnesstracker.domain.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import java.util.List;

public interface IWorkoutCreator {
    Workout createWorkout(String title, String description, List<Exercise> exercises);
}