
package applicationcontrollerpattern;

//import java.util.HashMap;

public class MenuHandler implements Handler {
    
    @Override
    //public void handleIt(HashMap<String, Object> data) {
    public void handleIt() {
        
        System.out.println("\nWhich would you like to do?");
        System.out.println("m - Let's do a Mad Lib!");
        System.out.println("h - Read a Haiku");
        System.out.println("q - Quit");
    }
    
}
