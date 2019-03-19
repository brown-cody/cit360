
package SL.View;

import SL.Vehicle;
import SL.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


public class AddServiceView {
    public void showIt(HttpServletResponse response, List vehicles, List categories) throws IOException {
        PrintWriter pw = response.getWriter();
        HTMLLibrary hl = new HTMLLibrary();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	String date = dtf.format(localDate);
        
        pw.println(hl.header("Add Service"));
        pw.println(hl.createServiceJSON("DoAddService"));
        
        pw.println("<h1>Add Service</h1>");
        pw.println("<input type='hidden' id='id' name ='id' value='NOID'>"
                + "<select id='vehicle' name='vehicle'>"
                + "<option value='' disabled selected>Vehicle</option>");
        
        int i = 0;
        for (Iterator vi = vehicles.iterator(); vi.hasNext();) {
            Vehicle v = (Vehicle) vi.next();
            i++;
            pw.println("<option value='" + v.getId() + "'>" + v.getYear() + " " + v.getMake() + " " + v.getModel() + "</option>");
        }
        
        pw.println("</select>"
                + "<input type='date' id='date' name='date' value='"+ date +"'>"
                + "<input type='text' id='mileage' name='mileage' placeholder='Mileage'>"
                + "<input type='text' id='vendor' name='vendor' placeholder='Vendor'>");
                //+ "<input type='text' id='category' name='category' placeholder='Category'>"
        pw.println("<select name='category' id='category'>"
                + "<option value='' disabled selected>Category</option>");
        i = 0;
        for (Iterator ci = categories.iterator(); ci.hasNext();) {
            Category c = (Category) ci.next();
            i++;
            pw.println("<option value='" + c.getId() + "'>" + c.getName() + "</option>");
        }

        pw.println("</select>");
        pw.println("<textarea id='notes' name='notes' rows='5' cols='25' placeholder='Notes'></textarea>"
                + "<input type='text' id='price' name='price' placeholder='price'>"
                + "<button onclick='submit()'>Submit</button>");
        
        pw.println("<form method='post' action='/ServiceLog'>"
                + "<button type='submit'>Cancel</button>"
                + "</form>");
        
        pw.println(hl.footer);
    }
}
