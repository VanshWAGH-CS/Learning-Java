import java.util.HashSet;
import java.util.Iterator;

public class HashSET {
    
    public static void main(String args[]){
        //creatring 
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);//duplicate

        //search
        if(set.contains(1)){
            System.out.println("set contains 1");;
        }
        if(!set.contains(4)){
            System.out.println("set does not contain 4");;
        }

        //Iterator
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());;
        }
    }
}
