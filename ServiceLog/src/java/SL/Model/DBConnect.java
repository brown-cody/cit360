
package SL.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DBConnect {
    
    
    public List getVehicles() {
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
        
        return vehicles;
    }
    
    public void addVehicle() {
        
    }
    
    public void editVehicle() {
        
    }



}
