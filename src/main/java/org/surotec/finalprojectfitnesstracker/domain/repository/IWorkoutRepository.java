package org.surotec.finalprojectfitnesstracker.domain.repository;


import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;

import java.util.List;


public interface IWorkoutRepository {
    public List<Workout> findAll();
}
