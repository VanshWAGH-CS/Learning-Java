// removed import bank.*;

class Shape {
    public void area() {
        System.out.println("display area");
    }
}

class Triangle extends Shape {
    public void area(int l, int h) {
        System.out.println(0.5 * l * h); // fixed 1/2 issue
    }
}

class EquilateralTriangle extends Triangle {
    public void area(int l, int h) {
        System.out.println("area of equilateral triangle");
        super.area(l, h);
    }
}

class Circle extends Shape {
    public void area(int r) {
        System.out.println(3.14 * r * r);
    }
}

public class OOps2 {
    public static void main(String args[]) {
        Account account1 = new Account();
        account1.name = "hey there";
        account1.setEmail("johndoe@gmail.com");
        account1.setPassword("abcd1234");

        System.out.println("Account name: " + account1.name);
        System.out.println("Account email: " + account1.getEmail());
        System.out.println("Account password: " + account1.getPassword());

        // Test Shape classes
        Shape s = new Shape();
        s.area();

        Triangle t = new Triangle();
        t.area(5, 10);

        EquilateralTriangle et = new EquilateralTriangle();
        et.area(6, 6);

        Circle c = new Circle();
        c.area(7);
    }
}
