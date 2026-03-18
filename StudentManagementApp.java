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
    
    /**
     * Display the main menu options.
     */
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
    
    /**
     * Get and validate menu choice from user.
     * @return The menu choice as an integer
     */
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
    
    /**
     * Add a new student to the system.
     */
    private void addStudent() {
        System.out.println("\n========== ADD NEW STUDENT ==========");
        
        // Roll Number
        String rollNumber;
        while (true) {
            System.out.print("Enter Roll Number: ");
            rollNumber = scanner.nextLine().trim();
            if (InputValidator.validateRollNumber(rollNumber)) {
                // Check if roll number already exists
                if (sms.searchByRollNumber(rollNumber) != null) {
                    System.out.println("Error: Student with this roll number already exists!");
                    System.out.print("Do you want to try again? (y/n): ");
                    if (!scanner.nextLine().trim().equalsIgnoreCase("y")) {
                        return;
                    }
                } else {
                    break;
                }
            }
        }
        
        // Name
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine().trim();
            if (InputValidator.validateName(name)) {
                break;
            }
        }
        
        // Grade
        String grade;
        while (true) {
            System.out.print("Enter Grade: ");
            grade = scanner.nextLine().trim();
            if (InputValidator.validateGrade(grade)) {
                break;
            }
        }
        
        // Age
        int age;
        while (true) {
            System.out.print("Enter Age: ");
            String ageStr = scanner.nextLine().trim();
            age = InputValidator.parseAge(ageStr);
            if (age != -1) {
                break;
            }
        }
        
        // Email
        String email;
        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine().trim();
            if (InputValidator.validateEmail(email)) {
                break;
            }
        }
        
        // Phone Number
        String phoneNumber;
        while (true) {
            System.out.print("Enter Phone Number (10 digits): ");
            phoneNumber = scanner.nextLine().trim();
            if (InputValidator.validatePhoneNumber(phoneNumber)) {
                break;
            }
        }
        
        // Create and add student
        Student student = new Student(name, rollNumber, grade, age, email, phoneNumber);
        if (sms.addStudent(student)) {
            System.out.println("\n✓ Student added successfully!");
        } else {
            System.out.println("\n✗ Failed to add student!");
        }
    }
    
    /**
     * Remove a student from the system.
     */
    private void removeStudent() {
        System.out.println("\n========== REMOVE STUDENT ==========");
        System.out.print("Enter Roll Number to remove: ");
        String rollNumber = scanner.nextLine().trim();
        
        if (rollNumber.isEmpty()) {
            System.out.println("Error: Roll number cannot be empty!");
            return;
        }
        
        Student student = sms.searchByRollNumber(rollNumber);
        if (student == null) {
            System.out.println("\n✗ Student not found!");
            return;
        }
        
        System.out.println("\nStudent found:");
        System.out.println(student);
        System.out.print("\nAre you sure you want to remove this student? (y/n): ");
        String confirmation = scanner.nextLine().trim();
        
        if (confirmation.equalsIgnoreCase("y")) {
            if (sms.removeStudent(rollNumber)) {
                System.out.println("\n✓ Student removed successfully!");
            } else {
                System.out.println("\n✗ Failed to remove student!");
            }
        } else {
            System.out.println("\nOperation cancelled.");
        }
    }
    
    /**
     * Search for a student in the system.
     */
    private void searchStudent() {
        System.out.println("\n========== SEARCH STUDENT ==========");
        System.out.println("1. Search by Roll Number");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Grade");
        System.out.print("Enter your choice: ");
        
        int choice = getMenuChoice();
        List<Student> results;
        
        switch (choice) {
            case 1:
                System.out.print("Enter Roll Number: ");
                String rollNumber = scanner.nextLine().trim();
                if (rollNumber.isEmpty()) {
                    System.out.println("Error: Roll number cannot be empty!");
                    return;
                }
                Student student = sms.searchByRollNumber(rollNumber);
                if (student != null) {
                    System.out.println("\n✓ Student found:");
                    System.out.println(student);
                } else {
                    System.out.println("\n✗ Student not found!");
                }
                return;
                
            case 2:
                System.out.print("Enter Name: ");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Error: Name cannot be empty!");
                    return;
                }
                results = sms.searchByName(name);
                break;
                
            case 3:
                System.out.print("Enter Grade: ");
                String grade = scanner.nextLine().trim();
                if (grade.isEmpty()) {
                    System.out.println("Error: Grade cannot be empty!");
                    return;
                }
                results = sms.searchByGrade(grade);
                break;
                
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        if (results.isEmpty()) {
            System.out.println("\n✗ No students found!");
        } else {
            System.out.println("\n✓ Found " + results.size() + " student(s):\n");
            for (Student s : results) {
                System.out.println(s);
                System.out.println();
            }
        }
    }
    
    /**
     * Update an existing student's information.
     */
    private void updateStudent() {
        System.out.println("\n========== UPDATE STUDENT ==========");
        System.out.print("Enter Roll Number to update: ");
        String rollNumber = scanner.nextLine().trim();
        
        if (rollNumber.isEmpty()) {
            System.out.println("Error: Roll number cannot be empty!");
            return;
        }
        
        Student existingStudent = sms.searchByRollNumber(rollNumber);
        if (existingStudent == null) {
            System.out.println("\n✗ Student not found!");
            return;
        }
        
        System.out.println("\nCurrent student information:");
        System.out.println(existingStudent);
        System.out.println("\nEnter new information (press Enter to keep current value):");
        
        // Name
        System.out.print("Enter Name [" + existingStudent.getName() + "]: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            name = existingStudent.getName();
        } else {
            while (!InputValidator.validateName(name)) {
                System.out.print("Enter Name [" + existingStudent.getName() + "]: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    name = existingStudent.getName();
                    break;
                }
            }
        }
        
        // Grade
        System.out.print("Enter Grade [" + existingStudent.getGrade() + "]: ");
        String grade = scanner.nextLine().trim();
        if (grade.isEmpty()) {
            grade = existingStudent.getGrade();
        } else {
            while (!InputValidator.validateGrade(grade)) {
                System.out.print("Enter Grade [" + existingStudent.getGrade() + "]: ");
                grade = scanner.nextLine().trim();
                if (grade.isEmpty()) {
                    grade = existingStudent.getGrade();
                    break;
                }
            }
        }
        
        // Age
        System.out.print("Enter Age [" + existingStudent.getAge() + "]: ");
        String ageStr = scanner.nextLine().trim();
        int age = existingStudent.getAge();
        if (!ageStr.isEmpty()) {
            int newAge = InputValidator.parseAge(ageStr);
            if (newAge != -1) {
                age = newAge;
            } else {
                System.out.println("Keeping current age: " + age);
            }
        }
        
        // Email
        System.out.print("Enter Email [" + existingStudent.getEmail() + "]: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            email = existingStudent.getEmail();
        } else {
            while (!InputValidator.validateEmail(email)) {
                System.out.print("Enter Email [" + existingStudent.getEmail() + "]: ");
                email = scanner.nextLine().trim();
                if (email.isEmpty()) {
                    email = existingStudent.getEmail();
                    break;
                }
            }
        }
        
        // Phone Number
        System.out.print("Enter Phone Number [" + existingStudent.getPhoneNumber() + "]: ");
        String phoneNumber = scanner.nextLine().trim();
        if (phoneNumber.isEmpty()) {
            phoneNumber = existingStudent.getPhoneNumber();
        } else {
            while (!InputValidator.validatePhoneNumber(phoneNumber)) {
                System.out.print("Enter Phone Number [" + existingStudent.getPhoneNumber() + "]: ");
                phoneNumber = scanner.nextLine().trim();
                if (phoneNumber.isEmpty()) {
                    phoneNumber = existingStudent.getPhoneNumber();
                    break;
                }
            }
        }
        
        // Create updated student
        Student updatedStudent = new Student(name, rollNumber, grade, age, email, phoneNumber);
        if (sms.updateStudent(rollNumber, updatedStudent)) {
            System.out.println("\n✓ Student information updated successfully!");
        } else {
            System.out.println("\n✗ Failed to update student information!");
        }
    }
    
    /**
     * Display all students in the system.
     */
    private void displayAllStudents() {
        System.out.println("\n========== ALL STUDENTS ==========");
        List<Student> students = sms.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("Total Students: " + students.size() + "\n");
            for (Student student : students) {
                System.out.println(student);
                System.out.println();
            }
        }
    }
    
    private void displayStatistics() {}
}
