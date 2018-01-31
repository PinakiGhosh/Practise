package threads;

import java.time.Instant;

/**
 * Created by pinaki on 19/1/18.
 */
public class MySimpleThread extends Thread {

    private long initTime;

    public MySimpleThread(){
        this.initTime= Instant.now().toEpochMilli();
    }

    public Long getExecutionTime(){
        return Instant.now().toEpochMilli()-this.initTime;
    }

    public void run(){
        System.out.println("Started "+getName());
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping "+getName()+" Ran for "+getExecutionTime());
    }

}
