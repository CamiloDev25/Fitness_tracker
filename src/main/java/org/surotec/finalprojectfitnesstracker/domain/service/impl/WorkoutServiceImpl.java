package org.surotec.finalprojectfitnesstracker.domain.service.impl;

import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;

import java.util.List;

public class WorkoutServiceImpl implements WorkoutService {

    //Workout creation
    @Override
    public List<Workout> finAll() {
        Workout cardioResistance = new Workout();
        cardioResistance.setTitle("Cardio Resistance");

        Workout explosiveStrenght = new Workout();
        explosiveStrenght.setTitle("Explosive Strenght");

        Workout enduranceChallenge = new Workout();
        enduranceChallenge.setTitle("Endurance Challenge");
        return List.of(cardioResistance, explosiveStrenght, enduranceChallenge);
    }
}
