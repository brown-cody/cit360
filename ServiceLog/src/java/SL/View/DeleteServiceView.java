
package SL.View;

import SL.Service;
import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class DeleteServiceView {
    public void showIt(HttpServletResponse response, List service, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = service.iterator();
        Service s = (Service) iterator.next();
        
        String date = s.getDate().split(" ")[0];
        
        int i = 0;
        String curVehicle = null;

        for (Iterator vIterator = vehicles.iterator(); vIterator.hasNext();) {
            Vehicle v = (Vehicle) vIterator.next();
            i++;
            if (v.getId() == s.getVehicle()) {
            curVehicle = v.getYear() + " " + v.getMake() + " " + v.getModel(); 
            }
            
        }
        
        pw.println(hl.header("Delete Service"));
        
        pw.println("<h1>Delete Service Record</h1>");
        pw.println("<p class='serviceTitle'>Are you sure you want to delete this service record?</div>");
        pw.println("<p class='serviceInfo'><span class='heavy'>Vehicle: </span>" + curVehicle + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Service Date: </span>" + date + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Mileage: </span>" + s.getMileage() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Vendor: </span>" + s.getVendor() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Category: </span>" + s.getCategory() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Notes: </span>" + s.getNotes() + "</p>"
                + "<p class='serviceInfo bottomInfo'><span class='heavy'>Cost: </span>$" + s.getPrice() + "</p>");
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>NO, GO BACK</button>"
                + "</form>");
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='DoDeleteService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>YES, DELETE</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
