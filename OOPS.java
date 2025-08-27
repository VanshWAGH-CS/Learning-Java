class Pen {

    String color;
    String type;

    public void write(){
        System.out.println("writing something");
    }

    public void printColor(){
        System.out.println(this.color);
    }
}

class Student {
    String name;
    int age;

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }


    //function overloading -> compile time polymorphism
    public void printInfo(int age){//polymorphism
        System.out.println(age);
    }

    public void printInfo(String name){//polimorphism
        System.out.println(name);
    }

    Student(Student s2){//copy constructor
        this.name = s2.name;
        this.age = s2.age;
    }

    Student(){}
}

public class OOPS {
    public static void main(String args[]){
        // Pen pen1 = new Pen();

        // pen1.color = "blue";
        // pen1.type = "gel";
        // pen1.write();

        // pen1.printColor();

        Student s1 = new Student();

        s1.name = "vansh";
        s1.age = 20;

        s1.printInfo();
    }
}
