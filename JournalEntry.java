// Desmond 
package MEMBER2;

import java.time.LocalDate;

// Stores one journal entry written by the user
public class JournalEntry {

    private LocalDate date;
    private String title;
    private String content;

    public JournalEntry(LocalDate date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return date + " - " + title + ": " + content;
    }
}
