public class Mythread extends Thread {
    
    // @Override
    // public void run(){
    //     System.out.println("RUNNING");
    //     try{
    //         Thread.sleep(2000);
    //     }catch(InterruptedException e){
    //         System.out.println(e);;
    //     }
        
    // }
    // public static void main(String[] args) throws InterruptedException{
    //     Mythread t1 = new Mythread();
    //     System.out.println(t1.getState());
    //     t1.start();
    //     System.out.println(t1.getState());
    //     //System.out.println(Thread.currentThread().getState());
    //     Thread.sleep(100);
    //     System.out.println(t1.getState());  //TERMINATED state of the thread
    //     t1.join();
    //     System.out.println(t1.getState());

    // }


    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(3000); // Pause for 3 seconds
                System.out.println("Thread running: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.start(); // Start the thread

        try {
            t1.join(); // Wait for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }
    
}
