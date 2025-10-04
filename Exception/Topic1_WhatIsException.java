// ============================================================================
// TOPIC 1: WHAT IS AN EXCEPTION?
// ============================================================================
// An exception is an unexpected event that occurs during program execution
// which disrupts the normal flow of the program.
// Types: Checked (compile-time) and Unchecked (runtime)
package Exception;


class Topic1_WhatIsException {
    public static void main(String[] args) {
        // Example 1: ArithmeticException (Unchecked)
        // This will crash the program without exception handling
        try {
            int result = 10 / 0; // Division by zero
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        
        // Example 2: NullPointerException (Unchecked)
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception: " + e.getMessage());
        }
        
        // Example 3: ArrayIndexOutOfBoundsException (Unchecked)
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]); // Index doesn't exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        }
    }
}
