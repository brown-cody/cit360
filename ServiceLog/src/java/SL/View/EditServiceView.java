
package SL.View;

import SL.Category;
import SL.Service;
import SL.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class EditServiceView {
    public void showIt(HttpServletResponse response, List service, List vehicles, List categories) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        Iterator is = service.iterator();
        Service s = (Service) is.next();
        
        pw.println(hl.header("Edit Service Record"));
        pw.println(hl.createServiceJSON("DoEditService"));
        
        String date = s.getDate().split(" ")[0];
        
        pw.println("<h1>Edit Service Record</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='" + s.getId() + "'>"
                + "<select id='vehicle' name='vehicle'>");
        
        int x = 0;
        for (Iterator iv = vehicles.iterator(); iv.hasNext();) {
            Vehicle v = (Vehicle) iv.next();
            x++;
            String selected = " ";
            if (v.getId() == s.getVehicle()) {
                selected = "selected='selected'";
            }
            pw.println("<option value='" + v.getId() + "'" + selected + "'>" + v.getYear() + " " + v.getMake() + " " + v.getModel() + "</option>");
        }

        pw.println("</select>"
                + "<input type='date' id='date' name='date' value='" + date + "'>"
                + "<input type='text' id='mileage' name='mileage' value='" + s.getMileage() + "'>"
                + "<input type='text' id='vendor' name='vendor' value='" + s.getVendor() + "'>");
        
        pw.println("<select name='category' id='category'>");
        int i = 0;
        for (Iterator ci = categories.iterator(); ci.hasNext();) {
            Category c = (Category) ci.next();
            i++;
            String selectOption = "";
            if (c.getName().equals(s.getCategory())) {
                selectOption = "selected";
            }
            pw.println("<option value='" + c.getName() + "' " + selectOption + ">" + c.getName() + "</option>");
        }

        pw.println("</select>");
        
                //+ "<input type='text' id='category' name='category' value='" + s.getCategory() + "'>"
                
        pw.println("<textarea id='notes' name='notes' rows='5' cols='25' placeholder='Notes'>" + s.getNotes() + "</textarea>"
                + "<input type='text' id='price' name='price' value='" + s.getPrice() + "'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='BrowseService'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        pw.println("<form method='post' action='ServiceLog'>"
                + "<input type='hidden' name='action' value='DeleteService'>"
                + "<input type='hidden' name='data' value='" + s.getId() + "'>"
                + "<button type='submit'>Delete</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
