
package applicationcontrollerpattern;

import java.util.HashMap;

public class ExitHandler implements Handler {
    
    @Override
    //public void handleIt(String name, String verb, String food, String number, String tod) {
    public void handleIt(HashMap<String, Object> data) {
        
        System.out.println("\nQuitting now. Goodbye!");
        
        System.exit(0);
    }

}