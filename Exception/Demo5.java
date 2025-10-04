// ============================================================================
// Demo5.java : Ducking Exceptions using "throws"
// ============================================================================
// - "throw"  -> used to actually throw an exception object.
// - "throws" -> used in method signature to declare that the method
//               might throw certain exceptions (checked).
// 
// Ducking: If a method does not handle a checked exception itself,
//          it can declare it with "throws" and pass the responsibility
//          to the caller.
// ============================================================================

package Exception;

import java.io.*; // for checked exceptions

public class Demo5 {

    // Method that ducks (declares) a checked exception
    static void readFile() throws IOException {
        // This method doesn’t handle the exception, just throws it
        FileReader fr = new FileReader("nonexistent.txt");
        // If file not found, FileNotFoundException (a subclass of IOException) will be thrown
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
    }

    // Method that throws custom checked exception
    static void checkNumber(int num) throws Exception {
        if (num < 0) {
            // "throw" is used to actually throw
            throw new Exception("Number must not be negative.");
        }
        System.out.println("Number is valid: " + num);
    }

    public static void main(String[] args) {
        System.out.println("=== Ducking Exception Demo ===");

        // --------------------------------------------------------------------
        // 1. Ducked IOException must be handled here
        // --------------------------------------------------------------------
        try {
            readFile();  // ducks IOException
        } catch (IOException e) {
            System.out.println("Handled IOException from readFile(): " + e);
        }

        // --------------------------------------------------------------------
        // 2. Ducking custom exception
        // --------------------------------------------------------------------
        try {
            checkNumber(-5); // ducks Exception
        } catch (Exception e) {
            System.out.println("Handled Exception from checkNumber(): " + e.getMessage());
        }

        // Normal execution
        try {
            checkNumber(10); // valid case
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}
