
package SL.Handler;

import SL.Model.*;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class DeleteServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        
        ServiceDAO sModel = new ServiceDAO();
        VehicleDAO vModel = new VehicleDAO();
        DeleteServiceView view = new DeleteServiceView();
        
        List service = sModel.getServiceById(data);
        List vehicles = vModel.getVehicles();
        view.showIt(response, service, vehicles);
        
    }

}
