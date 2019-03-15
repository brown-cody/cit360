
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class DeleteServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        
        DBConnect dbModel = new DBConnect();
        DeleteServiceView view = new DeleteServiceView();
        
        List service = dbModel.getServiceById(data);
        view.showIt(response, service);
        
    }

}
