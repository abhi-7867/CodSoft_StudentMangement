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
    private static final String DATA_FILE = "students.dat";
    
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
    
    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    public List<Student> searchByGrade(String grade) {
        return students.stream()
                .filter(s -> s.getGrade().equalsIgnoreCase(grade))
                .collect(Collectors.toList());
    }
    
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    public int getStudentCount() {
        return students.size();
    }
    
    public boolean updateStudent(String rollNumber, Student updatedStudent) {
        Student existingStudent = searchByRollNumber(rollNumber);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
            return true;
        }
        return false;
    }
    
    /**
     * Save all students to a file using serialization.
     */
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }
}
