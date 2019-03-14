
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class DoDeleteVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {

        DBConnect dbModel = new DBConnect();
        EditVehiclesView view = new EditVehiclesView();
        
        dbModel.deleteVehicle(data);
        
        List vehicles = dbModel.getVehicles();
        view.showIt(response, vehicles);
        
    }

}
