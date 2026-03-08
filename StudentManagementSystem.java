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
        loadStudentsFromFile();
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
        saveStudentsToFile();
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
            saveStudentsToFile();
            return true;
        }
        return false;
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
    
    /**
     * Search for students by name (partial match).
     * @param name The name to search for
     * @return List of students matching the name
     */
    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    /**
     * Search for students by grade.
     * @param grade The grade to search for
     * @return List of students with the specified grade
     */
    public List<Student> searchByGrade(String grade) {
        return students.stream()
                .filter(s -> s.getGrade().equalsIgnoreCase(grade))
                .collect(Collectors.toList());
    }
    
    /**
     * Display all students in the system.
     * @return List of all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
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
            // Update all fields
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGrade(updatedStudent.getGrade());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
            saveStudentsToFile();
            return true;
        }
        return false;
    }
    
    /**
     * Get the total number of students in the system.
     * @return The number of students
     */
    public int getStudentCount() {
        return students.size();
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
    
    /**
     * Load all students from a file using deserialization.
     */
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DATA_FILE))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            students = new ArrayList<>();
        }
    }
}

