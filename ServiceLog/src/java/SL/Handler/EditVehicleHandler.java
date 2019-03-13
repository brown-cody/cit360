
package SL.Handler;

import SL.View.EditVehicleView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EditVehicleHandler implements Handler {
    
    @Override
    public void handleIt(HttpServletResponse response)  throws ServletException, IOException {
        
        //INITIALIZE HIBERNATE//
        Configuration cfg = new Configuration();
        cfg.configure("SL/Model/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //SQL QUERY//
        String sqlQuery = "FROM Vehicle ORDER BY year ASC";
        List vehicles = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        factory.close();
        
        //VIEW CALL
        EditVehicleView view = new EditVehicleView();
        view.showIt(response, vehicles);
        
    }

}
