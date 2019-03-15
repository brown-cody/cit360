
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
        if (i == 0) {
            pw.println("<option value='NOID'>No Vehicle</option>");
        }
        
        pw.println(hl.header("View Service"));
        
        pw.println("<h1>View Service Record</h1>");
        pw.println("<p>" + curVehicle + "</p>"
                + "<p>" + date + "</p>"
                + "<p>" + s.getMileage() + "</p>"
                + "<p>" + s.getVendor() + "</p>"
                + "<p>" + s.getCategory() + "</p>"
                + "<p>" + s.getNotes() + "</p>"
                + "<p>" + s.getPrice() + "</p>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>Edit</button>"
                + "</form>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='BrowseService'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
