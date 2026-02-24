import java.util.regex.Pattern;

/**
 * InputValidator class to validate user inputs.
 * Ensures that required fields are not empty and data is in correct format.
 */
public class InputValidator {
    
    // Email pattern validation
    private static final String EMAIL_PATTERN = 
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
    // Phone number pattern (10 digits)
    private static final String PHONE_PATTERN = "^[0-9]{10}$";
    
    private static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern phonePattern = Pattern.compile(PHONE_PATTERN);
    
    /**
     * Validate that a string is not null or empty.
     * @param input The string to validate
     * @param fieldName The name of the field for error messages
     * @return true if valid, false otherwise
     */
    public static boolean validateNotEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Error: " + fieldName + " cannot be empty!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate roll number format.
     * @param rollNumber The roll number to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateRollNumber(String rollNumber) {
        if (!validateNotEmpty(rollNumber, "Roll Number")) {
            return false;
        }
        if (rollNumber.trim().length() < 3) {
            System.out.println("Error: Roll Number must be at least 3 characters long!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate name format.
     * @param name The name to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateName(String name) {
        if (!validateNotEmpty(name, "Name")) {
            return false;
        }
        if (name.trim().length() < 2) {
            System.out.println("Error: Name must be at least 2 characters long!");
            return false;
        }
        // Check if name contains only letters and spaces
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Error: Name can only contain letters and spaces!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate grade format.
     * @param grade The grade to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateGrade(String grade) {
        if (!validateNotEmpty(grade, "Grade")) {
            return false;
        }
        // Grade should be alphanumeric (e.g., "A", "B+", "10th", "12-A")
        if (!grade.matches("^[a-zA-Z0-9+\\-]+$")) {
            System.out.println("Error: Invalid grade format!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate age.
     * @param age The age to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateAge(int age) {
        if (age < 5 || age > 120) {
            System.out.println("Error: Age must be between 5 and 120!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate email format.
     * @param email The email to validate
     * @return true if valid, false otherwise
     */
    public static boolean validateEmail(String email) {
        if (!validateNotEmpty(email, "Email")) {
            return false;
        }
        if (!emailPattern.matcher(email).matches()) {
            System.out.println("Error: Invalid email format!");
            return false;
        }
        return true;
    }
    
    /**
     * Validate phone number format.
     * @param phoneNumber The phone number to validate
     * @return true if valid, false otherwise
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (!validateNotEmpty(phoneNumber, "Phone Number")) {
            return false;
        }
        // Remove spaces and hyphens for validation
        String cleaned = phoneNumber.replaceAll("[\\s\\-]", "");
        if (!phonePattern.matcher(cleaned).matches()) {
            System.out.println("Error: Phone number must be exactly 10 digits!");
            return false;
        }
        return true;
    }
    
    /**
     * Parse and validate age from string input.
     * @param ageStr The age as a string
     * @return The age as an integer, or -1 if invalid
     */
    public static int parseAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr.trim());
            if (validateAge(age)) {
                return age;
            }
            return -1;
        } catch (NumberFormatException e) {
            System.out.println("Error: Age must be a valid number!");
            return -1;
        }
    }
}

