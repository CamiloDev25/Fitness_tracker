package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;

import java.util.List;

public class WorkoutServiceImpl implements WorkoutService {

    //Workout creation
    @Override
    public List<Workout> findAll() {
        Workout cardioResistance = new Workout();
        cardioResistance.setTitle("Cardio Resistance");
        cardioResistance.setDescription("- A Cardio routine focused on the lower body ");

        Workout explosiveStrenght = new Workout();
        explosiveStrenght.setTitle("Explosive Strenght");
        explosiveStrenght.setDescription("- A full-body explosive strenght routine");

        Workout enduranceChallenge = new Workout();
        enduranceChallenge.setTitle("Endurance Challenge");
        enduranceChallenge.setDescription("- An intense routine to improve whole body endurance");
        return List.of(cardioResistance, explosiveStrenght, enduranceChallenge);
    }

    /*
    @Override
    public List<Workout> exDescription() {
        Workout desCardioResistance = new Workout();
        desCardioResistance.setDescription(" - A cardio routine focused on the lower body");

        Workout desExplosiveStrenght = new Workout();
        desExplosiveStrenght.setDescription("- A full-body explosive strenght routine");

        Workout desEnduranceChallenge = new Workout();
        desEnduranceChallenge.setDescription("- An intense routine to improve whole body endurance");

        return List.of(desCardioResistance,desExplosiveStrenght,desEnduranceChallenge);
    }*/

}
