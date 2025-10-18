public class BubbleSort {
    
    /**
     * Bubble Sort Algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param arr - array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization: check if any swap occurred
            
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                // If current element is greater than next element, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred in this pass, array is already sorted
            if (!swapped) {
                break;
            }
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
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr1);
        
        bubbleSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);
        
        System.out.println();
        
        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Already sorted array:");
        printArray(arr2);
        
        bubbleSort(arr2);
        System.out.println("After bubble sort:");
        printArray(arr2);
        
        System.out.println();
        
        // Test case 3: Reverse sorted array
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Reverse sorted array:");
        printArray(arr3);
        
        bubbleSort(arr3);
        System.out.println("After bubble sort:");
        printArray(arr3);
    }
}
