
package applicationcontrollerpattern;

import java.util.HashMap;

public class HaikuHandler implements Handler {
    
    @Override
    public void handleIt(HashMap<String, Object> data) {
        
        System.out.println("\nJava can be hard");
        System.out.println("Or it can be quite easy");
        System.out.println("Well, it is something.");
        
    }

}
