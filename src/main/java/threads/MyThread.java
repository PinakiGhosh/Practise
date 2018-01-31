package threads;

/**
 * Created by pinaki on 19/1/18.
 */
public class MyThread extends Thread{

    private static int counter=0;
    private Object monitor;

    public void incrementCounter(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    public void setMonitor(Object monitor){
        this.monitor=monitor;
    }

    public void run(){
        System.out.println("Thread "+getName()+" starting");
        try {
            synchronized (this.monitor) {
                this.monitor.wait();
                System.out.println("Thread "+getName()+" started");
            }
            System.out.println("Counter value is for " + getName() + " is " + getCounter());
            incrementCounter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished execution " + getName());
    }
}
