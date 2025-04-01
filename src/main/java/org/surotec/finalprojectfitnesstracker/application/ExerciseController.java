package org.surotec.finalprojectfitnesstracker.application;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.ExerciseService;
import org.surotec.finalprojectfitnesstracker.domain.service.impl.ExerciseServiceImpl;

import java.util.List;

public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(){
        this.exerciseService = new ExerciseServiceImpl();
    }

    public List<Exercise> routine(){
        return exerciseService.routine();
    }

    /*
    ExerciseController exerciseController = new ExerciseController();

    public List<Exercise> routine(){
        return exerciseController.routine();  */
    }
