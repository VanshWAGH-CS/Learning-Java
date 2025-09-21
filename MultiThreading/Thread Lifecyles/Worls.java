public class Worls extends Thread {
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println("Thread is running: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
    }
}
