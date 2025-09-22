// File 2: EngineeringStudent.java
// A regular class implementing Student the traditional way.
public class EngineeringStudent implements Student {
@Override
public String getBio(String name) {
return name + " is an Engineering Student";
}
}