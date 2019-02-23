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
                listAllVehicles();
                break;
            case "y":
                listVehiclesByYear();
                break;
            case "m":
                listVehiclesByMake();
                break;
            case "c":
                listVehiclesByColor();
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
        
        listAllVehicles();
    }
    
    public static void listAllVehicles() throws IOException {
        

        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        System.out.println("\n");
        
        List vehicles = session.createQuery("FROM Vehicle").list();
        for (Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
            Vehicle vehicle = (Vehicle) iterator.next();
            System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " - " + vehicle.getColor());

        }
        
        tx.commit();
        session.close();
        factory.close();
        
        menu();
    }
    
    public static void listVehiclesByYear() throws IOException {
        

        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nEnter year (YYYY):");
        int year = Integer.parseInt(br.readLine());
        
        System.out.println("\n");
        int i = 0;
        List vehicles = session.createQuery("FROM Vehicle WHERE year = " + year).list();
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
    
    public static void listVehiclesByColor() throws IOException {
        

        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nEnter Color:");
        String color = br.readLine();
        
        System.out.println("\n");
        int i = 0;
        List vehicles = session.createQuery("FROM Vehicle WHERE color = '" + color + "'").list();
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
    
        public static void listVehiclesByMake() throws IOException {
        

        Configuration cfg = new Configuration();
        cfg.configure("/hibernate/hibernateconfig.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nEnter Make:");
        String make = br.readLine();
        
        System.out.println("\n");
        int i = 0;
        List vehicles = session.createQuery("FROM Vehicle WHERE make = '" + make + "'").list();
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
