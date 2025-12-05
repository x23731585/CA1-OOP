//  Desmond 
package MEMBER2;

import java.time.LocalDate;

// This stores one mood entry for a given day
public class MoodEntry {

    private LocalDate date;
    private String mood;
    private String notes;

    public MoodEntry(LocalDate date, String mood, String notes) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return date + " - " + mood + " (" + notes + ")";
    }
}
