
package SL.Handler;

import SL.View.AddServiceView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AddServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
                
        AddServiceView addView = new AddServiceView();
        addView.showIt(response);
    }

}
