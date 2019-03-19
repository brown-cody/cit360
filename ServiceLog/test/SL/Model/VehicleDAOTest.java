/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SL.Model;

import java.util.List;
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
public class VehicleDAOTest {
    
    public VehicleDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of getVehicles method, of class VehicleDAO.
     */
    @Test
    public void testGetVehicles() {
        System.out.println("getVehicles");
        VehicleDAO instance = new VehicleDAO();
        List expResult = null;
        List result = instance.getVehicles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVehicle method, of class VehicleDAO.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        String year = "";
        String make = "";
        String model = "";
        String color = "";
        String license = "";
        String vin = "";
        String regdate = "";
        VehicleDAO instance = new VehicleDAO();
        instance.addVehicle(year, make, model, color, license, vin, regdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehicleById method, of class VehicleDAO.
     */
    @Test
    public void testGetVehicleById() {
        System.out.println("getVehicleById");
        String id = "";
        VehicleDAO instance = new VehicleDAO();
        List expResult = null;
        List result = instance.getVehicleById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editVehicle method, of class VehicleDAO.
     */
    @Test
    public void testEditVehicle() {
        System.out.println("editVehicle");
        String id = "";
        String year = "";
        String make = "";
        String model = "";
        String color = "";
        String license = "";
        String vin = "";
        String regdate = "";
        VehicleDAO instance = new VehicleDAO();
        instance.editVehicle(id, year, make, model, color, license, vin, regdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteVehicle method, of class VehicleDAO.
     */
    @Test
    public void testDeleteVehicle() {
        System.out.println("deleteVehicle");
        String id = "";
        VehicleDAO instance = new VehicleDAO();
        instance.deleteVehicle(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
