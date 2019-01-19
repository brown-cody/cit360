
package mvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MVC {
    

    
    public static void main(String[] args) throws java.io.IOException {
         
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            control controlDemo = new control();
            
            System.out.println("Enter the first number: ");
            controlDemo.inputA(Integer.parseInt(br.readLine()));

            System.out.println("Enter the second number: ");
            controlDemo.inputB(Integer.parseInt(br.readLine()));

            System.out.println("Choose an operator: + - * /");
            controlDemo.op = br.readLine();

            System.out.println("The answer is: " + controlDemo.runOp());    
             
        }
}
