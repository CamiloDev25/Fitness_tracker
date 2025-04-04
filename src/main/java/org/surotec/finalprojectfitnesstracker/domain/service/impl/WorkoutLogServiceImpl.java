package org.surotec.finalprojectfitnesstracker.domain.service.impl;


import org.surotec.finalprojectfitnesstracker.domain.dto.Exercise;
import org.surotec.finalprojectfitnesstracker.domain.dto.Workout;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLog;
import org.surotec.finalprojectfitnesstracker.domain.dto.WorkoutLogDetail;
import org.surotec.finalprojectfitnesstracker.domain.service.WorkoutService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkoutLogServiceImpl implements WorkoutLogService {


    private WorkoutService workoutService; // get workouts

    public WorkoutLogServiceImpl(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @Override
    public WorkoutLog logWorkout() {
        Scanner scanner = new Scanner(System.in);
        List<Workout> workouts = workoutService.findAll(); // get all workouts

        System.out.println("Available workouts:");
        for (int i = 0; i < workouts.size(); i++) {
            System.out.println((i + 1) + ". " + workouts.get(i).getTitle());
        }

        System.out.print("Select a workout by number: ");
        int workoutIndex = scanner.nextInt() - 1; // user entrance
        Workout selectedWorkout = workouts.get(workoutIndex);

        WorkoutLog workoutLog = new WorkoutLog();
        workoutLog.setWorkoutTitle(selectedWorkout.getTitle());
        workoutLog.setWorkout(selectedWorkout); //asignación de objeto
        workoutLog.setDate(java.time.LocalDate.now().toString()); // current date  (is not functional for now)

        List<WorkoutLogDetail> workoutLogDetailList = new ArrayList<>(); //lista de worko

        for (Exercise exercise : selectedWorkout.getExercises()) {
            System.out.print("Enter time taken for " + exercise.getTitle() + " (in minutes): ");
            int timeTaken = scanner.nextInt();
            workoutLog.getExerciseTimes().put(exercise.getTitle(), timeTaken);
            WorkoutLogDetail workoutLogDetail1 = new WorkoutLogDetail();
            workoutLogDetail1.setExercise(exercise);
            workoutLogDetail1.setTimeTaken(timeTaken);

            workoutLogDetailList.add(workoutLogDetail1);
        }

        workoutLog.setWorkoutLogDetails(workoutLogDetailList); //lista con los valores
       // TODO el tiempo total calculado se tien que hacer con el logdetailList en lugar del mapa
        workoutLog.calculateTotalTime(); // total time

        return workoutLog;
    }

}
