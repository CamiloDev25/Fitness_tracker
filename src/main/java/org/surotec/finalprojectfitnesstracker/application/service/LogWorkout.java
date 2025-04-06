package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutLogsRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IWorkoutLog;

import java.time.LocalDateTime;
import java.util.List;

public class LogWorkout implements IWorkoutLog {

    private final IWorkoutLogsRepository workoutLogsRepository;

    public LogWorkout(IWorkoutLogsRepository workoutLogsRepository) {
        this.workoutLogsRepository = workoutLogsRepository;
    }

    @Override
    public List<WorkoutLog> searchWorkoutLog(String email) {
        return workoutLogsRepository.findAll(email);
    }

    @Override
    public WorkoutLog logWorkout(String title, String email,List<Exercise> exerciseList, LocalDateTime date ) {
        return workoutLogsRepository.save(new WorkoutLog(title, email, exerciseList, date));
    }
}

