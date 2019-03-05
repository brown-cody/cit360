
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
        
        userInput();
    }
        
    public static void userInput() {
        
        //controller.handleRequest(command,null);
        controller.handleRequest("menu");
        
        Scanner scanner = new Scanner(System.in);        
        String command = scanner.nextLine();
        
        //HashMap<String,Object> inputMap = new HashMap<>();
        //inputMap.put(command,inputMap);
        
        //controller.handleRequest(command,null);
        controller.handleRequest(command);
               
        userInput();
    }    
    
        
}

