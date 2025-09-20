public class test {
    
    public static void main(String args[]){

        Worls world = new Worls();//NEW state of the thread


        world.start();//RUNNABLE state of the thread
        
        for(; ; ){//infinite loop
            System.out.println("hello");
        }
    }
    
}
