
package SL.Model;

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
        
        //SQL QUERY//
        String sqlQuery = "FROM Vehicle ORDER BY year ASC";
        List vehicles = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        factory.close();
        
        return vehicles;
    }
    
    public void addVehicle(String year, String make, String model, String color, String license, String vin, String regdate) {
        //INITIALIZE HIBERNATE//
        Configuration cfg = new Configuration();
        cfg.configure("SL/Model/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        //SQL QUERY//
        Vehicle v = new Vehicle();
        v.setYear(Integer.parseInt(year));
        v.setMake(make);
        v.setModel(model);
        v.setColor(color);
        v.setLicense(license);
        v.setVin(vin);
        v.setRegdate(regdate);
        session.save(v);
        
        tx.commit();
        session.close();
        factory.close();
    }
    
    public void editVehicle() {
        
    }



}
