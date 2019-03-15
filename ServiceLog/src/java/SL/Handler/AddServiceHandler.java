
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.AddServiceView;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AddServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
                
        AddServiceView addView = new AddServiceView();
        VehicleDAO vModel = new VehicleDAO();
        
        List vehicles = vModel.getVehicles();
        addView.showIt(response, vehicles);
    }

}
