package org.surotec.finalprojectfitnesstracker.domain.dto;


import com.google.gson.annotations.SerializedName;

public class Exercise {

    @SerializedName("exerciseTitle")
    private String title;
    private String description;
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

