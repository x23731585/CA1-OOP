// Author: Desmond Peter
package mentalhealthhub;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// Stores all mood entries, journal entries and meditation data
public class MentalHealthHub {

    private ArrayList<MoodEntry> moodEntries;
    private ArrayList<JournalEntry> journalEntries;
    private MeditationTimer meditationTimer;
    private final DateTimeFormatter DATE_FMT = DateTimeFormatter.ISO_LOCAL_DATE;

    public MentalHealthHub() {
        moodEntries = new ArrayList<>();
        journalEntries = new ArrayList<>();
    }

    // ---------- Mood methods ----------

    public void logMood(LocalDate date, String mood, String notes) {
        MoodEntry entry = new MoodEntry(date, mood, notes);
        moodEntries.add(entry);
    }

    public ArrayList<MoodEntry> getMoodEntries() {
        return moodEntries;
    }

    // Search moods for a particular date
    public ArrayList<MoodEntry> searchMoodsByDate(LocalDate date) {
        ArrayList<MoodEntry> result = new ArrayList<>();
        for (MoodEntry m : moodEntries) {
            if (m.getDate().equals(date)) {
                result.add(m);
            }
        }
        return result;
    }

    // Delete mood by index (0-based). Returns true if delete succeeds
    public boolean deleteMoodByIndex(int index) {
        if (index >= 0 && index < moodEntries.size()) {
            moodEntries.remove(index);
            return true;
        }
        return false;
    }

    // Save moods to a text file
    public void saveMoodEntries(String filePath) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (MoodEntry m : moodEntries) {
                out.println(m.getDate().format(DATE_FMT) + "|" +
                            m.getMood() + "|" +
                            m.getNotes());
            }
        }
    }

    // Load moods from a text file
    public void loadMoodEntries(String filePath) throws IOException {
        moodEntries.clear();

        File f = new File(filePath);
        if (!f.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 3);
                if (parts.length == 3) {
                    LocalDate date = LocalDate.parse(parts[0], DATE_FMT);
                    logMood(date, parts[1], parts[2]);
                }
            }
        }
    }

    // ---------- Journal methods ----------

    public void addJournalEntry(LocalDate date, String title, String content) {
        JournalEntry entry = new JournalEntry(date, title, content);
        journalEntries.add(entry);
    }

    public ArrayList<JournalEntry> getJournalEntries() {
        return journalEntries;
    }

    public ArrayList<JournalEntry> searchJournalsByDate(LocalDate date) {
        ArrayList<JournalEntry> result = new ArrayList<>();
        for (JournalEntry j : journalEntries) {
            if (j.getDate().equals(date)) {
                result.add(j);
            }
        }
        return result;
    }

    public boolean deleteJournalByIndex(int index) {
        if (index >= 0 && index < journalEntries.size()) {
            journalEntries.remove(index);
            return true;
        }
        return false;
    }

    // Save journal entries to a text file
    public void saveJournalEntries(String filePath) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (JournalEntry j : journalEntries) {
                out.println(j.getDate().format(DATE_FMT) + "|" +
                            j.getTitle() + "|" +
                            j.getContent());
            }
        }
    }

    // Load journal entries from a text file
    public void loadJournalEntries(String filePath) throws IOException {
        journalEntries.clear();

        File f = new File(filePath);
        if (!f.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", 3);
                if (parts.length == 3) {
                    LocalDate date = LocalDate.parse(parts[0], DATE_FMT);
                    addJournalEntry(date, parts[1], parts[2]);
                }
            }
        }
    }

    // ---------- Meditation methods ----------

    public void startMeditation(int durationMinutes) {
        meditationTimer = new MeditationTimer(durationMinutes);
        meditationTimer.startTimer();
    }

    public MeditationTimer getMeditationTimer() {
        return meditationTimer;
    }

    // ---------- Motivational tips ----------

    public String getRandomTip() {
        String[] tips = {
            "You are doing your best.",
            "Remember to take a deep breath.",
            "Small steps every day help.",
            "Be kind to yourself today.",
            "It's okay to take a day off."
        };
        int index = (int) (Math.random() * tips.length);
        return tips[index];
    }
}
