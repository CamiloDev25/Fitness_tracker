package org.surotec.finalprojectfitnesstracker.domain.service;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;

import java.time.LocalDateTime;
import java.util.List;

public interface IWorkoutLog {
    public List<WorkoutLog> searchWorkoutLog(String email);
    public WorkoutLog logWorkout(String title, String email, List<Exercise> exerciseList, LocalDateTime date);
}
