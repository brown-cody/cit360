package SL;

import SL.Handler.*;
import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/ServiceLog")
public class ServiceLog extends HttpServlet {

    String action;
    ApplicationController controller = new ApplicationController();
    public static SessionFactory factory;
    
    @Override
    public void init() {
        //Setup ACP HashMap for Vehicle Actions
        controller.mapCommand("AddVehicle", new AddVehicleHandler());
        controller.mapCommand("DoAddVehicle", new DoAddVehicleHandler());
        controller.mapCommand("EditVehicles", new EditVehiclesHandler());
        controller.mapCommand("EditVehicle", new EditVehicleHandler());
        controller.mapCommand("DoEditVehicle", new DoEditVehicleHandler());
        controller.mapCommand("DeleteVehicle", new DeleteVehicleHandler());
        controller.mapCommand("DoDeleteVehicle", new DoDeleteVehicleHandler());
        
        //Setup ACP HashMap for Service Actions
        controller.mapCommand("AddService", new AddServiceHandler());
        controller.mapCommand("BrowseService", new BrowseServiceHandler());
        controller.mapCommand("SearchService", new SearchServiceHandler());
        
        controller.mapCommand("quit", new ExitHandler());
        
        //Setup Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("SL/Model/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
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
    public void destroy() {
        factory.close();
    }

    @Override
    public String getServletInfo() {
        return "RAN getServletInfo() method of ServiceLog.java";
    }

}
