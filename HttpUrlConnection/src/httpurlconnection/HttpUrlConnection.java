
 
package httpurlconnection;

import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HttpUrlConnection {
    
    static String loc;
    static String temp;
    static String phrase;
    static String high;
    static String low;
    static Boolean serverOnline = true;

    public static void main(String[] args) throws Exception {
        
        menu();

    }
       public static void menu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nDo you want to get weather for a new location? (y/n)");
        String choice = br.readLine();
        switch (choice) {
            case "y":
                userInput();
                break;
            case "n":
                break;
                
        }
    } 
       
    public static void userInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter a valid zip code to get the current weather. (Server Online: " + serverOnline + ")");

        //String zip = br.readLine();
        //String zip = "93274";
        
        getWeather(br.readLine());
        

        
        menu();


    }
    

    
    public static void getWeather(String zip) throws MalformedURLException, IOException {
        
        String setURL;
        
        if (serverOnline == true) {
            setURL = "https://weather.com/weather/today/l/" + zip + ":4:US";
            serverOnline = false;
        } else {
            setURL = "https://badurl123456789.com/weather/today/l/" + zip + ":4:US";
            serverOnline = true;
        }
        
        
        
        URL weather = new URL(setURL);
        
        if (openConnection(weather) ==  null) {
            return;
        }
        
        HttpURLConnection huc = openConnection(weather);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
        
        String inputLine;
        StringBuffer rp = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            rp.append(inputLine);
        }
        in.close();
        
        String wholePage = rp.toString().replace("\"", "");
        //System.out.println(wholePage);

        Pattern ploc = Pattern.compile("className=h4 today_nowcard-location>(.*?)<span");
        Matcher mloc = ploc.matcher(wholePage);
        
        Pattern ptemp = Pattern.compile("<span class=>(.*?)<sup>");
        Matcher mtemp = ptemp.matcher(wholePage);
        
        Pattern pphrase = Pattern.compile("<div class=today_nowcard-phrase>(.*?)</div>");
        Matcher mphrase = pphrase.matcher(wholePage);
        
        Pattern phi = Pattern.compile("H<!----> </span><span class=deg-hilo-nowcard><span class=>(.*?)<sup>");
        Matcher mhi = phi.matcher(wholePage);
        
        Pattern plo = Pattern.compile("L<!----> </span><span class=deg-hilo-nowcard><span class=>(.*?)<sup>");
        Matcher mlo = plo.matcher(wholePage);
        
        mloc.find();
        mtemp.find();
        mphrase.find();
        mhi.find();
        mlo.find();
        
        /*
        System.out.println("Temp: " + mtemp.find());
        System.out.println("Phrase: " + mphrase.find());
        System.out.println("High: " + mhi.find());
        System.out.println("Low: " + mlo.find());
        */
        
        loc = mloc.group(1);
        temp = mtemp.group(1);
        phrase = mphrase.group(1);
        high = mhi.group(1);
        low = mlo.group(1);

        System.out.println("\nThe current weather at " + loc + " is " + temp + "\u2109 and " + phrase + ".");
        System.out.println("High: " + high + "\u2109" + " Low: " + low + "\u2109");
    }
    
    public static HttpURLConnection openConnection(URL weather ) throws IOException {
        try {
            HttpURLConnection huc = (HttpURLConnection) weather.openConnection();
            int response = huc.getResponseCode();
            //System.out.println("response code: " + response);
            return huc;
        } catch(Exception e) {
            System.out.println("#####     ERROR 404: Page Not Found    #####");

            return null;
        }
        
    }
    
}
