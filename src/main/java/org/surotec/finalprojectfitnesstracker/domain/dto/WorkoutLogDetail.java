package org.surotec.finalprojectfitnesstracker.domain.dto;

public class WorkoutLogDetail {

    private Exercise exercise;
    private int timeTaken;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
