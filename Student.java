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
}
