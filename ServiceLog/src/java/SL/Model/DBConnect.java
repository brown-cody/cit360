
package SL.Model;

import SL.Service;
import SL.Vehicle;
import SL.ServiceLog;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DBConnect {
    
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
    
    public void addService(String vehicle, String date, String mileage, String vendor, String category, String notes, String price) {        
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Service s = new Service();
        s.setVehicle(Integer.parseInt(vehicle));
        s.setDate(date);
        s.setMileage(Integer.parseInt(mileage));
        s.setVendor(vendor);
        s.setCategory(category);
        s.setNotes(notes);
        s.setPrice(price);
        
        session.save(s);
        
        tx.commit();
        session.close();
        
    }
    
    public List getServices() {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Service ORDER BY date DESC";
        List services = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return services;
    }
    
    public List getServiceById(String id) {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Service WHERE id = " + id;
        List services = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return services;
    }
    
    public void editService(String id, String vehicle, String date, String mileage, String vendor, String category, String notes, String price) {        
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Service s = new Service();
        s.setId(Integer.parseInt(id));
        s.setVehicle(Integer.parseInt(vehicle));
        s.setDate(date);
        s.setMileage(Integer.parseInt(mileage));
        s.setVendor(vendor);
        s.setCategory(category);
        s.setNotes(notes);
        s.setPrice(price);
        
        session.update(s);

        tx.commit();
        session.close();
    }
    
    public void deleteService(String id) {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Service s = new Service();
        s.setId(Integer.parseInt(id));
        session.delete(s);

        tx.commit();
        session.close();
    }
}
