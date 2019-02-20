
package threads.exe.runnables;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicVariableDemo {

    Boolean isAtomic = true;
    AtomicCounter counter = new AtomicCounter();
    BasicCounter intCounter = new BasicCounter();
    
    public void runAtomicVariableDemo() throws InterruptedException, IOException {

       
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        Runnable t0 = () -> {
            for(int i = 0; i < 2500; i++) {
                if (isAtomic == true) {
                    counter.increment();
                } else {
                    intCounter.increment();
                }
                //System.out.println(Thread.currentThread().getName() + " Iteration: " + i);
            }
            //System.out.println(Thread.currentThread().getName() + " complete. Atomic Variable at: " + counter.getValue());
        };
        
        Runnable t1 = () -> {
            for(int i = 0; i < 2500; i++) {
                if (isAtomic == true) {
                    counter.increment();
                } else {
                    intCounter.increment();
                }
                //System.out.println(Thread.currentThread().getName() + " Iteration: " + i);
            }
            //System.out.println(Thread.currentThread().getName() + " complete. Atomic Variable at: " + counter.getValue());
        };
        
        Runnable t2 = () -> {
            for(int i = 0; i < 2500; i++) {
                if (isAtomic == true) {
                    counter.increment();
                } else {
                    intCounter.increment();
                }
                //System.out.println(Thread.currentThread().getName() + " Iteration: " + i);
            }
            //System.out.println(Thread.currentThread().getName() + " complete. Atomic Variable at: " + counter.getValue());
        };
        
        Runnable t3 = () -> {
            for(int i = 0; i < 2500; i++) {
                if (isAtomic == true) {
                    counter.increment();
                } else {
                    intCounter.increment();
                }
                //System.out.println(Thread.currentThread().getName() + " Iteration: " + i);
            }
            //System.out.println(Thread.currentThread().getName() + " complete. Atomic Variable at: " + counter.getValue());
            
        };

        /*
        new Thread(t0).start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        */
        
        executor.execute(t0);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        
        executor.shutdown();
        
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
        
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }



    }
    
}
