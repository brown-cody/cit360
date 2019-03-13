
package SL.Handler;

import SL.View.AddVehicleView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AddVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {

        AddVehicleView addView = new AddVehicleView();
        
        addView.showIt(response);
    }

}
