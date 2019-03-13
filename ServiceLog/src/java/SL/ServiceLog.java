package SL;

import SL.Handler.ExitHandler;
import SL.Handler.AddServiceHandler;
import SL.Handler.BrowseServiceHandler;
import SL.Handler.AddVehicleHandler;
import SL.Handler.EditVehicleHandler;
import SL.Handler.SelectVehicleHandler;
import SL.Handler.SearchServiceHandler;
import java.io.IOException;
import java.io.PrintWriter;
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
        controller.mapCommand("av", new AddVehicleHandler());
        controller.mapCommand("ev", new EditVehicleHandler());
        controller.mapCommand("sv", new SelectVehicleHandler());
        controller.mapCommand("as", new AddServiceHandler());
        controller.mapCommand("bs", new BrowseServiceHandler());
        controller.mapCommand("ss", new SearchServiceHandler());
        controller.mapCommand("q", new ExitHandler());
        
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
		
        action = request.getParameter("action");
        controller.handleRequest(action, response);
    }

    @Override
    public String getServletInfo() {
        return "RAN getServletInfo() method of ServiceLog.java";
    }

}
