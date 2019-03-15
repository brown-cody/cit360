
package SL.Handler;

import SL.Model.*;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class DoDeleteServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {

        ServiceDAO sModel = new ServiceDAO();
        VehicleDAO vModel = new VehicleDAO();
        BrowseServiceView view = new BrowseServiceView();
        
        sModel.deleteService(data);
        
        List services = sModel.getServices();
        List vehicles = vModel.getVehicles();
        view.showIt(response, services, vehicles);
        
    }

}
