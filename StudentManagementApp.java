import java.util.List;
import java.util.Scanner;

/**
 * Main application class for Student Management System.
 * Provides a console-based user interface for interacting with the system.
 */
public class StudentManagementApp {
    private StudentManagementSystem sms;
    private Scanner scanner;
    
    public StudentManagementApp() {
        this.sms = new StudentManagementSystem();
        this.scanner = new Scanner(System.in);
    }
    
    public static void main(String[] args) {
        StudentManagementApp app = new StudentManagementApp();
        app.run();
    }
    
    public void run() {
        displayMainMenu();
    }
    
    private void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add New Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student Information");
        System.out.println("5. Display All Students");
        System.out.println("6. Display Statistics");
        System.out.println("7. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice: ");
    }
    
    private int getMenuChoice() {
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return -1;
            }
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
