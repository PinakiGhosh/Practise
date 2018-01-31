package threads;

/**
 * Created by pinaki on 19/1/18.
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        MySimpleThread mst=new MySimpleThread();
        Thread t= new Thread(mst);

        MySimpleThread mst1=new MySimpleThread();
        Thread t1= new Thread(mst1);

        t1.start();
        t.start();
        t1.join();
    }
}
