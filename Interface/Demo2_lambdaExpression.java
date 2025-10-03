package Interface;

// Functional Interface with one abstract method
@FunctionalInterface
interface A {
    int add(int i, int j);   // single abstract method
}

public class Demo2_lambdaExpression {
    public static void main(String[] args) {

        // 1. Traditional way: Using an anonymous class
        A obj1 = new A() {
            @Override
            public int add(int i, int j) {
                return i + j;
            }
        };
        System.out.println("Anonymous Class Result: " + obj1.add(5, 4));

        // 2. Using Lambda Expression (shorter & cleaner)
        A obj2 = (i, j) -> {
            return i + j;
        };
        System.out.println("Lambda Expression Result: " + obj2.add(10, 20));

        // 3. Even shorter (one-line lambda)
        A obj3 = (i, j) -> i + j;
        System.out.println("One-line Lambda Result: " + obj3.add(100, 200));
    }
}
