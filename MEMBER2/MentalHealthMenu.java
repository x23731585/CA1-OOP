// Desmon
package mentalhealthhub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Console menu to interact with the MentalHealthHub
public class MentalHealthMenu {

    private MentalHealthHub hub;
    private Scanner in;

    public MentalHealthMenu(MentalHealthHub hub) {
        this.hub = hub;
        this.in = new Scanner(System.in);
    }

    // Main menu loop
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Mental Health Hub ===");
            System.out.println("1. Log mood");
            System.out.println("2. View moods");
            System.out.println("3. Search moods by date");
            System.out.println("4. Delete mood by number");
            System.out.println("5. Write journal entry");
            System.out.println("6. View journal entries");
            System.out.println("7. Search journals by date");
            System.out.println("8. Delete journal entry by number");
            System.out.println("9. Start meditation timer");
            System.out.println("10. Show meditation progress");
            System.out.println("11. Show motivational tip");
            System.out.println("12. Save all data");
            System.out.println("13. Load all data");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = in.nextLine().trim();

            switch (choice) {
                case "1": logMood(); break;
                case "2": viewMoods(); break;
                case "3": searchMoods(); break;
                case "4": deleteMood(); break;
                case "5": writeJournal(); break;
                case "6": viewJournals(); break;
                case "7": searchJournals(); break;
                case "8": deleteJournal(); break;
                case "9": startMeditation(); break;
                case "10": showMeditationProgress(); break;
                case "11": showTip(); break;
                case "12": saveAll(); break;
                case "13": loadAll(); break;
                case "0": running = false; break;
                default: System.out.println("Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = in.nextLine().trim();
                return LocalDate.parse(input); // format: YYYY-MM-DD
            } catch (Exception e) {
                System.out.println("Invalid date. Use YYYY-MM-DD.");
            }
        }
    }

    private void logMood() {
        LocalDate date = readDate("Date (YYYY-MM-DD): ");
        System.out.print("Mood: ");
        String mood = in.nextLine();
        System.out.print("Notes: ");
        String notes = in.nextLine();
        hub.logMood(date, mood, notes);
        System.out.println("Mood logged.");
    }

    private void viewMoods() {
        ArrayList<MoodEntry> list = hub.getMoodEntries();
        if (list.isEmpty()) {
            System.out.println("No mood entries.");
        } else {
            System.out.println("\n-- Mood Entries --");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private void searchMoods() {
        LocalDate date = readDate("Search date (YYYY-MM-DD): ");
        ArrayList<MoodEntry> result = hub.searchMoodsByDate(date);
        if (result.isEmpty()) {
            System.out.println("No moods found for that date.");
        } else {
            System.out.println("\n-- Results --");
            for (MoodEntry m : result) {
                System.out.println(m);
            }
        }
    }

    private void deleteMood() {
        viewMoods();
        System.out.print("Enter number to delete: ");
        try {
            int num = Integer.parseInt(in.nextLine().trim());
            boolean deleted = hub.deleteMoodByIndex(num - 1);
            if (deleted) {
                System.out.println("Mood deleted.");
            } else {
                System.out.println("Invalid number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void writeJournal() {
        LocalDate date = readDate("Date (YYYY-MM-DD): ");
        System.out.print("Title: ");
        String title = in.nextLine();
        System.out.println("Content:");
        String content = in.nextLine();
        hub.addJournalEntry(date, title, content);
        System.out.println("Journal entry saved.");
    }

    private void viewJournals() {
        ArrayList<JournalEntry> list = hub.getJournalEntries();
        if (list.isEmpty()) {
            System.out.println("No journal entries.");
        } else {
            System.out.println("\n-- Journal Entries --");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private void searchJournals() {
        LocalDate date = readDate("Search date (YYYY-MM-DD): ");
        ArrayList<JournalEntry> result = hub.searchJournalsByDate(date);
        if (result.isEmpty()) {
            System.out.println("No journal entries found for that date.");
        } else {
            System.out.println("\n-- Results --");
            for (JournalEntry j : result) {
                System.out.println(j);
            }
        }
    }

    private void deleteJournal() {
        viewJournals();
        System.out.print("Enter number to delete: ");
        try {
            int num = Integer.parseInt(in.nextLine().trim());
            boolean deleted = hub.deleteJournalByIndex(num - 1);
            if (deleted) {
                System.out.println("Journal entry deleted.");
            } else {
                System.out.println("Invalid number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void startMeditation() {
        System.out.print("Meditation duration (minutes): ");
        String input = in.nextLine().trim();
        try {
            int mins = Integer.parseInt(input);
            hub.startMeditation(mins);
            System.out.println("Meditation started for " + mins + " minutes.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private void showMeditationProgress() {
        MeditationTimer timer = hub.getMeditationTimer();
        if (timer == null) {
            System.out.println("No meditation in progress.");
        } else {
            System.out.println(timer.updateProgress());
        }
    }

    private void showTip() {
        System.out.println("Tip: " + hub.getRandomTip());
    }

    private void saveAll() {
        try {
            hub.saveMoodEntries("moods.txt");
            hub.saveJournalEntries("journals.txt");
            System.out.println("All data saved.");
        } catch (Exception e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadAll() {
        try {
            hub.loadMoodEntries("moods.txt");
            hub.loadJournalEntries("journals.txt");
            System.out.println("All data loaded.");
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}
