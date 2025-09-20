public class Move_all_x {

    public static void moveAllx(String str, int idx, int count, String newString){

        // Base case
        if(idx == str.length()){
            // Append all x's at the end
            for(int i = 0; i < count; i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar == 'x'){
            // Increase count but don't add to newString yet
            count++;
            moveAllx(str, idx+1, count, newString);
        } else {
            // Add current non-x character
            moveAllx(str, idx+1, count, newString + currChar);
        }
    }

    public static void main(String args[]){
        String str = "axbcxxd";
        moveAllx(str, 0, 0, "");
    }
}
