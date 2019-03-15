
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.AddServiceView;
import SL.View.EditVehiclesView;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AddServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
                
        AddServiceView addView = new AddServiceView();
        DBConnect dbModel = new DBConnect();
        
        List vehicles = dbModel.getVehicles();
        addView.showIt(response, vehicles);
    }

}
