import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StudentManagementSystem class to manage the collection of students.
 * Provides methods to add, remove, search, and display students.
 * Handles file persistence for data storage.
 */
public class StudentManagementSystem {
    private List<Student> students;
    
    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }
    
    /**
     * Search for a student by roll number.
     * @param rollNumber The roll number to search for
     * @return The student if found, null otherwise
     */
    public Student searchByRollNumber(String rollNumber) {
        return students.stream()
                .filter(s -> s.getRollNumber().equalsIgnoreCase(rollNumber))
                .findFirst()
                .orElse(null);
    }
}
