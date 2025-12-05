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

public class MealManager {

    private static final ArrayList<Meal> meals = new ArrayList<>();

    public static void addMeal(Meal m) {
        meals.add(m);
    }

    public static ArrayList<Meal> getMeals() {
        return meals;
    }
}

