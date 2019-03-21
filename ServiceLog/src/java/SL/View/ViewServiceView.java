
package SL.View;

import SL.Service;
import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class ViewServiceView {
    public void showIt(HttpServletResponse response, List service, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator sIterator = service.iterator();
        Service s = (Service) sIterator.next();
        
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
        
        
        pw.println(hl.header("View Service"));
        
        pw.println("<h1>View Service Record</h1>");
        pw.println("<p class='serviceInfo'>" + curVehicle + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Service Date: </span>" + date + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Mileage: </span>" + s.getMileage() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Vendor: </span>" + s.getVendor() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Category: </span>" + s.getCategory() + "</p>"
                + "<p class='serviceInfo'><span class='heavy'>Notes: </span>" + s.getNotes() + "</p>"
                + "<p class='serviceInfo bottomInfo'><span class='heavy'>Cost: </span>$" + s.getPrice() + "</p>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>EDIT</button>"
                + "</form>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='BrowseService'>"
                + "<button type='submit'>CANCEL</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
