package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;

import java.util.ArrayList;
import java.util.List;

public class WorkoutLogServiceImpl implements WorkoutLogService {
    //implementación de workoutLogService

    private final List<WorkoutLog> logs = new ArrayList<>();


    @Override
    public void logWorkout(WorkoutLog log) {

    }

    @Override
    public List<WorkoutLog> getWorkoutLogs(User user) {
        return List.of();
    }
}
