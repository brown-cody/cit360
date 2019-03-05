
package applicationcontrollerpattern;

import java.util.HashMap;

public class ApplicationController {
    private HashMap<String,Handler> handlerMap = new HashMap();

    /*public void handleRequest(String command, HashMap<String,Object> data){
        Handler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt(data);
        }
    }*/
    
    public void handleRequest(String command){
        Handler commandHandler = handlerMap.get(command);
        if (commandHandler != null){
            commandHandler.handleIt();
        }
    }

    public void mapCommand(String command, Handler handler){
        handlerMap.put(command,handler);
    }
}
