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
     * Add a new student to the system.
     * @param student The student to add
     * @return true if student is added successfully, false if roll number already exists
     */
    public boolean addStudent(Student student) {
        if (student == null) {
            return false;
        }
        
        // Check if student with same roll number already exists
        if (searchByRollNumber(student.getRollNumber()) != null) {
            return false;
        }
        
        students.add(student);
        return true;
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
