
package SL.View;

import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class EditVehiclesView {
    public void showIt(HttpServletResponse response, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        pw.println(hl.header("Edit Vehicles"));
        
        pw.println("<h1>Edit Vehicles</h1>");
        
        pw.println("<form method='post' action='/ServiceLog'>"
                + "<button type='submit'>HOME</button>"
                + "</form>");
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='AddVehicle'>"
                + "<button type='submit'>ADD VEHICLE</button>"
                + "</form>");
        int i = 0;
        for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle vehicle = (Vehicle) iterator.next();
            i++;
            pw.println("<form method='post' action='ServiceLog'>");
            pw.println("<input type='hidden' name='action' value='EditVehicle'>");
            pw.println("<button name='data' value='" + vehicle.getId() + "'>");
            pw.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + "<br>" + vehicle.getColor());
            pw.println("</button>");
            pw.println("</form>");
        }
        
        if (i == 0) {
            pw.println("No vehicles found.");
        }
        
        pw.println(hl.footer);
    }
}
