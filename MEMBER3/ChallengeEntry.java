/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MEMBER3;


public class ChallengeEntry {

    private String name; //challenge name 
    private String description; // challenge description 
    private int points; // points user gets 
    private int goal; //challenge goal
    private int progress; // user progress
    private boolean completed; // challenge completed 

    
    //constructor 
    public ChallengeEntry(String name, String description, int points, int goal, boolean completed) {
        this.name = name; 
        this.description = description;
        this.points = points;
        this.goal = goal;
        this.progress = 0;   
        this.completed = completed;
    }
    
    //basic getters for ui and classes
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPoints() { return points; }
    public int getGoal() { return goal; }
    public int getProgress() { return progress; }
    public boolean isCompleted() { return completed; }

    // add progress,
    public void addProgress(int amount) {
        progress += amount;
        
        //  if the goal has been completed is true
        
        if (progress >= goal) {
            completed = true;
        }
    }
}
