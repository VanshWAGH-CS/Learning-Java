// ============================================================================
// Demo4.java : Custom Exception Example
// ============================================================================
// In Java, we can define our own exceptions by creating classes that extend
// Exception (for checked exceptions) or RuntimeException (for unchecked).
// ============================================================================

package Exception;

// Step 1: Create a custom checked exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Step 2: Create a custom unchecked exception
class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class Demo4 {
    // Method that throws checked exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above for voting.");
        }
        System.out.println("Valid age: " + age + ". You can vote!");
    }

    // Method that throws unchecked exception
    public static void squareRoot(int num) {
        if (num < 0) {
            throw new NegativeNumberException("Cannot calculate square root of negative number: " + num);
        }
        System.out.println("Square root of " + num + " = " + Math.sqrt(num));
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Exception Demo ===");

        // --------------------------------------------------------------------
        // 1. Checked Exception Example
        // --------------------------------------------------------------------
        try {
            validateAge(15); // will throw InvalidAgeException
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Checked Exception: " + e.getMessage());
        }

        // --------------------------------------------------------------------
        // 2. Unchecked Exception Example
        // --------------------------------------------------------------------
        try {
            squareRoot(-25); // will throw NegativeNumberException
        } catch (NegativeNumberException e) {
            System.out.println("Caught Custom Unchecked Exception: " + e.getMessage());
        }

        // --------------------------------------------------------------------
        // 3. Normal execution with valid inputs
        // --------------------------------------------------------------------
        try {
            validateAge(20);  // valid
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        squareRoot(16);  // valid

        System.out.println("Program continues normally...");
    }
}
