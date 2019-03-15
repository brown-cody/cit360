
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EditVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException {
        
        VehicleDAO dbModel = new VehicleDAO();
        EditVehicleView view = new EditVehicleView();
        
        List vehicle = dbModel.getVehicleById(id);
        view.showIt(response, vehicle);
        
    }

}
