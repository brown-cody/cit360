
package SL.View;

import SL.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class ViewServiceView {
    public void showIt(HttpServletResponse response, List service) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator iterator = service.iterator();
        Service s = (Service) iterator.next();
        
        pw.println(hl.header("View Service"));
        
        pw.println("<h1>View Service Record</h1>");
        pw.println("<p>" + s.getId() + "</p>"
                + "<p>" + s.getVehicle() + "</p>"
                + "<p>" + s.getDate() + "</p>"
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
