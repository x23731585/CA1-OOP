// Desmond 
package mentalhealthhub;

import java.time.Duration;
import java.time.LocalTime;

// A basic timer used for meditation sessions
public class MeditationTimer {

    private int durationMinutes;
    private boolean isRunning;
    private LocalTime startTime;

    public MeditationTimer(int durationMinutes) {
        this.durationMinutes = durationMinutes;
        this.isRunning = false;
    }

    public void startTimer() {
        startTime = LocalTime.now();
        isRunning = true;
    }

    public void stopTimer() {
        isRunning = false;
    }

    // Calculates progress as a percentage (0–100)
    public double getProgressPercentage() {
        if (!isRunning || startTime == null || durationMinutes <= 0) {
            return 0.0;
        }

        long secondsPassed = Duration.between(startTime, LocalTime.now()).getSeconds();
        double minutesPassed = secondsPassed / 60.0;

        double percent = (minutesPassed / durationMinutes) * 100.0;
        return Math.min(percent, 100.0);
    }

    public String updateProgress() {
        return String.format("Meditation progress: %.1f%%", getProgressPercentage());
    }

    @Override
    public String toString() {
        return "Meditation for " + durationMinutes + " minutes. Running: " + isRunning;
    }
}
