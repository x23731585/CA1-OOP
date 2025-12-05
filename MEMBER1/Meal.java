/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MEMBER1;
import java.time.LocalDate;

/**
 * meal info 
 * @author Kingde
 */

public class Meal {

    private final String mealName;       
    private final int calories;          
    private final LocalDate date;        
          
    // constructor 
    public Meal(String mealName, int calories) {
        //validation
         if (mealName == null || mealName.isBlank()) {
            throw new IllegalArgumentException("Meal name cannot be empty.");
        }
        if (calories < 0) {
            throw new IllegalArgumentException("Calories cannot be negative.");
        }
        this.mealName = mealName;
        this.calories = calories;
        this.date = LocalDate.now();
    }


    // getters
    public String getMealName() { return mealName; }
    public int getCalories() { return calories; }
    public LocalDate getDate() { return date; }


    @Override
    public String toString() {
        return mealName + " on " + date + " was " + calories + " kcal";
    }
}
