
package json;

import java.io.BufferedReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Json {

    
    
    public static void main(String[] args)  throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String confirm;
        
        System.out.println("\nWould you like to encode data into \"JSONFile.json\"? (y/n)");
        confirm = br.readLine();
        if ("y".equals(confirm)) {
            getInput();
        }
        
        System.out.println("\nWould you like to decode data from \"JSONDemo.json\"? (y/n)");
        confirm = br.readLine();
        if ("y".equals(confirm)) {
            readFile();
        }
        
    }
    
    public static void getInput()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("DL number (9-digit): ");
        int dlNumber = Integer.parseInt(br.readLine());
        System.out.println("First Name: ");
        String firstName = br.readLine();
        System.out.println("Last Name: ");
        String lastName = br.readLine();
        System.out.println("Eye Color: ");
        String eyeColor = br.readLine();
        System.out.println("Hair Color: ");
        String hairColor = br.readLine();        
        System.out.println("Age: ");
        int age = Integer.parseInt(br.readLine());
        System.out.println("Weight: ");
        long weight = Long.parseLong(br.readLine());
        
        System.out.println("Address Line 1: ");
        String address1 = br.readLine();
        System.out.println("Address Line 2: ");
        String address2 = br.readLine();
        System.out.println("City: ");
        String city = br.readLine();
        System.out.println("State: ");
        String state = br.readLine();
        System.out.println("Zip Code: ");
        int zip = Integer.parseInt(br.readLine());
        
        address newUserAddress = new address();
        //newUserAddress.setAddress("1547 Tropical Snow St.","Apartment 714","Las Vegas","Nevada",89127);
        newUserAddress.setAddress(address1,address2,city,state,zip);
        
        driver newUser = new driver();
        //newUser.setDriver(2016081112,"Bob","Builder","Brown","Black",45,210.5,newUserAddress);
        newUser.setDriver(dlNumber,firstName,lastName,eyeColor,hairColor,age,weight,newUserAddress);
        
        createJSON(newUser);
    }
    
    public static void createJSON(driver newUser)  throws IOException {
        
        JSONObject addressJSON = new JSONObject();
        addressJSON.put("address1", newUser.userAddress.address1);
        addressJSON.put("address2", newUser.userAddress.address2);
        addressJSON.put("city", newUser.userAddress.city);
        addressJSON.put("state", newUser.userAddress.state);
        addressJSON.put("zip", newUser.userAddress.zip);
        
        JSONObject userJSON = new JSONObject();
        userJSON.put("dlNumber", newUser.dlNumber);
        userJSON.put("firstName", newUser.firstName);
        userJSON.put("lastName", newUser.lastName);
        userJSON.put("eyeColor", newUser.eyeColor);
        userJSON.put("hairColor", newUser.hairColor);
        userJSON.put("age", newUser.age);
        userJSON.put("weight", newUser.weight);
        userJSON.put("userAddress", addressJSON);
        
        createFile(userJSON);
    }
    
    public static void createFile(JSONObject userJSON) throws IOException {
        try (FileWriter file = new FileWriter("JSONFile.json")){
            file.write(userJSON.toJSONString());
            System.out.println("JSON Object Created.");
            System.out.println("JSON Contents: " + userJSON);
            System.out.println("JSON Written to File: \"JSONFile.json\"");
        }
        
        
    }
    
    public static void readFile() throws IOException, ParseException {
        
        JSONParser parser = new JSONParser();
        
        //Object obj = parser.parse(new FileReader("JSONDemo.json"));
        JSONObject userJSON = (JSONObject) parser.parse(new FileReader("JSONDemo.json"));

        
        System.out.println("Imported JSON Object: " + userJSON);
        
        int dlNumber = ((Long) userJSON.get("dlNumber")).intValue();
        String firstName = (String) userJSON.get("firstName");
        String lastName = (String) userJSON.get("lastName");
        String eyeColor = (String) userJSON.get("eyeColor");
        String hairColor = (String) userJSON.get("hairColor");
        int age = ((Long) userJSON.get("age")).intValue();
        long weight = (Long) userJSON.get("weight");
        
        JSONObject addressJSON = (JSONObject) userJSON.get("userAddress");
        String address1 = (String) addressJSON.get("address1");
        String address2 = (String) addressJSON.get("address2");
        String city = (String) addressJSON.get("city");
        String state = (String) addressJSON.get("state");
        int zip = ((Long) addressJSON.get("zip")).intValue();
        
        address importedUserAddress = new address();
        importedUserAddress.setAddress(address1,address2,city,state,zip);
        
        driver importedUser = new driver();
        importedUser.setDriver(dlNumber,firstName,lastName,eyeColor,hairColor,age,weight,importedUserAddress);
        
        System.out.println("DL Number: " + importedUser.dlNumber +
                           "\nFirst Name: " + importedUser.firstName +
                           "\nLast Name: " + importedUser.lastName + 
                           "\nEye Color: " + importedUser.eyeColor + 
                           "\nHair Color: " + importedUser.hairColor +
                           "\nAge: " + importedUser.age +
                           "\nWeight: " + importedUser.weight +
                           "\nAddress Line 1: " + importedUser.userAddress.address1 +
                           "\nAddress Line 2: " + importedUser.userAddress.address2 +
                           "\nCity: " + importedUser.userAddress.city +
                           "\nState: " + importedUser.userAddress.state +
                           "\nZip: " + importedUser.userAddress.zip);
    }
    
}
