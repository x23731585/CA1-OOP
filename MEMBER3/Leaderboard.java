package MEMBER3;

import java.util.ArrayList;

/**
 *. 
 * Add, search, Update, Get All.
 * Stores users and progress
 */



public class Leaderboard {
     // Stores list of users who joined challenges
    private ArrayList<UserProgress> users = new ArrayList<>();
    
    public ArrayList<UserProgress> getUsers() {
        return users;
    }
    
    //search for user
    public UserProgress findUser(String username) {
        for (UserProgress u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }
    //adds new user or updates user
    public void addOrUpdateUser(UserProgress user) {
        UserProgress existing = findUser(user.getUsername());
            
        if (existing != null) {
            users.remove(existing);
        }

        users.add(user);
    }
}
