
package threads.exe.runnables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExecutorDemo {
    
    public void runExecutorDemo() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Runnable poolDemo0 = new SongCDemo0();
        Runnable poolDemo1 = new SongCDemo1();
        Runnable poolDemo2 = new SongCDemo2();
        Runnable poolDemo3 = new SongCDemo3();
        Runnable poolDemo4 = new SongCDemo4();
        Runnable poolDemo5 = new SongCDemo5();
        
        executor.execute(poolDemo0);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.execute(poolDemo1);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.execute(poolDemo2);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.execute(poolDemo3);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.execute(poolDemo4);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.execute(poolDemo5);
        TimeUnit.MILLISECONDS.sleep(500);
        
        executor.shutdown();
    }
    
}
