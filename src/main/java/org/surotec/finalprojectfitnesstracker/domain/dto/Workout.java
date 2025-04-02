package org.surotec.finalprojectfitnesstracker.domain.dto;

import java.util.List;

public class Workout {
    private  String title;
    private String description;
    private List<Exercise> exercises;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
