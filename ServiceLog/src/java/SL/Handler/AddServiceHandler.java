
package SL.Handler;

import SL.Model.CategoryDAO;
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
        CategoryDAO cModel = new CategoryDAO();
        
        List vehicles = vModel.getVehicles();
        List categories = cModel.getCategories();
        
        addView.showIt(response, vehicles, categories);
    }

}
