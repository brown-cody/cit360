
package SL.Handler;

//import java.util.HashMap;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;


public interface Handler {
    public void handleIt(HttpServletResponse response)  throws ServletException, IOException;
    //public void handleIt(HashMap<String, Object> data);
    //public void handleIt();
}
