package Exception;

// ============================================================================
// TOPIC 2: EXCEPTION HANDLING USING TRY-CATCH
// ============================================================================
// Try-catch is used to handle exceptions gracefully
// Syntax: try { risky code } catch (ExceptionType e) { handle exception }

class Topic2_TryCatchBasics {
    public static void main(String[] args) {
        // Basic try-catch structure
        System.out.println("Program starts");
        
        try {
            // Code that might throw an exception
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing element: " + numbers[10]);
            
            // This line won't execute if exception occurs above
            System.out.println("This won't print");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Exception handling code
            System.out.println("Caught Exception: " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Stack trace:");
            e.printStackTrace();
        }
        
        // Program continues normally after exception is handled
        System.out.println("Program continues and ends normally");
    }
}

