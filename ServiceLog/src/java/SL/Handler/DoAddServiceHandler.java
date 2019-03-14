
package SL.Handler;

import SL.Model.DBConnect;
import SL.View.BrowseServiceView;
import SL.View.EditVehiclesView;
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
        DBConnect dbModel = new DBConnect();
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
        
        dbModel.addService(vehicle, date, mileage, vendor, category, notes, price);
        List services = dbModel.getServices();
        view.showIt(response, services);
    }

}
