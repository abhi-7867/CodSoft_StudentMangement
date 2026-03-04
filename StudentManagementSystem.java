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
    
    /**
     * Update an existing student's information.
     * @param rollNumber The roll number of the student to update
     * @param updatedStudent The updated student information
     * @return true if student is updated successfully, false if not found
     */
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
}
