import java.util.ArrayList;
import java.util.Collections;



public class Arraylist {
    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(5);
        list.add(6);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        //add el in between
        list.add(1, 15);

        //set element
        list.set(0, 5);

        System.out.println(list.get(0));

        //sorting
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
