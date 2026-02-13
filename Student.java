import java.io.Serializable;

/**
 * Student class to represent individual students in the management system.
 * Implements Serializable for file persistence.
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String rollNumber;
    private String grade;
    private int age;
    private String email;
    private String phoneNumber;
    
    // Default constructor
    public Student() {
    }
    
    // Parameterized constructor
    public Student(String name, String rollNumber, String grade, int age, String email, String phoneNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRollNumber() {
        return rollNumber;
    }
    
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Roll Number: %s\n" +
            "Name: %s\n" +
            "Grade: %s\n" +
            "Age: %d\n" +
            "Email: %s\n" +
            "Phone: %s\n" +
            "----------------------------------------",
            rollNumber, name, grade, age, email, phoneNumber
        );
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNumber != null && rollNumber.equals(student.rollNumber);
    }
    
    @Override
    public int hashCode() {
        return rollNumber != null ? rollNumber.hashCode() : 0;
    }
}

