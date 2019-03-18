
package SL.View;

import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class EditVehicleView {
    public void showIt(HttpServletResponse response, List vehicle, JSONArray jsonArrMake, JSONArray jsonArrModel, JSONArray jsonArrColor) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = vehicle.iterator();
        Vehicle v = (Vehicle) iterator.next();
        
        String date = v.getRegdate().split(" ")[0];
        
        pw.println(hl.header("Edit Vehicle"));
        pw.println(hl.createVehicleJSON("DoEditVehicle"));
        pw.println(hl.hideAndFilterModels);
        
        pw.println("<h1>Edit Vehicle</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='" + v.getId() + "'>"
                + "<input type='text' id='year' name='year' value='" + v.getYear() + "'>");
                        
                //+ "<input type='text' id='make' name='make' value='" + v.getMake() + "'>"
                //+ "<input type='text' id='model' name='model' value='" + v.getModel() + "'>"
                //+ "<input type='text' id='color' name='color' value='" + v.getColor() + "'>"
                   
                        
        pw.println("<select id='make' name='make' onclick='hideModel()'>"
                + "<option value='' disabled selected>Make</option>");
            
                for (Object JSONmakes : jsonArrMake) {
                    JSONObject JSONmake = (JSONObject) JSONmakes;
                    String selectOption = "";
                    if (JSONmake.get("name").equals(v.getMake())) {
                        selectOption = "selected";
                    }
                    pw.println("<option value='" + JSONmake.get("name") + "' class='" + JSONmake.get("id") + "' " + selectOption + ">" + JSONmake.get("name") + "</option>");
                }
                        
        pw.println("</select>"
                + "<select id='model' name='model'>");
        
                for (Object JSONmodels : jsonArrModel) {
                    JSONObject JSONmodel = (JSONObject) JSONmodels;
                    String selectOption = "";
                    if (JSONmodel.get("name").equals(v.getModel())) {
                        selectOption = "selected";
                    }
                    pw.println("<option value='" + JSONmodel.get("name") + "' class='mod " + JSONmodel.get("make") + "' " + selectOption + ">" + JSONmodel.get("name") + "</option>");
                }
                
        pw.println("</select>"
                + "<select id='color' name='color'>");
                
                for (Object JSONcolors : jsonArrColor) {
                    JSONObject JSONcolor = (JSONObject) JSONcolors;
                    String selectOption = "";
                    if (JSONcolor.get("name").equals(v.getColor())) {
                        selectOption = "selected";
                    }
                    pw.println("<option value='" + JSONcolor.get("name") + "' " + selectOption + ">" + JSONcolor.get("name") + "</option>");
                }
                        
        pw.println("</select>");
                        
                        
                        
                        
                        
        pw.println("<input type='text' id='license' name='license' value='" + v.getLicense() + "'>"
                + "<input type='text' id='vin' name='vin' value='" + v.getVin() + "'>"
                + "<input type='date' id='regdate' name='regdate' value='" + date + "'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditVehicles'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='DeleteVehicle'>"
                + "<input type='hidden' name='data' value='" + v.getId() + "'>"
                + "<button type='submit'>Delete</button>"
                + "</form>");
        pw.println("<script>hideModel()</script>");
        pw.println(hl.footer);
    }
}
