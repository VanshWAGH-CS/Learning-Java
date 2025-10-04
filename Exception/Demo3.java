// ============================================================================
// Demo3.java : Exception Hierarchy
// ============================================================================

// In Java, all errors and exceptions come from the base class "Throwable".
// Throwable
// ├── Error        (serious problems, not handled usually)
// └── Exception
//     ├── Checked Exceptions (compile-time)
//     └── Unchecked Exceptions (RuntimeExceptions)

// Example code to illustrate

package Exception;

import java.io.*; // For checked exceptions

public class Demo3 {
    public static void main(String[] args) {
        System.out.println("=== Exception Hierarchy Demo ===");

        // --------------------------------------------------------------------
        // 1. Error (serious problem, usually not handled)
        // --------------------------------------------------------------------
        try {
            // Force OutOfMemoryError (Error subclass) - NOT recommended in real apps
            // Uncomment with caution:
            // int[] hugeArray = new int[Integer.MAX_VALUE];
        } catch (Error e) {
            System.out.println("Caught an Error: " + e);
        }

        // --------------------------------------------------------------------
        // 2. Checked Exception (compile-time checked)
        // --------------------------------------------------------------------
        try {
            FileReader fr = new FileReader("nonexistent.txt"); 
            // Compiler forces us to handle FileNotFoundException (Checked Exception)
        } catch (FileNotFoundException e) {
            System.out.println("Caught Checked Exception: " + e);
        }

        // --------------------------------------------------------------------
        // 3. Unchecked Exception (RuntimeException subclass)
        // --------------------------------------------------------------------
        try {
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught Unchecked Exception: " + e);
        }

        // --------------------------------------------------------------------
        // 4. NullPointerException (also unchecked)
        // --------------------------------------------------------------------
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e);
        }

        System.out.println("Program continues normally...");
    }
}
