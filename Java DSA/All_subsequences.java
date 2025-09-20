public class All_subsequences {

    public static void generateSubsequences(String str, int idx, String newString){

        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        generateSubsequences(str, idx+1, newString + str.charAt(idx));

        generateSubsequences(str, idx+1, newString);
    }
    public static void main(String args[]){
        String str = "abc";
        generateSubsequences(str, 0, "");

    }
}
