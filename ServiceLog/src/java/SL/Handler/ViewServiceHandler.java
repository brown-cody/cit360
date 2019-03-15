
package SL.Handler;

import SL.Model.*;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ViewServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException {
        
        ServiceDAO sModel = new ServiceDAO();
        VehicleDAO vModel = new VehicleDAO();
        ViewServiceView view = new ViewServiceView();
        
        List vehicles = vModel.getVehicles();
        List service = sModel.getServiceById(id);
        view.showIt(response, service, vehicles);
        
    }

}
