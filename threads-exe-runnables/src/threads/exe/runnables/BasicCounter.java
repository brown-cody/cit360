
package threads.exe.runnables;

public class BasicCounter {
    
    private int intCounter;
    
    public int getValue() {
        return intCounter;
    }
    
    public int increment() {
        intCounter++;
        return intCounter;
    }
}
