
package SL.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class AddVehicleView {
    public void showIt(HttpServletResponse response, JSONArray jsonArrMake, JSONArray jsonArrModel, JSONArray jsonArrColor) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	String date = dtf.format(localDate);
        
        pw.println(hl.header("Add Vehicle"));
        pw.println(hl.createVehicleJSON("DoAddVehicle"));
        
        
        pw.println("<script>"
                + ""
                + "function hideModel() {"
                + "var modelClass = 'mod';"
                + "var htmlArray = document.getElementsByClassName(modelClass);"
                + "for(i = 0; i < htmlArray.length; i++) {"
                + "htmlArray[i].style.display = 'none';"
                + "}"
                + "filterModel();"
                + "}"
                + ""
                + "function filterModel() {"
                + "var selectedMakeId = document.getElementById('make').value;"
                + "console.log(selectedMakeId);"
            
                + "var modelClass = 'mod ' + selectedMakeId;"
                + "var htmlArray = document.getElementsByClassName(modelClass);"
            
                + "for(i = 0; i < htmlArray.length; i++) {"
                + "htmlArray[i].style.removeProperty('display');"
                + "}"
                + "}"
                + "</script>");
        
        
        pw.println("<h1>Add Vehicle</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='NOID'>"
                + "<input type='text' id='year' name='year' placeholder='Year'>"
                + "<select id='make' name='make' onclick='hideModel()'>"
                + "<option value='' disabled selected>Make</option>");
            
                for (Object JSONmakes : jsonArrMake) {
                    JSONObject JSONmake = (JSONObject) JSONmakes;
                    pw.println("<option value='" + JSONmake.get("name") + "' class='" + JSONmake.get("id") + "'>" + JSONmake.get("name") + "</option>");
                }
                        
        pw.println("</select>"
                + "<select id='model' name='model'>"
                + "<option value='' disabled selected>Model</option>");
        
                for (Object JSONmodels : jsonArrModel) {
                    JSONObject JSONmodel = (JSONObject) JSONmodels;
                    pw.println("<option value='" + JSONmodel.get("name") + "' class='mod " + JSONmodel.get("make") + "'>" + JSONmodel.get("name") + "</option>");
                }
                
        pw.println("</select>"
                + "<select id='color' name='color'>"
                + "<option value='' disabled selected>Color</option>");
                
                for (Object JSONcolors : jsonArrColor) {
                    JSONObject JSONcolor = (JSONObject) JSONcolors;
                    pw.println("<option value='" + JSONcolor.get("name") + "'>" + JSONcolor.get("name") + "</option>");
                }
                        
        pw.println("<input type='text' id='license' name='license' placeholder='License Plate'>"
                + "<input type='text' id='vin' name='vin' placeholder='VIN'>"
                + "<input type='date' id='regdate' name='regdate' value='" + date + "'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditVehicles'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
