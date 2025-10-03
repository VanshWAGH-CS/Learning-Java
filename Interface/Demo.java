package Interface;

// A functional interface is an interface that has only ONE abstract method.
// The @FunctionalInterface annotation enforces this rule.
@FunctionalInterface
interface A {
    void show(); // single abstract method
}

// Class B implements interface A and provides the definition of 'show'
class B implements A {
    @Override
    public void show() {
        System.out.println("inside B");
    }
}

// Main class to run the program
public class Demo {
    public static void main(String[] args) {
        // Creating an object of B
        A obj = new B();

        // Calling the 'show' method
        obj.show(); // Output: inside B
    }
}
