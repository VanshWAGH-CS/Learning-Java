public class Keypad_combo {

    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void printComb(String str, int idx, String newString){

        // Base case
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }

        // Recursive case
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for(int i = 0; i < mapping.length(); i++){
            printComb(str, idx + 1, newString + mapping.charAt(i));
        }
    }
    public static void main(String args[]){
        String str = "23456";
        printComb(str, 0, "");
    }
}
