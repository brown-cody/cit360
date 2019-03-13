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
        controller.mapCommand("EditVehicle", new EditVehicleHandler());
        controller.mapCommand("DeleteVehicle", new DeleteVehicleHandler());
        
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
        String data = request.getParameter("JSON");
        
        controller.handleRequest(action, response, data);
        

    }

    @Override
    public String getServletInfo() {
        return "RAN getServletInfo() method of ServiceLog.java";
    }

}
