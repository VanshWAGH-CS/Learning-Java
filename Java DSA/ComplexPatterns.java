public class ComplexPatterns {
    public static void main(String[] args) {
        //butterfly pattern
        int n = 5;

        //first half - upper half

            for(int i = 1; i <= n; i++){
                //1st part
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }

                //spaces
                int spaces = 2*(n-i);

                for(int j = 1; j <= spaces; j++){
                    System.out.print(" ");
                }

                //2nd part
                for(int j = 1; j <= i; j++){
                    System.out.print("*");
                }

                System.out.println();
            }

        //lower half
        
        for(int i = n; i >= 1; i--){
            //1st part
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            //spaces
            int spaces = 2*(n-i);

            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }

            //2nd part
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        System.out.println();

        //tilted square  aka rohombus
        for(int i = 1; i <= n; i++){
            //spaces
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }   

            //starts
            for(int j = 1; j <= n; j++){
                System.out.print("*");

            }

            System.out.println();
        }

        System.out.println();
        // pyramid of numbers 
        for(int i = 1; i <= n; i++){
            //spaces 
            for(int j = 1; j <n-i; j++){
                System.out.print(" ");
            }

            ///number-> print row no.
            for(int j = 1; j <= i; j++){
                System.out.print(i + " ");
            }

            System.out.println();
        }

        //number palindrome pramid
        for(int i = 1; i <= n; i++){
            //spaces
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }

            //1st half number
            for(int j = i; j >= 1; j--){
                System.out.print(j);
            }

            //2nd half number
            for(int j = 2; j <= i; j++){
                System.out.print(j);
            }

            System.out.println();
        }


        System.out.println();

        
        //diamond from stars

        n = 4;

        for(int i = 1; i <= n; i++){
            //spaces
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= 2*i - 1; j++){
                System.out.print("*");
            }

            System.out.println();
        }

        //lower half
        for(int i = n; i >= 1; i--){
            //spaces
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }

            for(int j = 1; j <= 2*i - 1; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
