public class Remove_duplicates {

    public static boolean[] map  = new boolean[26];

    public static void removeDuplicates(String str, int idx, String newString){

        // Base case
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a']){
            // duplicate found → skip
            removeDuplicates(str, idx+1, newString);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newString + currChar);
        }
    }

    public static void main(String args[]){
        String str = "aabbccddeeff";
        removeDuplicates(str, 0, "");
    }
}
