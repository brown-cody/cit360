
package SL.View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;


public class AddVehicleView {
    public void showIt(HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        pw.println(hl.header);
        pw.println(hl.createVehicleJSON("DoAddVehicle"));
        
        pw.println("<h1>Add Vehicle</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='NOID'>"
                + "<input type='text' id='year' name='year' placeholder='Year'>"
                + "<input type='text' id='make' name='make' placeholder='Make'>"
                + "<input type='text' id='model' name='model' placeholder='Model'>"
                + "<input type='text' id='color' name='color' placeholder='Color'>"
                + "<input type='text' id='license' name='license' placeholder='License Plate'>"
                + "<input type='text' id='vin' name='vin' placeholder='VIN'>"
                + "<input type='text' id='regdate' name='regdate' placeholder='Registration Expiration'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditVehicle'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
