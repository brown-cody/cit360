
package SL.View;

import SL.Service;
import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class BrowseServiceView {
    public void showIt(HttpServletResponse response, List services) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        pw.println(hl.header("Browse Services"));
        
        pw.println("<h1>Browse Services</h1>");
        
        pw.println("<form method='post' action='/ServiceLog'>"
                + "<button type='submit'>Home</button>"
                + "</form>");
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='AddService'>"
                + "<button type='submit'>Add Service</button>"
                + "</form>");
        
        int i = 0;
        for (Iterator iterator = services.iterator(); iterator.hasNext();) {
            Service service = (Service) iterator.next();
            i++;
            pw.println("<form method='post' action='ServiceLog'>");
            pw.println("<input type='hidden' name='action' value='ViewService'>");
            pw.println("<button name='data' value='" + service.getId() + "'>");
            pw.println(service.getDate() + " " + service.getVehicle() + " " + service.getMileage() + " " + service.getCategory());
            pw.println("</button>");
            pw.println("</form>");
        }
        
        if (i == 0) {
            pw.println("No services found.");
        }
        
        pw.println(hl.footer);
    }
}
