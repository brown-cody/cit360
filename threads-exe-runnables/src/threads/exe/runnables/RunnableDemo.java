
package threads.exe.runnables;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        
        try {
            System.out.println("SONG A: Close your eyes and I'll kiss you");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG A: Tomorrow I'll miss you");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG A: Remember I'll always be true");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG A: And then while I'm away");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG A: I'll write home every day");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG A: And I'll send all my loving to you");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
