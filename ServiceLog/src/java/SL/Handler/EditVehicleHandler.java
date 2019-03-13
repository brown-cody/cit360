
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.EditVehicleView;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EditVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
        
        DBConnect dbModel = new DBConnect();
        EditVehicleView view = new EditVehicleView();
        
        List vehicles = dbModel.getVehicles();
        view.showIt(response, vehicles);
        
    }

}
