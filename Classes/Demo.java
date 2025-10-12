// Demo.java
// Demonstrates: abstract classes, concrete classes, final classes, and sealed classes
// Requires Java 17+ for sealed classes.

public class Demo {
    public static void main(String[] args) {
        System.out.println("=== Abstract / Concrete / Final classes demo ===");
        // Abstract class: can't do new Animal() directly.
        Animal dog = new Dog("Buddy");
        dog.makeSound();
        dog.sleep();                 // concrete method defined in abstract class

        // Final class: can instantiate, but cannot subclass (attempting to extend Cat would fail).
        Cat cat = new Cat("Whiskers");
        cat.makeSound();

        // Concrete class: Simple instantiable class
        Car car = new Car("Tesla");
        car.drive();

        System.out.println("\n=== Sealed classes demo (Java 17+) ===");
        // Sealed class Transport controls allowed subclasses.
        Transport bike = new RoadBike("Giant");
        Transport plane = new AirPlane("Boeing");

        // Polymorphic dispatch works as usual:
        bike.move();
        plane.move();

        // The following lines demonstrate (in comments) compile-time failures:
        // 1) Attempting to extend a final class will fail (uncomment to see compiler error)
        // class MyCat extends Cat {} // ERROR: cannot inherit from final 'Cat'

        // 2) Attempting to extend a sealed class by a non-permitted subclass will fail:
        // class UnknownTransport extends Transport {} // ERROR: Transport does not permit UnknownTransport
    }
}

/* ---------------------------
   ABSTRACT CLASS example
   ---------------------------
   Abstract class can have both abstract methods and concrete methods.
   Subclasses must implement abstract methods, or be abstract themselves.
*/
abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    // abstract method - no implementation here; subclasses must implement
    public abstract void makeSound();

    // concrete method - can be used by subclasses as-is
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// Concrete subclass implementing abstract methods
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

/* ---------------------------
   FINAL CLASS example
   ---------------------------
   'final' on a class prevents other classes from extending it.
   Useful when class behavior must not be changed by inheritance.
*/
final class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow!");
    }
}

/* ---------------------------
   CONCRETE CLASS example
   ---------------------------
   Normal class, instantiable, can be extended (unless declared final).
*/
class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void drive() {
        System.out.println("Driving the car: " + model);
    }
}

/* ---------------------------
   SEALED CLASS example (Java 17+)
   ---------------------------
   sealed class restricts which classes may extend it.
   Syntax: sealed class X permits A, B, C { ... }
   Each permitted subclass must be declared as final, sealed, or non-sealed.
*/
sealed abstract class Transport permits RoadBike, AirPlane, Truck {
    protected String model;

    public Transport(String model) {
        this.model = model;
    }

    // abstract - each subtype must define how it moves
    public abstract void move();

    public String getModel() {
        return model;
    }
}

/* A permitted subclass declared 'final' - cannot be further extended */
final class RoadBike extends Transport {
    public RoadBike(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Road bike " + model + " pedals forward on the road.");
    }
}

/* A permitted subclass declared 'non-sealed' - it may be extended further */
non-sealed class AirPlane extends Transport {
    public AirPlane(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Airplane " + model + " flies through the sky.");
    }
}

/* A permitted subclass declared 'final' (can't be extended) */
final class Truck extends Transport {
    public Truck(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Truck " + model + " rolls on highways.");
    }
}

/*
Notes on sealed classes:
- The sealed class lists the permitted subclasses with 'permits'.
- Each permitted subclass must explicitly state its "subclass-modifier":
  - final: cannot be extended further
  - sealed: may further restrict its own permitted subclasses
  - non-sealed: leaves the subclassing open (regular inheritance allowed downstream)
- All permitted subclasses must be in the same module, or same package if no module is used.
*/
