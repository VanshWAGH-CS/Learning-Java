import java.util.Scanner;

public class Strings {
    public static void main(String args[]){
        //String declaration

        // String name = "Tony";
        // String fullName = "Tony Stark";

        // String sentence = "My name is Tony Stark.";

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();

        // System.out.println("Your name is : " + name);


        //concatination
        String firstName = "tony";
        String lastName = "stark";
        String fullName = firstName + " " + lastName;

        System.out.println(fullName.length());

        //charAt
        for(int i = 0; i < fullName.length(); i++){
            System.out.println(fullName.charAt(i));
        }

        System.out.println();

        //compare
        String name1 = "tony";
        String name2 = "Tony";
        //case 1 : s1 > s2
        //case 2 : s1 == s2
        //case 3 : s1 < s2

        if(name1.compareTo(name2) == 0){
            System.out.println("Strings are equal");
        }else{
            System.out.println("Strings are not equal");
        }


        //strigs are immutable

        
    }
}
