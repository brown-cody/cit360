
package SL.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class EditVehicleView {
    public void showIt(HttpServletResponse response, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset='ISO-8859-1'>"
                        + "<title>Edit Vehicles</title>"
                        + "<link rel='stylesheet' type='text/css' href='/ServiceLog/style.css'>"
                        + "</head>"
                        + "<body>"
                        + "<h1>Edit Vehicles</h1>"
                        + "<form method='post' action='ServiceLog'>"
                        + "<input type='hidden' name='action' value='av'>"
                        + "<button type='submit'>Add Vehicle</button>"
                        + "</form>");
        int i = 0;
        for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
            SL.Model.Vehicle vehicle = (SL.Model.Vehicle) iterator.next();
            i++;
            pw.println("<button>");
            pw.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " - " + vehicle.getColor());
            pw.println("</button>");
        }
        
        if (i == 0) {
            pw.println("No vehicles found.");
        }
        
        
        pw.println("</body></html>");
    }
}
