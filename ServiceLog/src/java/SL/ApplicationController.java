
package SL;

import SL.Handler.Handler;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ApplicationController {
    private HashMap<String,Handler> handlerMap = new HashMap();

    public void handleRequest(String command, HttpServletResponse response, String data) throws IOException, ServletException{
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt(response, data);
        }
    }

    public void mapCommand(String command, Handler handler){
        handlerMap.put(command,handler);
    }
}
