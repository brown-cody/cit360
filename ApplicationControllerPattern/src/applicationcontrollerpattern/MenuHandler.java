
package applicationcontrollerpattern;

import java.util.HashMap;
//import java.util.Scanner;


public class MenuHandler implements Handler {
    
    @Override
    public void handleIt(HashMap<String, Object> data) {
        
        System.out.println("\nWhich would you like to do?");
        System.out.println("m - Let's do a Mad Lib!");
        System.out.println("h - Read a Haiku");
        System.out.println("q - Quit");
        
        //Scanner scanner = new Scanner(System.in); 
        //String command = scanner.nextLine();
        
        
    }
    
}
