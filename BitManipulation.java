public class BitManipulation {
    public static void main(String args[]){
        int n = 5;
        int pos = 2;
        int bitMask = 1<<pos;
        int notBitMask = ~(bitMask);

        if((bitMask & n) == 0){
            System.out.println("bit was zero");
        }else{
            System.out.println("bit was one");
        }

        int newNumber = bitMask | n;
        System.out.println(newNumber);

        System.out.println(notBitMask);

        int oper = 1;//update bit to 1 else to 0

        //set opee

        int bitMask2 = 1 << n;

        int pos2 = 3;

        if(oper == 1){
            n = bitMask2 | n;
        }else{
            n = notBitMask & n;
        }

        System.out.println(n);

    }
}
