public class StringBuilders {
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder("Tony");

        System.out.println(sb);
        
        //char at index 0
        System.out.println(sb.charAt(0));

        //set
        sb.setCharAt(0, 'P');
        System.out.println(sb);

        sb.insert(0, 's');
        System.out.println(sb);

        //delete the extra
        sb.delete(0,1);
        System.out.println(sb);

        sb.append("i");
        System.out.println(sb);

    }
}
