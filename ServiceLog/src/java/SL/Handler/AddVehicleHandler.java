
package SL.Handler;

import SL.Model.URLConnect;
import SL.View.AddVehicleView;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException {
        URLConnect urlModel = new URLConnect();
        String makes = urlModel.getMakes();
        
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(makes);
            //PrintWriter pw = response.getWriter();
            //pw.println(makes);
        } catch (ParseException ex) {
            Logger.getLogger(AddVehicleHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        AddVehicleView addView = new AddVehicleView();
        addView.showIt(response);
    }

}
