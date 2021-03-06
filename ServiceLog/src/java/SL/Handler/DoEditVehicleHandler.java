
package SL.Handler;

import SL.Model.VehicleDAO;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DoEditVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException, ParseException {

        VehicleDAO vModel = new VehicleDAO();
        EditVehiclesView view = new EditVehiclesView();
        JSONParser parser = new JSONParser();
        
        JSONObject json = new JSONObject();
        json = (JSONObject) parser.parse(data);
        
        String id = (String) json.get("id");
        String year = (String) json.get("year");
        String make = (String) json.get("make");
        String model = (String) json.get("model");
        String color = (String) json.get("color");
        String license = (String) json.get("license");
        String vin = (String) json.get("vin");
        String regdate = (String) json.get("regdate");
        
        vModel.editVehicle(id, year, make, model, color, license, vin, regdate);
        List vehicles = vModel.getVehicles();
        view.showIt(response, vehicles);
        
    }

}
