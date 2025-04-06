package org.surotec.finalprojectfitnesstracker.domain.service;

import org.surotec.finalprojectfitnesstracker.domain.dto.User;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import java.util.List;

public interface IGetWorkouts {
    public List<Workout> searchWorkouts();

}
