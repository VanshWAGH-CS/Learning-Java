public class InsertionSort {
    
    /**
     * Insertion Sort Algorithm
     * Time Complexity: O(n²) worst case, O(n) best case
     * Space Complexity: O(1)
     * 
     * @param arr - array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to be inserted
            int j = i - 1;    // Index of the last element in sorted portion
            
            // Move elements of sorted portion that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at its correct position
            arr[j + 1] = key;
        }
    }
    
    /**
     * Helper method to print array
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = {7, 8, 3, 1, 2};
        System.out.println("Original array:");
        printArray(arr1);
        
        insertionSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);
        
        System.out.println();
        
        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Already sorted array:");
        printArray(arr2);
        
        insertionSort(arr2);
        System.out.println("After insertion sort:");
        printArray(arr2);
        
        System.out.println();
        
        // Test case 3: Reverse sorted array
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Reverse sorted array:");
        printArray(arr3);
        
        insertionSort(arr3);
        System.out.println("After insertion sort:");
        printArray(arr3);
        
        System.out.println();
        
        // Test case 4: Single element
        int[] arr4 = {42};
        System.out.println("Single element array:");
        printArray(arr4);
        
        insertionSort(arr4);
        System.out.println("After insertion sort:");
        printArray(arr4);
    }
}
