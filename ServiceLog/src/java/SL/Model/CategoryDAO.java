
package SL.Model;

import SL.ServiceLog;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoryDAO {
    
    public List getCategories() {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Category ORDER BY name";
        List categories = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return categories;
    }
    
    public List getCategoryById(String id) {
        Session session = ServiceLog.factory.openSession();
        Transaction tx = session.beginTransaction();
        
        String sqlQuery = "FROM Category WHERE id = " + id;
        List categories = session.createQuery(sqlQuery).list();
        tx.commit();
        session.close();
        
        return categories;
    }
}
