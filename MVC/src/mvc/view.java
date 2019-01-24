
package mvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class view {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //sequential entering of user values, including operator, which is used to determine application flow in control
    public void showDefaultView() throws java.io.IOException {
        control controlDemo = new control();

        System.out.println("Enter the first number: ");
        controlDemo.inputA(Integer.parseInt(br.readLine()));

        System.out.println("Enter the second number: ");
        controlDemo.inputB(Integer.parseInt(br.readLine()));

        System.out.println("Choose an operator: + - * /");
        controlDemo.op = br.readLine();

        System.out.println("The answer is: " + controlDemo.runOp());
        
        showMenuView();
    }
    
    //runs after completion of showDefaultView() provides user interaction to run again
    public void showMenuView () throws java.io.IOException {
        control controlDemo = new control();
        
        System.out.println("Run again? (y/n)");
        controlDemo.runAgain(br.readLine());
        
    }
    
    //ends execution without additional functions. flow returns back to Main() with nothing left to run.
    public void goodbye() {
        System.out.println("Goodbye!");
    }
    
}
