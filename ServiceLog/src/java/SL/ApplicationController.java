
package SL;

import SL.Handler.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

public class ApplicationController {
    private HashMap<String,Handler> handlerMap = new HashMap();

    public void handleRequest(String command, HttpServletResponse response, String data) throws IOException, ServletException{
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            try {
                aCommandHandler.handleIt(response, data);
            } catch (ParseException ex) {
                Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void mapCommand(String command, Handler handler){
        handlerMap.put(command,handler);
    }
}
