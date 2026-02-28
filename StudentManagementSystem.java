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
    
    public boolean addStudent(Student student) {
        if (student == null) {
            return false;
        }
        if (searchByRollNumber(student.getRollNumber()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }
    
    /**
     * Remove a student from the system by roll number.
     * @param rollNumber The roll number of the student to remove
     * @return true if student is removed successfully, false if not found
     */
    public boolean removeStudent(String rollNumber) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
    
    public Student searchByRollNumber(String rollNumber) {
        return students.stream()
                .filter(s -> s.getRollNumber().equalsIgnoreCase(rollNumber))
                .findFirst()
                .orElse(null);
    }
}
