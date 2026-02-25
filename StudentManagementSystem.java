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
}
