package MEMBER1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Workout.java
 * class for storing info,
 * @author Kingde
 */  
public class Exercise {
    private final String type; // information cant be changed after being inputted 
    private final int duration;
    private final String intensity;
    private final int caloriesBurned; // calculated automatically

// constructor to initialize all fields
public Exercise(String type, int duration, String intensity) {
    this.type = type;
    this.duration = duration;
    this.intensity = intensity;
    this.caloriesBurned = calculateCalories();
}

// getters
public String getType() { return type; }
public int getDuration() { return duration; }
public String getIntensity() { return intensity; }
public int getCaloriesBurned() { return caloriesBurned; }

// calculates calories based on duration and intensity automatically
    private int calculateCalories() {
        switch (intensity.toLowerCase()) {
            case "low": return duration * 4;
            case "medium": return duration * 7;
            case "high": return duration * 10;
            default: return 0;
        }
    }


// returns formatted exercise information
@Override
public String toString() {
return "Your " + type + " for " + duration + " minutes at " + intensity + "level burned -> " + caloriesBurned + " kcal";
}
}
