
package SL.Handler;

import SL.Model.*;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class EditServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException {
        
        ServiceDAO sModel = new ServiceDAO();
        VehicleDAO vModel = new VehicleDAO();
        CategoryDAO cModel = new CategoryDAO();
        EditServiceView view = new EditServiceView();
        
        List service = sModel.getServiceById(id);
        List vehicles = vModel.getVehicles();
        List categories = cModel.getCategories();
        view.showIt(response, service, vehicles, categories);
        
    }

}
