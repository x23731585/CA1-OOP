package MEMBER3;

import java.util.ArrayList;

/**
 *.
 *  calculates total point from a challenge.
 * tracks user progress if they completed challenge etc
 *  
 */
public class UserProgress {

    private String username; 
    private ArrayList<ChallengeEntry> activeChallenges; //users active challenges that havent been finished
    private ArrayList<ChallengeEntry> completedChallenges; // users completed challenges

    //constructor for profile creation  
    public UserProgress(String username) {
        this.username = username;
        // Create empty lists to store the users active and completed challenges
        this.activeChallenges = new ArrayList<>();
        this.completedChallenges = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    // Add a active challenge the user joined
    public void addActiveChallenge(ChallengeEntry c) {
        if (c != null) {
            activeChallenges.add(c);
        }
    }

    // Get active challenges
    public ArrayList<ChallengeEntry> getActiveChallenges() {
        return activeChallenges;
    }

    // change challenge from active to completed
    public void completeChallenge(ChallengeEntry c) {
        if (c != null && c.isCompleted()) {
            completedChallenges.add(c);
            activeChallenges.remove(c);
        }
    }

    // Get completed challenges
    public ArrayList<ChallengeEntry> getCompletedChallenges() {
        return completedChallenges;
    }

    // Calculate total points from all completed challenges
    public int getTotalPoints() {
        int total = 0;
        for (ChallengeEntry c : completedChallenges) {
            total += c.getPoints();
        }
        return total;
    }

    @Override
    public String toString() {
        return username + " - " + getTotalPoints() + " pts";
    }
}
