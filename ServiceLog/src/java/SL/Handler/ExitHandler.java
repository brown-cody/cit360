
package SL.Handler;

//import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;


public class ExitHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) {
        
        System.out.println("\nQuitting now. Goodbye!");
        
        System.exit(0);
    }

}