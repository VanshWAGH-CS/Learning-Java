import java.util.HashSet;

public class All_Unique_subsequences {

    public static void generateSubsequences(String str, int idx, String newString, HashSet<String> set){

        if(idx == str.length()){
            if(set.contains(newString)) return;
            set.add(newString);
            System.out.println(newString);
            return;
        }

        // Include current character
        generateSubsequences(str, idx+1, newString + str.charAt(idx), set);

        // Exclude current character
        generateSubsequences(str, idx+1, newString, set);
    }

    public static void main(String args[]){
        String str = "aaa";
        HashSet<String> set = new HashSet<>();
        generateSubsequences(str, 0, "", set);
    }
}
