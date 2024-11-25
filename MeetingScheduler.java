import java.util.PriorityQueue;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    String title;
    String date;  // Format: YYYY-MM-DD
    String time;  // Format: HH:MM

    public Meeting(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    @Override
    public int compareTo(Meeting other) {
        // Compare by date first, then by time
        String thisDateTime = this.date + " " + this.time;
        String otherDateTime = other.date + " " + other.time;
        return thisDateTime.compareTo(otherDateTime);
    }

    @Override
    public String toString() {
        return title + " on " + date + " at " + time;
    }
}

public class MeetingScheduler {
    public static void main(String[] args) {
        PriorityQueue<Meeting> meetingQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMeeting Scheduler Menu:");
            System.out.println("1. Add Meeting");
            System.out.println("2. View All Meetings");
            System.out.println("3. Retrieve Next Meeting");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter meeting title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter meeting date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter meeting time (HH:MM): ");
                    String time = scanner.nextLine();
                    meetingQueue.add(new Meeting(title, date, time));
                    System.out.println("Meeting added.");
                    break;
                case 2:
                    if (meetingQueue.isEmpty()) {
                        System.out.println("No meetings scheduled.");
                    } else {
                        System.out.println("Scheduled Meetings:");
                        for (Meeting meeting : meetingQueue) {
                            System.out.println(meeting);
                        }
                    }
                    break;
                case 3:
                    if (meetingQueue.isEmpty()) {
                        System.out.println("No meetings to retrieve.");
                    } else {
                        System.out.println("Next Meeting: " + meetingQueue.poll());
                    }
                    break;
                case 4:
                    System.out.println("Exiting Meeting Scheduler. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
