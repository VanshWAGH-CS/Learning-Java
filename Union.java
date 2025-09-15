import java.util.HashSet;

public class Union {
    
    public static int union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i = 0; i < arr2.length; i++){
            set.add(arr2[i]);
        }

        return set.size();

        
    }

    public static int intersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int j = 0; j < arr2.length; j++){
            if(set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }

        return count;//insersection
    }

    public static void main(String args[]){
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 4, 3, 3, 5, 7};

        System.out.println(union(arr1, arr2));

        System.out.println(intersection(arr1, arr2));

    }
}
