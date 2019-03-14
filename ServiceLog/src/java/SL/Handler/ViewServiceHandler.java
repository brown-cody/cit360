
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class ViewServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException {
        
        DBConnect dbModel = new DBConnect();
        ViewServiceView view = new ViewServiceView();
        
        List service = dbModel.getServiceById(id);
        view.showIt(response, service);
        
    }

}
