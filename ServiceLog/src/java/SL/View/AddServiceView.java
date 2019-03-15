
package SL.View;

import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class AddServiceView {
    public void showIt(HttpServletResponse response, List vehicles) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        pw.println(hl.header("Add Service"));
        pw.println(hl.createServiceJSON("DoAddService"));
        
        pw.println("<h1>Add Service</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='NOID'>"
                + "<select id='vehicle' name='vehicle'>");
        
        int i = 0;
        for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle v = (Vehicle) iterator.next();
            i++;
            pw.println("<option value='" + v.getId() + "'>" + v.getYear() + " " + v.getMake() + " " + v.getModel() + "</option>");
        }
        
        if (i == 0) {
            pw.println("<option value='NOID'>No Vehicles</option>");
        }
        
        pw.println("</select>"
                + "<input type='date' id='date' name='date'>"
                + "<input type='text' id='mileage' name='mileage' placeholder='Mileage'>"
                + "<input type='text' id='vendor' name='vendor' placeholder='Vendor'>"
                + "<input type='text' id='category' name='category' placeholder='Category'>"
                + "<textarea id='notes' name='notes' rows='5' cols='25' placeholder='Notes'></textarea>"
                + "<input type='text' id='price' name='price' placeholder='price'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='/ServiceLog'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
