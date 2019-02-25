package hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Hibernate {
    
    public static void main(String[] args) throws IOException {
                java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        menu();

    }
    
    public static void menu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userQuery = "No query set.";
        
        System.out.println("\nWhich would you like to perform?");
        System.out.println("a - Add Vehicle");
        System.out.println("l - List All Vehicles");
        System.out.println("y - List Vehicles by Year");
        System.out.println("m - List Vehicles by Make");
        System.out.println("c - List Vehicles by Color");
        System.out.println("q - Quit");
        
        String choice = br.readLine();
        
        switch (choice) {
            case "a":
                insertVehicle();
                break;
            case "l":
                userQuery = "No userQuery";
                listVehiclesByAttribute("all", userQuery);
                break;
            case "y":
                userQuery = "\nEnter year (YYYY): ";
                listVehiclesByAttribute("year", userQuery);
                break;
            case "m":
                userQuery = "\nEnter make : ";
                listVehiclesByAttribute("make", userQuery);
                break;
            case "c":
                userQuery = "\nEnter color: ";
                listVehiclesByAttribute("color", userQuery);
                break;                
            case "q":
                break;
                
        }
    }
    
    public static void insertVehicle() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nEnter year (YYYY):");
        int year = Integer.parseInt(br.readLine());
        
        System.out.println("Enter make:");
        String make = br.readLine();
        
        System.out.println("Enter model:");
        String model = br.readLine();
        
        System.out.println("Enter color:");
        String color = br.readLine();
        
        Vehicle newVehicle = new Vehicle();
        newVehicle.setMake(make);
        newVehicle.setModel(model);
        newVehicle.setYear(year);
        newVehicle.setColor(color);
        
        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(newVehicle);
        System.out.println("\nNew vehicle entered!");
        tx.commit();
        session.close();
        factory.close();
        
        listVehiclesByAttribute("all", null);
    }
    
    public static void listVehiclesByAttribute(String attribute, String userQuery) throws IOException {
        

        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String querySup = "";
        if (attribute != "all") {
            System.out.println(userQuery);
            String userEntry = br.readLine();
            querySup = "WHERE " + attribute + " = '" + userEntry + "' ";
        }
        
        String sqlQuery = "FROM Vehicle " + querySup + "ORDER BY year ASC";
        
        System.out.println("\n");
        int i = 0;
        List vehicles = session.createQuery(sqlQuery).list();
        for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle vehicle = (Vehicle) iterator.next();
            i++;
            System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " - " + vehicle.getColor());
        }
        
        if (i == 0) {
            System.out.println("No vehicles found.");
        }
        
        tx.commit();
        session.close();
        factory.close();
        
        menu();
    }
    
}
