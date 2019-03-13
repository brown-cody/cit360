
package SL.Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class AddVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response)  throws ServletException, IOException {
    //public void handleIt(HashMap<String, Object> data) {
    //public void handleIt() {
        
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset='ISO-8859-1'>"
                        + "<title>Service Log</title>"
                        + "<link rel='stylesheet' type='text/css' href='/ServiceLog/style.css'>"
                        + "</head>"
                        + "<body>"
                        + "<h2>ADD VEHICLE HANDLER</h2>"
                        + "<p>This vehicle has been added</p>"
                        + "<p>that is neat.</p>");
        pw.println("</body></html>");
        
    }

}
