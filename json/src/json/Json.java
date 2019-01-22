
package json;

import org.json.simple.JSONObject;

public class Json {


    public static void main(String[] args) {

        driver newUser = new driver();
        newUser.dlNumber = 2016081112;
        newUser.firstName = "Bob";
        newUser.lastName = "Builder";
        newUser.eyeColor = "Brown";
        newUser.hairColor = "Black";
        newUser.age = 45;
        newUser.weight = 210.5;
        
        address newUserAddress = new address();
        newUserAddress.address1 = "1547 Tropical Snow St.";
        newUserAddress.address2 = "Apartment 714";
        newUserAddress.city = "Las Vegas";
        newUserAddress.state = "Nevada";
        newUserAddress.zip = 89127;
        
        newUser.userAddress = newUserAddress;
        JSONObject addressJSON = new JSONObject();
        addressJSON.put(newUserAddress, userAddress);
        
        JSONObject userJSON = new JSONObject();
        userJSON.put();
    }
    
}
