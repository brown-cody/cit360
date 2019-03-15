
package SL.Handler;

import SL.Model.URLConnect;
import java.io.IOException;
import java.io.PrintWriter;
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
        String makes = urlModel.getVehicleInfo();
        PrintWriter pw = response.getWriter();
        
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(makes);
        
        JSONArray jsonArr = (JSONArray) parser.parse(jsonObj.get("make").toString());
        
        for (Object JSONmakes : jsonArr) {
            JSONObject JSONmake = (JSONObject) JSONmakes;
            pw.println(JSONmake.get("id"));
            pw.println(JSONmake.get("name"));
        }
        
        //AddVehicleView addView = new AddVehicleView();
        //addView.showIt(response);
    }

}
