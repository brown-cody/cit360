
package SL.Handler;

import SL.Model.*;
import SL.View.BrowseServiceView;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class BrowseServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        ServiceDAO sModel = new ServiceDAO();       
        BrowseServiceView view = new BrowseServiceView();

        List services = sModel.getServices();
        view.showIt(response, services);
    
    }

}
