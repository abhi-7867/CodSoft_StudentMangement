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
    
    /**
     * Main menu loop for the application.
     */
    public void run() {
        boolean running = true;
        
        System.out.println("========================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("========================================\n");
        
        while (running) {
            displayMainMenu();
            int choice = getMenuChoice();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    displayStatistics();
                    break;
                case 7:
                    System.out.println("\nThank you for using Student Management System!");
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
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
    
    private void addStudent() {}
    private void removeStudent() {}
    private void searchStudent() {}
    private void updateStudent() {}
    private void displayAllStudents() {}
    private void displayStatistics() {}
}
