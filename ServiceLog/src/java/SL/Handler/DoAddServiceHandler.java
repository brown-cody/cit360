
package SL.Handler;

import SL.Model.*;
import SL.View.BrowseServiceView;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DoAddServiceHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data) throws IOException {
        ServiceDAO sModel = new ServiceDAO();
        BrowseServiceView view = new BrowseServiceView();
        JSONParser parser = new JSONParser();
        
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(DoAddServiceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String vehicle = (String) json.get("vehicle");
        String date = (String) json.get("date");
        String mileage = (String) json.get("mileage");
        String vendor = (String) json.get("vendor");
        String category = (String) json.get("category");
        String notes = (String) json.get("notes");
        String price = (String) json.get("price");
        
        sModel.addService(vehicle, date, mileage, vendor, category, notes, price);
        List services = sModel.getServices();
        view.showIt(response, services);
    }

}
