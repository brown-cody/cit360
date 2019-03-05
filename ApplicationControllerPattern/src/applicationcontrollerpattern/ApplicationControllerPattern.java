
package applicationcontrollerpattern;

import java.util.HashMap;
import java.util.Scanner;


public class ApplicationControllerPattern {

    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {

        /*System.out.println("\nWhich would you like to do?");
        System.out.println("m - Let's do a Mad Lib!");
        System.out.println("h - Read a Haiku");
        System.out.println("q - Quit");*/
        
        userInput("menu");
        }
        
    public static void userInput(String command) {
        ApplicationController controller = new ApplicationController();
        controller.mapCommand("menu", new MenuHandler());
        controller.mapCommand("m", new MadLibHandler());
        controller.mapCommand("h", new HaikuHandler());
        controller.mapCommand("q", new ExitHandler());

        controller.handleRequest(command,null);
        
        Scanner scanner = new Scanner(System.in);        
        command = scanner.nextLine();
        
        //HashMap<String,Object> inputMap = new HashMap<>();
        //inputMap.put(command,inputMap);
        
        controller.handleRequest(command,null);
               
        menu();
    }    
    
        
}

