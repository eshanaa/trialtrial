package cs3913spring2023threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2023Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*new MyThread().start();
        int val=0;
        Random r = new Random();
        for (int i=0; i<700000; i++)
            val = r.nextInt();
        System.out.println("End of Main!");
        */
        //int val;
        for (int i=0; i<100; i++){
            new Thread(new ConfusingThread(i)).start();
            //val = new BoringClass().func();
        }
    }
    
}
class BoringClass{
    public int func(){
        System.out.println("Hello world!");
        return 5;
    }
}
class ConfusingThread implements Runnable{
    int id;
    ConfusingThread(int newid){
        id = newid;
    }
    @Override
    public void run(){
        
        //Thread thisThread = Thread.currentThread();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {}
        System.out.println("Value="+id);
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        for( int i=0; i<100;i++){
            System.out.println("Value="+i);
            try{
                sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}

