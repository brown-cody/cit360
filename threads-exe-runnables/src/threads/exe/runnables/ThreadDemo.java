
package threads.exe.runnables;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadDemo extends Thread {
    
    @Override
    public void run() {
        
        
        try {
            System.out.println("SONG B: It's been a hard day's night, and I've been working like a dog");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG B: It's been a hard day's night, I should be sleeping like a log");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG B: But when I get home to you I find the things that you do");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG B: Will make me feel alright.");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG B: You know I feel alright.");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("SONG B: You know I feel alright.");
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
