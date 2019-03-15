
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class DoDeleteServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {

        DBConnect dbModel = new DBConnect();
        BrowseServiceView view = new BrowseServiceView();
        
        dbModel.deleteService(data);
        
        List services = dbModel.getServices();
        view.showIt(response, services);
        
    }

}
