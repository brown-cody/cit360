/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL.Model;

import SL.ApplicationController;
import static SL.ServiceLog.factory;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pq0192
 */
public class ServiceDAOTest {
        public static ApplicationController controller = new ApplicationController();
        public static SessionFactory factory;
    public ServiceDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

        //Setup Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("SL/hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addService method, of class ServiceDAO.
     */
    @Test
    public void testAddService() {
        System.out.println("addService");
        String vehicle = "1";
        String date = "2020-01-01";
        String mileage = "999999";
        String vendor = "O-O-O-Reilly";
        String category = "Insurance";
        String notes = "These are the notes.";
        String price = "999.99";
        ServiceDAO instance = new ServiceDAO();
        instance.addService(vehicle, date, mileage, vendor, category, notes, price);
    }

    /**
     * Test of getServices method, of class ServiceDAO.
     */
    @Test
    public void testGetServices() {
        System.out.println("getServices");
        ServiceDAO instance = new ServiceDAO();
        List expResult = null;
        List result = instance.getServices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceById method, of class ServiceDAO.
     */
    @Test
    public void testGetServiceById() {
        System.out.println("getServiceById");
        String id = "";
        ServiceDAO instance = new ServiceDAO();
        List expResult = null;
        List result = instance.getServiceById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editService method, of class ServiceDAO.
     */
    @Test
    public void testEditService() {
        System.out.println("editService");
        String id = "";
        String vehicle = "";
        String date = "";
        String mileage = "";
        String vendor = "";
        String category = "";
        String notes = "";
        String price = "";
        ServiceDAO instance = new ServiceDAO();
        instance.editService(id, vehicle, date, mileage, vendor, category, notes, price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteService method, of class ServiceDAO.
     */
    @Test
    public void testDeleteService() {
        System.out.println("deleteService");
        String id = "";
        ServiceDAO instance = new ServiceDAO();
        instance.deleteService(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
