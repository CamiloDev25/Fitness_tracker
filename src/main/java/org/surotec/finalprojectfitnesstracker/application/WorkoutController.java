package org.surotec.finalprojectfitnesstracker.application;

import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.WorkoutServiceImpl;

import java.util.List;

public class WorkoutController {

    WorkoutService workoutService = new WorkoutServiceImpl();

    public List<Workout> findAll(){
        //return of training list
        return workoutService.finAll();
    }
}
