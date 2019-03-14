
package SL.View;

import SL.Model.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class EditVehicleView {
    public void showIt(HttpServletResponse response, List vehicle) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = vehicle.iterator();
        Vehicle v = (Vehicle) iterator.next();
        
        pw.println(hl.header);
        pw.println(hl.createVehicleJSON("DoEditVehicle"));
        
        pw.println("<h1>Edit Vehicle</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='" + v.getId() + "'>"
                + "<input type='text' id='year' name='year' value='" + v.getYear() + "'>"
                + "<input type='text' id='make' name='make' value='" + v.getMake() + "'>"
                + "<input type='text' id='model' name='model' value='" + v.getModel() + "'>"
                + "<input type='text' id='color' name='color' value='" + v.getColor() + "'>"
                + "<input type='text' id='license' name='license' value='" + v.getLicense() + "'>"
                + "<input type='text' id='vin' name='vin' value='" + v.getVin() + "'>"
                + "<input type='text' id='regdate' name='regdate' value='" + v.getRegdate() + "'>"
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
        
        pw.println(hl.footer);
    }
}
