
package SL.Handler;

//import java.util.HashMap;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;


public interface Handler {
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException;

}
