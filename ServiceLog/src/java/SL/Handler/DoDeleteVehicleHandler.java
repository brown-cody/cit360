
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class DoDeleteVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {

        VehicleDAO vModel = new VehicleDAO();
        EditVehiclesView view = new EditVehiclesView();
        
        vModel.deleteVehicle(data);
        
        List vehicles = vModel.getVehicles();
        view.showIt(response, vehicles);
        
    }

}
