
package mvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class view {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
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
    
    public void showMenuView () throws java.io.IOException {
        control controlDemo = new control();
        String answer;
        
        System.out.println("Run again? (y/n)");
        answer = br.readLine();
        controlDemo.runAgain(answer);
        
    }
    
    public void goodbye() {
        System.out.println("Goodbye!");
    }
    
}
