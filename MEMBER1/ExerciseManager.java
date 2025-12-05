/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kingd
 */
package MEMBER1;
import java.util.ArrayList;

public class ExerciseManager {

    private static final ArrayList<Exercise> exercises = new ArrayList<>();

    public static void addExercise(Exercise e) {
        exercises.add(e);
    }

    public static ArrayList<Exercise> getExercises() {
        return exercises;
    }
}

