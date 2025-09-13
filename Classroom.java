import java.util.HashMap;

public class Classroom {
    
    public static void majorityElement(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);  // increment count
            } else {
                map.put(nums[i], 1);
            }
        }

        for(int key : map.keySet()){
            if(map.get(key) > n/3){
                System.out.println(key);
            }
        }
    }
    
    public static void main(String args[]){
        int nums[] = {1, 2, 3, 5, 3, 1, 2, 1};
        majorityElement(nums);  // call the method

        int arr[] = {12, 15, 18};
        for(int i = 0; i < 3; i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();

        for(int val : arr){
            System.out.println(val+ " ");
        }
        System.out.println();
    }
}
