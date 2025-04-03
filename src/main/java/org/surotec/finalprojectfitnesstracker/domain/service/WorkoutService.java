package org.surotec.finalprojectfitnesstracker.domain.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;

import java.util.List;

public interface WorkoutService {

    void logWorkout(WorkoutLog log);

    List<WorkoutLog> getWorkoutLogs(User user);

    List<Workout> findAll();

}


