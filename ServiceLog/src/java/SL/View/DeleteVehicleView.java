
package SL.View;

import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class DeleteVehicleView {
    public void showIt(HttpServletResponse response, List vehicle) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = vehicle.iterator();
        Vehicle v = (Vehicle) iterator.next();
        
        pw.println(hl.header("Delete Vehicle"));
        
        pw.println("<h1>Delete Vehicle</h1>");
        pw.println("Are you sure you want to delete this vehicle?");
        pw.println(v.getYear() + " " + v.getMake() + " " + v.getModel() + " - " + v.getColor());
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditVehicles'>"
                + "<button type='submit'>No, Go Back</button>"
                + "</form>");
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='DoDeleteVehicle'>"
                + "<input type='hidden' name='data' value='" + v.getId() + "'>"
                + "<button type='submit'>Yes, Delete</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
