
package applicationcontrollerpattern;

import java.util.HashMap;
import java.util.Scanner;

public class MadLibHandler implements Handler {
    
    @Override
    public void handleIt(HashMap<String, Object> data) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter a name: ");
        String name = scanner.nextLine();
        System.out.println("Enter a verb: ");
        String verb = scanner.nextLine();
        System.out.println("Enter a food: ");
        String food = scanner.nextLine();
        System.out.println("Enter a number: ");
        String num = scanner.nextLine();
        System.out.println("Enter a time of day: ");
        String tod = scanner.nextLine();
        
        
        String madLibText = "\n\nThere once was a boy named " + name + ". He was always messing around. One day his"
                          + "\nteacher caught him " + verb + "ing in class. He got detention for it. At lunch time"
                          + "\n" + name + " got in trouble again when he shot " + num + " spitballs at the cafeteria"
                          + "\nmonitor. He was so busy, " + name + " didn't even have time to finish eating his"
                          + "\n" + food + ". He had to stay in detention until " + tod + ". Poor " + name + ".";
        
        System.out.println(madLibText);
        
    }

}
