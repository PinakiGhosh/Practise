package threads;

import java.util.ArrayList;

/**
 * Created by pinaki on 18/1/18.
 */
public class MyRunnableThreadTest {

    public void temp() throws InterruptedException {
        MyRunnableThread mrt;
        Thread t;
        ArrayList<Thread> threadArrayList=new ArrayList<Thread>();
        Object monitor= new Object();
        mrt=new MyRunnableThread("Thread");
        for (int i=0;i<5;i++){
            //String uuid = UUID.randomUUID().toString();
            mrt.setMonitor(monitor);
            mrt.setName("Thread"+i);
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
