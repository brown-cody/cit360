
package SL.View;

import SL.Service;
import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class BrowseServiceView {
    public void showIt(HttpServletResponse response, List services, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        pw.println(hl.header("Browse Services"));
        
        pw.println("<h1>Browse Services</h1>");
        
        pw.println("<form method='post' action='/ServiceLog'>"
                + "<button type='submit'>HOME</button>"
                + "</form>");
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='AddService'>"
                + "<button type='submit'>ADD SERVICE</button>"
                + "</form>");
        
        int i = 0;
        for (Iterator iterator = services.iterator(); iterator.hasNext();) {
            Service s = (Service) iterator.next();
            String date = s.getDate().split(" ")[0];
            i++;
            pw.println("<form method='post' action='ServiceLog'>");
            pw.println("<input type='hidden' name='action' value='ViewService'>");
            pw.println("<button name='data' value='" + s.getId() + "'>");
            pw.println(date + "<br>");
                    
            int x = 0;
            for (Iterator iv = vehicles.iterator(); iv.hasNext();) {
                Vehicle v = (Vehicle) iv.next();
                x++;
                String selected = " ";
                if (v.getId() == s.getVehicle()) {
                    pw.println(v.getModel());
                }
            }
                    
            pw.println("<br>");        
            pw.println(" " + s.getCategory());
            pw.println("</button>");
            pw.println("</form>");
        }
        
        if (i == 0) {
            pw.println("No services found.");
        }
        
        pw.println(hl.footer);
    }
}
