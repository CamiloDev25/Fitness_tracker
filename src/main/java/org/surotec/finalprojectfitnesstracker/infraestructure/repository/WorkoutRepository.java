package org.surotec.finalprojectfitnesstracker.infraestructure.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.repository.IWorkoutRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutRepository implements IWorkoutRepository {

    private String fileName = "Workout.txt";

    @Override
    public List<Workout> findAll() {
        List<Workout> workouts = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                JsonNode node = objectMapper.readTree(line);
                Workout workout = new Workout();
                workout.setTitle(node.get("title").asText());
                workout.setDescription(node.get("description").asText());

                List<Exercise> exerciseList = new ArrayList<>();
                for (JsonNode exNode : node.get("exercises")) {
                    Exercise ex = new Exercise();
                    ex.setTitle(exNode.get("title").asText());
                    ex.setDescription(exNode.get("description").asText());
                    exerciseList.add(ex);
                }

                workout.setExercises(exerciseList);
                workouts.add(workout);
            }
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());

        }
            return workouts;
        }

    }

