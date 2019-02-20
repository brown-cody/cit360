
package threads.exe.runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThreadsExeRunnables {

    //LineCounter counter = new LineCounter();
    //static int counterInt;
    
    public static void main(String[] args) throws InterruptedException, IOException {
        menu();
    }
    
    public static void menu() throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        System.out.println("\nWhich demo would you like to see?");
        System.out.println("t - Threading Demo");
        System.out.println("n - Non-Threading Demo");
        System.out.println("a - Atomic Variable Demo");
        System.out.println("q - Quit");
        
        String choice = br.readLine();
        
        switch (choice) {
            case "t":
                showThreadsDemo();
                break;
            case "n":
                showNonThreadsDemo();
                break;
            case "a":
                showAtomicVariableDemo();
                break;
            case "q":
                break;
                
        }
        
    }
    
    public static void showThreadsDemo() throws InterruptedException, IOException {
        System.out.println("\nIn this demo, you'll see the lyrics of several Beatles songs, but they'll all be mixed up. ");
        System.out.println("This demonstrates that the threads executing the console output for each song "
                        + "are truly operating simultanously.\n");
        System.out.println("Song A is threaded by implementing the RUNNABLE interface. ");
        System.out.println("Song B is threaded by extending the THREAD class. ");
        System.out.println("Song C uses an EXECUTION POOL of 6 runnable threads, each of which prints one line of the song. ");
        System.out.println("\nSleep has been added to the execution to simulate the time needed to process large amounts of data. ");
        System.out.println("\nPress ENTER to continue...");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = br.readLine();
        
        new Thread(new RunnableDemo()).start();
        new ThreadDemo().start();
        ExecutorDemo eDemo = new ExecutorDemo();
        eDemo.runExecutorDemo();
        
        menu();
    }
    
    public static void showNonThreadsDemo() throws InterruptedException, IOException {
        
        System.out.println("\nIn this demo, there is only one thread executing the console output for all of the songs.");
        System.out.println("Execution doesn't move on to the next song until the first one is finished, etc.");
        System.out.println("\nPress ENTER to continue...");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = br.readLine();
                
        SongDemo.allMyLoving();
        SongDemo.hardDaysNight();
        SongDemo.cantBuyMeLove();
        
        menu();
    }
    
    public static void showAtomicVariableDemo() throws InterruptedException, IOException {
        
        System.out.println("\nIn this demo, an Atomic Variable is incremented to 10,000 by 4 different threads.");
        System.out.println("Although they each reach 2,500 at different times, the final total is always correct.");
        System.out.println("\nPress ENTER to continue...");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choice = br.readLine();
        

        
        AtomicVariableDemo avd = new AtomicVariableDemo();
        
        System.out.println("\nAtomic Variable initial value:" + avd.counter.getValue());
        System.out.println("Incrementing now...");
        avd.runAtomicVariableDemo();

        System.out.println("\nAtomic Variable: " + avd.counter.getValue());

        avd.isAtomic = false;
        
        System.out.println("\nNow, if we use a regular variable instead of an Atomic Variable,");
        System.out.println("The threads have difficulty accessing it simultaneously, so it doesn't get incremented as it should.");
        System.out.println("\nPress ENTER to continue...");
        
        choice = br.readLine();
        
        System.out.println("\nBasic Variable initial value:" + avd.intCounter.getValue());
        System.out.println("Incrementing now...");
        avd.runAtomicVariableDemo();

        System.out.println("\nBasic Variable: " + avd.intCounter.getValue());

        avd.isAtomic = true;
        menu();
    }
    
}
