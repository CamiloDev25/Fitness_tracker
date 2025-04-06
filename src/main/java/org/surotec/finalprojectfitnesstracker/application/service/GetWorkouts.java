package org.surotec.finalprojectfitnesstracker.application.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutRepository;
import org.surotec.finalprojectfitnesstracker.domain.service.IGetWorkouts;


import java.util.List;

public class GetWorkouts implements IGetWorkouts {

    private IWorkoutRepository workoutRepository;

    public GetWorkouts(IWorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<Workout> searchWorkouts() {
        return workoutRepository.findAll();
    }

}
