package lecture_code;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Thread Methods:
Start - call start and it calls run
Priority: 1-10 (highest), same priority uses FIFO
Sleep - causes the thread to move to blocked. Stores for a certain amount of time
Yield - causes the thread to move from the running state to the ready state
currentThread() - returns a reference to the currently running thread
sema = static. MyThread class is instantiated 5 times. 5 different semaphores == bad 
synchronized(sema) // Equivalent to wait and notify 
need to synchronize on a common object
Synchronizing on the instance, no other synchronized functions in the instance are running at the same time
Synchronizing on the class, no other synchronized functions in the class are running at the same time
Introduction to Java, Data types, loops, branches, array, OOP and exceptions, 
Windowing(JFrame, JButton, JLabel, layouts), extended classes, 
Nested classes, inheritance, member classes, static classes, anonymous classes, inner classes, THREADS
*/

public class threads {
    public static void main(String[] args) {
        //new MyThread().start();
       /* int val=0;
        Random r = new Random();
        int count = 0;
        for (int i=0; i<700000; i++)
            val = r.nextInt();
        	count++;
        	System.out.println(val);
        System.out.println("End of Main!"+ count);
        */
        //int val;
       // for (int i=0; i<100; i++){
          //  new Thread(new ConfusingThread(i)).start();
            //val = new BoringClass().func();
      //  }
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

