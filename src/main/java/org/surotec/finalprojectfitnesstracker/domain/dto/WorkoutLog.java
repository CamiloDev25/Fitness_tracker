package org.surotec.finalprojectfitnesstracker.domain.dto;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutLog {
    private String workoutTitle;
    private String email;
    @SerializedName("exercises")
    private List<Exercise> exerciseList;
    private LocalDateTime date;


    public WorkoutLog(String workoutTitle, String email, List<Exercise> exerciseList, LocalDateTime date) {
        this.workoutTitle = workoutTitle;
        this.email = email;
        this.exerciseList = exerciseList;
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("  \"workoutTitle\": \"").append(workoutTitle).append("\",");
        sb.append("  \"email\": \"").append(email).append("\",");
        sb.append("  \"exercises\": ["); // Abre un array

        for (int i = 0; i < exerciseList.size(); i++) {
            Exercise ex = exerciseList.get(i);
            sb.append("    {");
            sb.append("      \"exerciseTitle\": \"").append(ex.getTitle()).append("\",");
            sb.append("      \"time\": ").append(ex.getTime());
            sb.append("    }");
            if (i < exerciseList.size() - 1) {
                sb.append(","); // Agrega coma solo si no es el último elemento
            }
        }
        sb.append("]"); // Cierra el array

        sb.append(",");
        sb.append("  \"date\": \"").append(date.toString()).append("\"");
        sb.append("}");

        return sb.toString();
    }

    public String getWorkoutTitle() {
        return workoutTitle;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }
}

