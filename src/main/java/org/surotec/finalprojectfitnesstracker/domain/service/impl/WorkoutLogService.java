package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;

import java.util.List;

public interface WorkoutLogService {
    //para manejar los logs de los workouts

    void logWorkout(WorkoutLog log);
    List<WorkoutLog> getWorkoutLogs(User user);
}
