package org.surotec.finalprojectfitnesstracker.domain.repository;

import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import java.time.LocalDateTime;
import java.util.List;

public interface IWorkoutLogsRepository {
    public WorkoutLog save(WorkoutLog workoutLog);
    public List <WorkoutLog> findAll(String email);
}
