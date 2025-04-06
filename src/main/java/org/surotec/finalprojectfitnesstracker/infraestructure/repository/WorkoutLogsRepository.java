package org.surotec.finalprojectfitnesstracker.infraestructure.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutLogsRepository;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutLogsRepository implements IWorkoutLogsRepository {

    private String fileName = "workoutsLogs.txt";
    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    @Override
    public WorkoutLog save(WorkoutLog workoutLog) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile(); // crea el archivo si no existe
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(workoutLog.toString() + "\n");
                System.out.println("Workout Log saved successfully.");
                return workoutLog;
            }

        } catch (IOException e) {
            System.out.println("Error saving Workout Log: " + e.getMessage());
            System.out.println("Tried to write to: " + file.getAbsolutePath());
            return null;
        }
    }



    @Override
    public List<WorkoutLog> findAll(String email) {
        List<WorkoutLog> workoutLogs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                WorkoutLog log = gson.fromJson(line, WorkoutLog.class);
                workoutLogs.add(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workoutLogs.stream()
                .filter(log -> log.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }


    }
