package main.java.threads;

/**
 * Created by pinaki on 18/1/18.
 */
public class MyRunnableThread implements Runnable {
    private static int counter=0;
    private String name;
    private Object monitor;

    public MyRunnableThread(String name){
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return Thread.currentThread().getName() ;
    }

    public void run() {
        System.out.println("Thread "+getName()+" starting");
        try {
            synchronized (this.monitor) {
                this.monitor.wait();
                System.out.println("Thread "+getName()+" started");
            }
            System.out.println("Counter value is for " + getName() + " is " + getCounter());
            incrementCounter();
//            while (getCounter() < 20) {
//
//                //Thread.sleep(1 * 1000l);
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished execution " + getName());
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MyRunnableThread.counter = counter;
    }

    public static void incrementCounter(){
        MyRunnableThread.counter+=1;
    }

    public Object getMonitor() {
        return monitor;
    }

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }
}
