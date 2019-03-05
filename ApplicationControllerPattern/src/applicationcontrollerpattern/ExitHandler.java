
package applicationcontrollerpattern;

//import java.util.HashMap;

public class ExitHandler implements Handler {
    
    @Override
    //public void handleIt(HashMap<String, Object> data) {
    public void handleIt() {
        
        System.out.println("\nQuitting now. Goodbye!");
        
        System.exit(0);
    }

}