
package applicationcontrollerpattern;

import java.util.HashMap;
import java.util.Scanner;


public class ApplicationControllerPattern {

    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {

        System.out.println("\nWhich would you like to do?");
        System.out.println("m - Let's do a Mad Lib!");
        System.out.println("h - Read a Haiku");
        System.out.println("q - Quit");
        
        userInput();
        }
        
    public static void userInput() {
        Scanner scanner = new Scanner(System.in);      
        
        ApplicationController controller = new ApplicationController();
        controller.mapCommand("m",new MadLibHandler());
        controller.mapCommand("h", new HaikuHandler());
        controller.mapCommand("q", new ExitHandler());
          
        String command = scanner.nextLine();
        HashMap<String,Object> inputMap = new HashMap<>();
        inputMap.put(command,inputMap);
        
        //String handlerOutput = (String) inputMap.get(command);
        //System.out.println(handlerOutput);
        controller.handleRequest(command,inputMap);
        
        menu();
    }    
    
        
}

