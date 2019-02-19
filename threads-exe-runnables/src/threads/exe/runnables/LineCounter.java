
package threads.exe.runnables;

import java.util.concurrent.atomic.AtomicInteger;

public class LineCounter {
    
    private AtomicInteger counter = new AtomicInteger(0);
    
    public int getValue() {
        return counter.get();
    }
    
    public int increment() {
        return counter.getAndIncrement();
    }
}
