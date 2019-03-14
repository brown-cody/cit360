package SL;

import SL.Handler.*;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServiceLog")
public class ServiceLog extends HttpServlet {

    String action;
    ApplicationController controller = new ApplicationController();
        
    @Override
    public void init() {
        controller.mapCommand("AddVehicle", new AddVehicleHandler());
        controller.mapCommand("DoAddVehicle", new DoAddVehicleHandler());
        controller.mapCommand("EditVehicles", new EditVehiclesHandler());
        controller.mapCommand("EditVehicle", new EditVehicleHandler());
        controller.mapCommand("DoEditVehicle", new DoEditVehicleHandler());
        controller.mapCommand("DeleteVehicle", new DeleteVehicleHandler());
        controller.mapCommand("DoDeleteVehicle", new DoDeleteVehicleHandler());
        
        controller.mapCommand("AddService", new AddServiceHandler());
        controller.mapCommand("BrowseService", new BrowseServiceHandler());
        controller.mapCommand("SearchService", new SearchServiceHandler());
        
        controller.mapCommand("quit", new ExitHandler());
        
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
		
        action = request.getParameter("action");
        String data = request.getParameter("data");
        
        controller.handleRequest(action, response, data);
        

    }

    @Override
    public String getServletInfo() {
        return "RAN getServletInfo() method of ServiceLog.java";
    }

}
