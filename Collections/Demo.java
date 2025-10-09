package Collections;

// Importing necessary classes from java.util package
import java.util.ArrayList;      // Dynamic array implementation
import java.util.Collection;     // Root interface of Collections Framework
import java.util.List;           // Ordered collection (sequence)
import java.util.Set;            // Collection with no duplicates
import java.util.HashSet;        // Hash table implementation of Set
import java.util.TreeSet;        // Sorted Set implementation using Red-Black tree
import java.util.Iterator;       // Interface for iterating over collections
import java.util.Map;            // Key-value pair storage interface
import java.util.HashMap;        // Hash table implementation of Map
import java.util.Hashtable;      // Synchronized hash table implementation
import java.util.Comparator;     // Interface for custom sorting logic
import java.util.Collections;    // Utility class for collection operations

/**
 * Student class - Demonstrates use of custom objects in Collections
 * This is a simple POJO (Plain Old Java Object)
 */
class Student {
    int age;
    String name;

    // Constructor to initialize Student object
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Override toString() for meaningful output when printing
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

/**
 * Main Demo class demonstrating Java Collections Framework
 */
public class Demo {

    public static void main(String[] args) {
        
        System.out.println("=== 1. COLLECTION INTERFACE - ROOT OF HIERARCHY ===");
        // Collection is the root interface of the Collections Framework
        // It defines basic operations: add, remove, size, clear, etc.
        Collection<Integer> nums = new ArrayList<Integer>();
        
        nums.add(6);  // Adding elements
        nums.add(7);
        nums.add(8);
        nums.add(9);
        
        System.out.println("Collection elements: " + nums);
        
        // Enhanced for-loop (for-each) to iterate
        // No need for casting with Generics
        System.out.print("Elements doubled: ");
        for(Integer n : nums) {
            System.out.print((n * 2) + " ");
        }
        System.out.println("\n");

        
        System.out.println("=== 2. LIST INTERFACE - ORDERED COLLECTION ===");
        // List: Ordered collection, allows duplicates, index-based access
        // ArrayList: Dynamic array, fast random access, slow insertion/deletion
        List<Integer> nums2 = new ArrayList<Integer>();
        
        nums2.add(4);
        nums2.add(5);
        nums2.add(4);  // Duplicates allowed
        nums2.add(1, 10); // Insert at index 1
        
        System.out.println("List elements: " + nums2);
        System.out.println("Element at index 2: " + nums2.get(2));
        System.out.println("Size: " + nums2.size());
        System.out.println();

        
        System.out.println("=== 3. SET INTERFACE - NO DUPLICATES ===");
        // Set: Unordered collection, NO duplicates allowed
        // HashSet: Uses hash table, O(1) operations, no ordering guarantee
        Set<Integer> nums3 = new HashSet<Integer>();
        
        nums3.add(5);
        nums3.add(3);
        nums3.add(8);
        nums3.add(3);  // Duplicate - will NOT be added
        nums3.add(1);
        
        System.out.println("HashSet elements (unordered): " + nums3);
        
        // TreeSet: Sorted Set implementation using Red-Black tree
        // Elements stored in sorted order, O(log n) operations
        Set<Integer> nums4 = new TreeSet<Integer>();
        nums4.add(15);
        nums4.add(3);
        nums4.add(9);
        nums4.add(1);
        
        System.out.println("TreeSet elements (sorted): " + nums4);
        System.out.println();

        
        System.out.println("=== 4. ITERATOR INTERFACE - TRAVERSAL ===");
        // Iterator: Used to traverse collections one element at a time
        // Methods: hasNext(), next(), remove()
        Iterator<Integer> values = nums.iterator();
        
        System.out.print("Iterating with Iterator: ");
        while(values.hasNext()) {
            Integer value = values.next();
            System.out.print(value + " ");
        }
        System.out.println("\n");

        
        System.out.println("=== 5. MAP INTERFACE - KEY-VALUE PAIRS ===");
        // Map: Stores key-value pairs, keys must be unique
        // HashMap: Hash table implementation, O(1) operations, not synchronized
        Map<String, Integer> students = new HashMap<>();
        
        students.put("Navin", 56);
        students.put("Rahul", 78);
        students.put("Priya", 92);
        students.put("Navin", 65);  // Updates existing key
        
        System.out.println("HashMap: " + students);
        System.out.println("Navin's marks: " + students.get("Navin"));
        System.out.println("Contains key 'Rahul': " + students.containsKey("Rahul"));
        
        // Iterating over Map entries
        System.out.println("\nIterating over Map:");
        for(Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Hashtable vs HashMap
        // Hashtable: Synchronized (thread-safe), slower, no null keys/values
        // HashMap: Not synchronized, faster, allows one null key and multiple null values
        Hashtable<String, Integer> syncMap = new Hashtable<>();
        syncMap.put("A", 1);
        // syncMap.put(null, 2);  // Would throw NullPointerException
        System.out.println("\nHashtable (synchronized): " + syncMap);
        System.out.println();

        
        System.out.println("=== 6. COLLECTIONS UTILITY CLASS ===");
        // Collections: Utility class with static methods for operations
        List<Integer> sortList = new ArrayList<>();
        sortList.add(45);
        sortList.add(12);
        sortList.add(78);
        sortList.add(23);
        
        System.out.println("Before sorting: " + sortList);
        
        // Natural ordering sort (ascending)
        Collections.sort(sortList);
        System.out.println("After sorting (natural): " + sortList);
        
        // Reverse order
        Collections.reverse(sortList);
        System.out.println("After reversing: " + sortList);
        System.out.println();

        
        System.out.println("=== 7. COMPARATOR INTERFACE - CUSTOM SORTING ===");
        // Comparator: Functional interface for defining custom comparison logic
        // Used when you need sorting logic different from natural ordering
        
        List<Integer> customSort = new ArrayList<>();
        customSort.add(43);
        customSort.add(31);
        customSort.add(72);
        customSort.add(29);
        
        System.out.println("Before custom sorting: " + customSort);
        
        // Anonymous Inner Class implementation of Comparator
        // Sorts based on last digit
        Comparator<Integer> lastDigitComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                // Return positive if i should come after j
                // Return negative if i should come before j
                // Return 0 if they are equal
                if(i % 10 > j % 10) {
                    return 1;   // i comes after j
                } else {
                    return -1;  // i comes before j
                }
            }
        };
        
        Collections.sort(customSort, lastDigitComparator);
        System.out.println("After sorting by last digit: " + customSort);
        
        // Lambda expression (Java 8+) - more concise way
        Collections.sort(customSort, (i, j) -> Integer.compare(j % 10, i % 10));
        System.out.println("Sorted by last digit (descending): " + customSort);
        System.out.println();

        
        System.out.println("=== 8. WRAPPER CLASSES ===");
        // Wrapper classes: Object representations of primitive types
        // Collections work ONLY with objects, not primitives
        // Auto-boxing: Automatic conversion from primitive to wrapper
        // Auto-unboxing: Automatic conversion from wrapper to primitive
        
        // Primitive types: int, double, char, boolean, etc.
        // Wrapper classes: Integer, Double, Character, Boolean, etc.
        
        int primitive = 10;
        Integer wrapper = primitive;  // Auto-boxing
        int backToPrimitive = wrapper; // Auto-unboxing
        
        System.out.println("Primitive: " + primitive);
        System.out.println("Wrapper: " + wrapper);
        System.out.println("Back to primitive: " + backToPrimitive);
        
        // Why needed: Collections cannot store primitives
        List<Integer> intList = new ArrayList<>();
        intList.add(5);  // Auto-boxing happens: 5 -> Integer.valueOf(5)
        int val = intList.get(0);  // Auto-unboxing: Integer -> int
        
        System.out.println("\nWrapper classes mapping:");
        System.out.println("byte -> Byte");
        System.out.println("short -> Short");
        System.out.println("int -> Integer");
        System.out.println("long -> Long");
        System.out.println("float -> Float");
        System.out.println("double -> Double");
        System.out.println("char -> Character");
        System.out.println("boolean -> Boolean");
        System.out.println();

        
        System.out.println("=== 9. ANONYMOUS INNER CLASS ===");
        // Anonymous class: Class without a name, defined and instantiated at once
        // Used for one-time implementations of interfaces or abstract classes
        
        // Example 1: Implementing Comparator (shown above)
        
        // Example 2: Implementing a custom interface
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class implementing Runnable");
            }
        };
        task.run();
        
        // Modern alternative: Lambda expressions (for functional interfaces)
        Runnable taskLambda = () -> System.out.println("Lambda expression alternative");
        taskLambda.run();
        System.out.println();

        
        System.out.println("=== 10. CUSTOM OBJECTS IN COLLECTIONS ===");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(20, "Alice"));
        studentList.add(new Student(22, "Bob"));
        studentList.add(new Student(19, "Charlie"));
        
        System.out.println("Student list: " + studentList);
        
        // Sorting custom objects requires Comparator
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age, s2.age);
            }
        });
        
        System.out.println("Sorted by age: " + studentList);
        
        // Or using lambda
        Collections.sort(studentList, (s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println("Sorted by name: " + studentList);
        System.out.println();

        
        System.out.println("=== SUMMARY OF KEY CONCEPTS ===");
        System.out.println("1. Collections Framework: Unified architecture for storing/manipulating groups");
        System.out.println("2. List: Ordered, allows duplicates (ArrayList, LinkedList)");
        System.out.println("3. Set: Unordered, no duplicates (HashSet, TreeSet)");
        System.out.println("4. Map: Key-value pairs (HashMap, TreeMap, Hashtable)");
        System.out.println("5. Iterator: For traversing collections");
        System.out.println("6. Comparator: Custom sorting logic");
        System.out.println("7. Wrapper Classes: Object wrappers for primitives");
        System.out.println("8. Anonymous Classes: Unnamed classes for one-time use");
        System.out.println("9. Generics: Type safety at compile time");
        System.out.println("10. Collections utility: Helper methods for operations");
    }
}