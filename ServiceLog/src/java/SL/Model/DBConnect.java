
package SL.Model;

import SL.ServiceLog;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DBConnect {
    
    //ServiceLog sl = new ServiceLog();
    
    public List getVehicles() {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Vehicle ORDER BY year ASC";
        List vehicles = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return vehicles;
    }
    
    public void addVehicle(String year, String make, String model, String color, String license, String vin, String regdate) {        
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
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
        
    }
    
    public List getVehicleById(String id) {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Vehicle WHERE id = " + id;
        List vehicles = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return vehicles;
    }

    public void editVehicle(String id, String year, String make, String model, String color, String license, String vin, String regdate) {        
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Vehicle v = new Vehicle();
        v.setId(Integer.parseInt(id));
        v.setYear(Integer.parseInt(year));
        v.setMake(make);
        v.setModel(model);
        v.setColor(color);
        v.setLicense(license);
        v.setVin(vin);
        v.setRegdate(regdate);
        session.update(v);

        tx.commit();
        session.close();
    }

    public void deleteVehicle(String id) {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Vehicle v = new Vehicle();
        v.setId(Integer.parseInt(id));
        session.delete(v);

        tx.commit();
        session.close();
    }
}
