
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class DeleteVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        
        VehicleDAO vModel = new VehicleDAO();
        DeleteVehicleView view = new DeleteVehicleView();
        
        List vehicle = vModel.getVehicleById(data);
        view.showIt(response, vehicle);
        
    }

}
