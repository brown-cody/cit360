
package SL.Handler;

//import java.util.HashMap;

import SL.Handler.Handler;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;


public class ExitHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response) {
    //public void handleIt(HashMap<String, Object> data) {
    //public void handleIt() {
        
        System.out.println("\nQuitting now. Goodbye!");
        
        System.exit(0);
    }

}