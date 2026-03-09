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
        System.out.println("Starting application...");
    }
}
