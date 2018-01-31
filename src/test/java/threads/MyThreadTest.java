package threads;

import java.util.ArrayList;

/**
 * Created by pinaki on 19/1/18.
 */
public class MyThreadTest {

    public void temp() throws InterruptedException {
        MyThread mrt;
        Thread t;
        ArrayList<Thread> threadArrayList=new ArrayList<Thread>();
        Object monitor= new Object();
        mrt=new MyThread();
        for (int i=0;i<5;i++){
            //String uuid = UUID.randomUUID().toString();
            mrt.setMonitor(monitor);
            threadArrayList.add(new Thread(mrt));
        }
        for (Thread thread : threadArrayList){
            thread.start();
        }
        System.out.println("Finished init of threads");
        Thread.sleep(10*1000);
        synchronized (monitor){
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MyRunnableThreadTest().temp();
    }
}
