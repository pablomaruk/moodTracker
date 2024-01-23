import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MoodTracker {
    private ArrayList<String> moods;
    private Map<String, Integer> moodCounts;

    public MoodTracker() {
        this.moods = new ArrayList<>();
        this.moodCounts = new HashMap<>();
        initializeMoods();
    }

    private void initializeMoods() {
        moods.add("Happy");
        moods.add("Sad");
        moods.add("Angry");
        moods.add("Excited");
        moods.add("Calm");

        // Initialize mood counts
        for (String mood : moods) {
            moodCounts.put(mood, 0);
        }
    }

    public void logMood(String mood) {
        if (moods.contains(mood)) {
            moods.add(mood);
            int count = moodCounts.get(mood);
            moodCounts.put(mood, count + 1);
            System.out.println("Mood logged: " + mood);
        } else {
            System.out.println("Invalid mood. Please choose from the available options.");
        }
    }

    public void displayMoodCounts() {
        System.out.println("----- Mood Counts -----");
        for (String mood : moods) {
            int count = moodCounts.get(mood);
            System.out.println(mood + ": " + count);
        }
        System.out.println("-----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoodTracker moodTracker = new MoodTracker();

        while (true) {
            System.out.println("1. Log Mood");
            System.out.println("2. Display Mood Counts");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your mood: ");
                    String mood = scanner.nextLine();
                    moodTracker.logMood(mood);
                    break;

                case 2:
                    moodTracker.displayMoodCounts();
                    break;

                case 3:
                    System.out.println("Exiting Mood Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
