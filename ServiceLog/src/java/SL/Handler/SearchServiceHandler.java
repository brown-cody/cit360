
package SL.Handler;

import javax.servlet.http.HttpServletResponse;

public class SearchServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) {

        System.out.println("SearchServiceHandler RUN!!!");
        
    }

}
