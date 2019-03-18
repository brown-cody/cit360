
package SL.Handler;

import SL.Model.URLConnect;
import SL.Model.VehicleDAO;
import SL.View.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String id)  throws ServletException, IOException, ParseException {
        
        VehicleDAO dbModel = new VehicleDAO();
        EditVehicleView view = new EditVehicleView();
        
        URLConnect urlModel = new URLConnect();
        String makes = urlModel.getVehicleInfo("makes");
        String models = urlModel.getVehicleInfo("models");
        String colors = urlModel.getVehicleInfo("colors");
        
        JSONParser parser = new JSONParser();
        JSONObject jsonObjMake = (JSONObject) parser.parse(makes);
        JSONObject jsonObjModel = (JSONObject) parser.parse(models);
        JSONObject jsonObjColor = (JSONObject) parser.parse(colors);
        
        JSONArray jsonArrMake = (JSONArray) parser.parse(jsonObjMake.get("make").toString());
        JSONArray jsonArrModel = (JSONArray) parser.parse(jsonObjModel.get("model").toString());
        JSONArray jsonArrColor = (JSONArray) parser.parse(jsonObjColor.get("color").toString());
        
        List vehicle = dbModel.getVehicleById(id);
        
        view.showIt(response, vehicle, jsonArrMake, jsonArrModel, jsonArrColor);
                
    }

}
