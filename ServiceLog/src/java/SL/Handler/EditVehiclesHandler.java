
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.EditVehiclesView;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EditVehiclesHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
        
        VehicleDAO dbModel = new VehicleDAO();
        EditVehiclesView view = new EditVehiclesView();
        
        List vehicles = dbModel.getVehicles();
        view.showIt(response, vehicles);
        
    }

}
