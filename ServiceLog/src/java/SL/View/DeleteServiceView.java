
package SL.View;

import SL.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class DeleteServiceView {
    public void showIt(HttpServletResponse response, List service) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = service.iterator();
        Service s = (Service) iterator.next();
        
        pw.println(hl.header("Delete Service"));
        
        pw.println("<h1>Delete Service Record</h1>");
        pw.println("Are you sure you want to delete this service record?");
        pw.println(s.getDate() + " " + s.getVehicle() + " " + s.getMileage() + " " + s.getVendor() + " " + s.getCategory());
                
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='EditService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>No, Go Back</button>"
                + "</form>");
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='DoDeleteService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>Yes, Delete</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
