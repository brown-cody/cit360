
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EditServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException {
        
        DBConnect dbModel = new DBConnect();
        EditServiceView view = new EditServiceView();
        
        List service = dbModel.getServiceById(id);
        List vehicles = dbModel.getVehicles();
        view.showIt(response, service, vehicles);
        
    }

}
