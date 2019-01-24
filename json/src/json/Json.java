
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
        
        //option to export JSON data from user input to JSONFile.json
        System.out.println("\nWould you like to encode data into \"JSONFile.json\"? (y/n)");
        confirm = br.readLine();
        if ("y".equals(confirm)) {
            getInput();
        }
        
        //option to import JSON data from external file called JSONDemo.json
        System.out.println("\nWould you like to decode data from \"JSONDemo.json\"? (y/n)");
        confirm = br.readLine();
        if ("y".equals(confirm)) {
            readFile();
        }
        
    }
    
    //runs when user confirms exporting JSON data to file
    public static void getInput()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //prompt for and store various inputs
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
        
        //create address object, use setAddress() to save user data into address object
        address newUserAddress = new address();
        newUserAddress.setAddress(address1,address2,city,state,zip);
        
        //create driver object, use setDriver() to save user data into driver object, including address object
        driver newUser = new driver();
        newUser.setDriver(dlNumber,firstName,lastName,eyeColor,hairColor,age,weight,newUserAddress);
        
        //pass execution to createJSON with newUser object as parameter
        createJSON(newUser);
    }
    
    //creates JSON from user inputted data
    public static void createJSON(driver newUser)  throws IOException {
        
        //assigns key pairs of the address object to addressJSON
        JSONObject addressJSON = new JSONObject();
        addressJSON.put("address1", newUser.userAddress.address1);
        addressJSON.put("address2", newUser.userAddress.address2);
        addressJSON.put("city", newUser.userAddress.city);
        addressJSON.put("state", newUser.userAddress.state);
        addressJSON.put("zip", newUser.userAddress.zip);
        
        //assigns key pairs of the driver object to userJSON, including addressJSON
        JSONObject userJSON = new JSONObject();
        userJSON.put("dlNumber", newUser.dlNumber);
        userJSON.put("firstName", newUser.firstName);
        userJSON.put("lastName", newUser.lastName);
        userJSON.put("eyeColor", newUser.eyeColor);
        userJSON.put("hairColor", newUser.hairColor);
        userJSON.put("age", newUser.age);
        userJSON.put("weight", newUser.weight);
        userJSON.put("userAddress", addressJSON);
        
        //pass execution to createFile with userJSON as parameter
        createFile(userJSON);
    }
    
    //creates a file from passed in JSON and outputs data for user review
    public static void createFile(JSONObject userJSON) throws IOException {
        try (FileWriter file = new FileWriter("JSONFile.json")){
            file.write(userJSON.toJSONString());
            System.out.println("JSON Object Created.");
            System.out.println("JSON Contents: " + userJSON);
            System.out.println("JSON Written to File: \"JSONFile.json\"");
        }
        
        
    }
    
    //runs when decode data option is selected in menu
    public static void readFile() throws IOException, ParseException {
        
        JSONParser parser = new JSONParser();
        
        //parse in JSONDemo.json and assign to userJSON
        JSONObject userJSON = (JSONObject) parser.parse(new FileReader("JSONDemo.json"));

        
        System.out.println("Imported JSON Object: " + userJSON);
        
        //assign JSON key values to variables
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
        
        //create address object and assign decoded JSON data to object attributes
        address importedUserAddress = new address();
        importedUserAddress.setAddress(address1,address2,city,state,zip);
        
        //create driver object and assign decoded JSON data to object attributes
        driver importedUser = new driver();
        importedUser.setDriver(dlNumber,firstName,lastName,eyeColor,hairColor,age,weight,importedUserAddress);
        
        //output imported JSON data for user review
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
