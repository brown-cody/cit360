
package SL.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class URLConnect {
    public String getVehicleInfo(String type) throws MalformedURLException, IOException {

        URL url = new URL("http://xrkund.duckdns.org:8080/api/all" + type + ".json");
        
        HttpURLConnection huc;
        try {
            huc = (HttpURLConnection) url.openConnection();
        } catch(IOException e) {
            System.out.println("#####     ERROR 404: Page Not Found    #####");

            return null;
        }
                
        BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
        
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();
        
        String wholePage = sb.toString();
        
        return wholePage;
    }
    
}
