package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.application.ExerciseController;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ExerciseServiceImpl implements ExerciseService {


    @Override
    public List<Exercise> routine() {

        Exercise running = new Exercise();
        running.setExercise("- Running: 3 sets of 5 minutes ");

        Exercise jumpRope = new Exercise();
        jumpRope.setExercise("- JumpRope: 4 sets of 100 reps");

        Exercise cycling = new Exercise();
        cycling.setExercise("- Cyling: 3 sets of 10 minutes");

        Exercise pushUps = new Exercise();
        pushUps.setExercise("- PushUps: 4 sets 8 reps");

        Exercise swimming = new Exercise();
        swimming.setExercise("- Swimming: 5 sets 10 minutes");

        Exercise squats = new Exercise();
        squats.setExercise("- Squats: 4 sets 8 reps");

        Exercise cycling1 = new Exercise();
        cycling1.setExercise("- Cycling: 4 sets 12 minutes");

        Exercise swimming1 = new Exercise();
        swimming1.setExercise(" - Swimming: 5 sets of 15 minutes");

        return List.of(running, jumpRope, cycling, pushUps, swimming, squats, cycling1, swimming1);


    }
}
