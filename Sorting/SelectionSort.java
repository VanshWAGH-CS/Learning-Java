public class SelectionSort {
    
    /**
     * Selection Sort Algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param arr - array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // Inner loop to find minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
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
        int[] arr1 = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr1);
        
        selectionSort(arr1);
        System.out.println("Sorted array:");
        printArray(arr1);
        
        System.out.println();
        
        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Already sorted array:");
        printArray(arr2);
        
        selectionSort(arr2);
        System.out.println("After selection sort:");
        printArray(arr2);
        
        System.out.println();
        
        // Test case 3: Reverse sorted array
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Reverse sorted array:");
        printArray(arr3);
        
        selectionSort(arr3);
        System.out.println("After selection sort:");
        printArray(arr3);
    }
}
