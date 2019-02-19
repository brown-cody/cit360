
package threads.exe.runnables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ThreadsExeRunnables {

    LineCounter counter = new LineCounter();
    
    public static void main(String[] args) throws InterruptedException, IOException {
        menu();
    }
    
    public static void menu() throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        System.out.println("\nWhich demo would you like to see?");
        System.out.println("t - Threading Demo");
        System.out.println("n - Non-Threading Demo");
        System.out.println("q - Quit");
        
        String choice = br.readLine();
        
        switch (choice) {
            case "t":
                showThreadsDemo();
                break;
            case "n":
                showNonThreadsDemo();
                break;
            case "q":
                break;
                
        }
        
    }
    
    public static void showThreadsDemo() throws InterruptedException, IOException {
        System.out.println("\nIn this demo, you'll see the lyrics of several Beatles songs, but they'll all be mixed up. ");
        System.out.println("This demonstrates that the threads executing the console output for each song "
                        + "are truly operating simultanously.\n");
        System.out.println("Song A is threaded using by implementing the RUNNABLE interface. ");
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
    
    
    
}
