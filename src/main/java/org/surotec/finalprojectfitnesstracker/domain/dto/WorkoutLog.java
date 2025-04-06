package org.surotec.finalprojectfitnesstracker.domain.dto;
import java.time.LocalDateTime;

public class WorkoutLog {
    private String workoutTitle;
    private String userName;
    private int totalTime;
    private LocalDateTime date;

    public WorkoutLog(String workoutTitle, String userName, int totalTime) {
        this.workoutTitle = workoutTitle;
        this.userName = userName;
        this.totalTime = totalTime;
        this.date = LocalDateTime.now();
    }

    }

