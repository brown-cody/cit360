
package applicationcontrollerpattern;

//import java.util.HashMap;
import java.util.Scanner;


public class ApplicationControllerPattern {

    static ApplicationController controller = new ApplicationController();
    
    public static void main(String[] args) {
        controller.mapCommand("menu", new MenuHandler());
        controller.mapCommand("m", new MadLibHandler());
        controller.mapCommand("h", new HaikuHandler());
        controller.mapCommand("q", new ExitHandler());
        
        userInput("menu");
    }
        
    public static void userInput(String command) {
        
        controller.handleRequest(command,null);
        
        Scanner scanner = new Scanner(System.in);        
        command = scanner.nextLine();
        
        //HashMap<String,Object> inputMap = new HashMap<>();
        //inputMap.put(command,inputMap);
        
        controller.handleRequest(command,null);
               
        userInput("menu");
    }    
    
        
}

