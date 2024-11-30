import java.util.HashMap;
import java.util.Scanner;

public class HeapsConsole {

    private static HashMap<Integer, String> studentDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Student Database Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    addStudent(id, name);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextInt();
                    getStudent(id);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextInt();
                    removeStudent(id);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void addStudent(int id, String name) {
        studentDatabase.put(id, name);
        System.out.println("Student added: " + name);
    }

    public static void getStudent(int id) {
        if (studentDatabase.containsKey(id)) {
            System.out.println("Student found: " + studentDatabase.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void removeStudent(int id) {
        if (studentDatabase.containsKey(id)) {
            studentDatabase.remove(id);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
