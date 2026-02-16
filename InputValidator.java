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
}
