// Author: Desmond Peter
package mentalhealthhub;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Simple GUI for the Mental Health Hub
public class MentalHealthHubGUI extends JFrame {

    private MentalHealthHub hub;

    public MentalHealthHubGUI(MentalHealthHub hub) {
        this.hub = hub;
        initComponents();
    }

    private void initComponents() {
        setTitle("Mental Health Hub");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        JButton btnLogMood = new JButton("Log mood");
        JButton btnViewMoods = new JButton("View moods");
        JButton btnSearchMoods = new JButton("Search moods by date");
        JButton btnDeleteMood = new JButton("Delete mood");
        JButton btnWriteJournal = new JButton("Write journal entry");
        JButton btnViewJournals = new JButton("View journal entries");
        JButton btnSearchJournals = new JButton("Search journals by date");
        JButton btnDeleteJournal = new JButton("Delete journal entry");
        JButton btnStartMeditation = new JButton("Start meditation");
        JButton btnShowProgress = new JButton("Show meditation progress");
        JButton btnTip = new JButton("Show motivational tip");
        JButton btnSave = new JButton("Save all data");
        JButton btnLoad = new JButton("Load all data");

        panel.add(btnLogMood);
        panel.add(btnViewMoods);
        panel.add(btnSearchMoods);
        panel.add(btnDeleteMood);
        panel.add(btnWriteJournal);
        panel.add(btnViewJournals);
        panel.add(btnSearchJournals);
        panel.add(btnDeleteJournal);
        panel.add(btnStartMeditation);
        panel.add(btnShowProgress);
        panel.add(btnTip);
        panel.add(btnSave);
        panel.add(btnLoad);

        add(panel, BorderLayout.CENTER);

        // Button actions
        btnLogMood.addActionListener(e -> logMood());
        btnViewMoods.addActionListener(e -> viewMoods());
        btnSearchMoods.addActionListener(e -> searchMoods());
        btnDeleteMood.addActionListener(e -> deleteMood());
        btnWriteJournal.addActionListener(e -> writeJournal());
        btnViewJournals.addActionListener(e -> viewJournals());
        btnSearchJournals.addActionListener(e -> searchJournals());
        btnDeleteJournal.addActionListener(e -> deleteJournal());
        btnStartMeditation.addActionListener(e -> startMeditation());
        btnShowProgress.addActionListener(e -> showMeditationProgress());
        btnTip.addActionListener(e -> showTip());
        btnSave.addActionListener(e -> saveAll());
        btnLoad.addActionListener(e -> loadAll());
    }

    private LocalDate readDate(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(this, message, "Enter date", JOptionPane.QUESTION_MESSAGE);
            if (input == null) { // cancel
                return null;
            }
            try {
                return LocalDate.parse(input.trim()); // expects YYYY-MM-DD
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid date. Use YYYY-MM-DD.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void logMood() {
        LocalDate date = readDate("Date (YYYY-MM-DD):");
        if (date == null) return;

        String mood = JOptionPane.showInputDialog(this, "Mood:", "Log mood", JOptionPane.QUESTION_MESSAGE);
        if (mood == null) return;

        String notes = JOptionPane.showInputDialog(this, "Notes:", "Log mood", JOptionPane.QUESTION_MESSAGE);
        if (notes == null) return;

        hub.logMood(date, mood, notes);
        JOptionPane.showMessageDialog(this, "Mood logged.");
    }

    private void viewMoods() {
        ArrayList<MoodEntry> list = hub.getMoodEntries();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mood entries.");
            return;
        }
        StringBuilder sb = new StringBuilder("Mood entries:\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1).append(". ").append(list.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void searchMoods() {
        LocalDate date = readDate("Search date (YYYY-MM-DD):");
        if (date == null) return;

        ArrayList<MoodEntry> result = hub.searchMoodsByDate(date);
        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No moods found for that date.");
        } else {
            StringBuilder sb = new StringBuilder("Results:\n");
            for (MoodEntry m : result) {
                sb.append(m).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }

    private void deleteMood() {
        ArrayList<MoodEntry> list = hub.getMoodEntries();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No mood entries to delete.");
            return;
        }

        viewMoods();
        String input = JOptionPane.showInputDialog(this, "Enter number to delete:");
        if (input == null) return;

        try {
            int num = Integer.parseInt(input.trim());
            boolean deleted = hub.deleteMoodByIndex(num - 1);
            if (deleted) {
                JOptionPane.showMessageDialog(this, "Mood deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid number.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void writeJournal() {
        LocalDate date = readDate("Date (YYYY-MM-DD):");
        if (date == null) return;

        String title = JOptionPane.showInputDialog(this, "Title:", "Write journal entry",
                JOptionPane.QUESTION_MESSAGE);
        if (title == null) return;

        String content = JOptionPane.showInputDialog(this, "Content:", "Write journal entry",
                JOptionPane.QUESTION_MESSAGE);
        if (content == null) return;

        hub.addJournalEntry(date, title, content);
        JOptionPane.showMessageDialog(this, "Journal entry saved.");
    }

    private void viewJournals() {
        ArrayList<JournalEntry> list = hub.getJournalEntries();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No journal entries.");
            return;
        }
        StringBuilder sb = new StringBuilder("Journal entries:\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1).append(". ").append(list.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void searchJournals() {
        LocalDate date = readDate("Search date (YYYY-MM-DD):");
        if (date == null) return;

        ArrayList<JournalEntry> result = hub.searchJournalsByDate(date);
        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No journal entries found for that date.");
        } else {
            StringBuilder sb = new StringBuilder("Results:\n");
            for (JournalEntry j : result) {
                sb.append(j).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }

    private void deleteJournal() {
        ArrayList<JournalEntry> list = hub.getJournalEntries();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No journal entries to delete.");
            return;
        }

        viewJournals();
        String input = JOptionPane.showInputDialog(this, "Enter number to delete:");
        if (input == null) return;

        try {
            int num = Integer.parseInt(input.trim());
            boolean deleted = hub.deleteJournalByIndex(num - 1);
            if (deleted) {
                JOptionPane.showMessageDialog(this, "Journal entry deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid number.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void startMeditation() {
        String input = JOptionPane.showInputDialog(this, "Meditation duration (minutes):");
        if (input == null) return;

        try {
            int mins = Integer.parseInt(input.trim());
            hub.startMeditation(mins);
            JOptionPane.showMessageDialog(this, "Meditation started for " + mins + " minutes.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void showMeditationProgress() {
        MeditationTimer timer = hub.getMeditationTimer();
        if (timer == null) {
            JOptionPane.showMessageDialog(this, "No meditation in progress.");
        } else {
            JOptionPane.showMessageDialog(this, timer.updateProgress());
        }
    }

    private void showTip() {
        JOptionPane.showMessageDialog(this, "Tip: " + hub.getRandomTip());
    }

    private void saveAll() {
        try {
            hub.saveMoodEntries("moods.txt");
            hub.saveJournalEntries("journals.txt");
            JOptionPane.showMessageDialog(this, "All data saved.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving: " + e.getMessage());
        }
    }

    private void loadAll() {
        try {
            hub.loadMoodEntries("moods.txt");
            hub.loadJournalEntries("journals.txt");
            JOptionPane.showMessageDialog(this, "All data loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading: " + e.getMessage());
        }
    }
}
