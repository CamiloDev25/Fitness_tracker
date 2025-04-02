package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;

import java.util.ArrayList;
import java.util.List;

public class WorkoutServiceImpl implements WorkoutService {

    //Workout creation
    @Override
    public List<Workout> findAll() {
        //first workout
        Workout cardioResistance = new Workout();
        cardioResistance.setTitle("Cardio Resistance");
        cardioResistance.setDescription("- A Cardio routine focused on the lower body ");
        List<Exercise> cardioExercises = new ArrayList<>();

        Exercise running = new Exercise();
        running.setTitle("Running");
        running.setDescription("3 sets of 5 minutes");
        cardioExercises.add(running);

        Exercise jumpRope = new Exercise();
        jumpRope.setTitle("JumpRope");
        jumpRope.setDescription("JumpRope: 4 sets of 100 reps");
        cardioExercises.add(jumpRope);

        Exercise cycling = new Exercise();
        cycling.setTitle("Cyling");
        cycling.setDescription("3 sets of 10 minutes");
        cardioExercises.add(cycling);

        cardioResistance.setExercises(cardioExercises); //para asociar los ejercicios

        //second workout
        Workout explosiveStrenght = new Workout();
        explosiveStrenght.setTitle("Explosive Strenght");
        explosiveStrenght.setDescription("- A full-body explosive strenght routine");

        List<Exercise> explosiveExercise = new ArrayList<>();

        Exercise pushUps = new Exercise();
        pushUps.setTitle("PushUps");
        pushUps.setDescription("4 sets 8 reps);");
        explosiveExercise.add(pushUps);

        Exercise swimming = new Exercise();
        swimming.setTitle("Swimming");
        swimming.setDescription("5 sets 10 minutes");
        explosiveExercise.add(swimming);

        Exercise squats = new Exercise();
        squats.setTitle("Squats");
        squats.setDescription("4 sets 8 reps");
        explosiveExercise.add(squats);

        explosiveStrenght.setExercises(explosiveExercise);


        //third workout
        Workout enduranceChallenge = new Workout();
        enduranceChallenge.setTitle("Endurance Challenge");
        enduranceChallenge.setDescription("- An intense routine to improve whole body endurance");

        List<Exercise> enduranceExercise = new ArrayList<>();

        Exercise cycling1 = new Exercise();
        cycling1.setTitle("Cycling");
        cycling1.setDescription("4 sets 12 minutes");
        enduranceExercise.add(cycling1);

        Exercise swimming1 = new Exercise();
        swimming1.setTitle("Swimming");
        swimming1.setDescription("5 sets of 15 minutes");
        enduranceExercise.add(swimming1);

        enduranceChallenge.setExercises(enduranceExercise);

        return List.of(cardioResistance, explosiveStrenght, enduranceChallenge);
    }

}
