
package SL.Handler;

import SL.Model.URLConnect;
import SL.View.AddVehicleView;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response, String data)  throws ServletException, IOException, ParseException {
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
        
        AddVehicleView addView = new AddVehicleView();
        addView.showIt(response, jsonArrMake, jsonArrModel, jsonArrColor);
    }

}
