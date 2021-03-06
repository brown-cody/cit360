
package mvc;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class view {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private int inputA;
    private int inputB;
    private String op;
    
    //sequential entering of user values, including operator, which is used to determine application flow in control
    public void showDefaultView() throws java.io.IOException {

        System.out.println("Enter the first number: ");
        inputA = Integer.parseInt(br.readLine());

        System.out.println("Enter the second number: ");
        inputB = Integer.parseInt(br.readLine());

        System.out.println("Choose an operator: + - * /");
        op = br.readLine();

    }
    
    //outputs answer to user
    public void showAnswerView(double answer) {
        System.out.println("The answer is: " + answer);
    }
    
    //provides user interaction to run again
    public String showMenuView () throws java.io.IOException {
        
        System.out.println("Run again? (y/n)");
        return br.readLine();
        
    }
    
    //getter for inputA
    public int getInputA() {
        return inputA;
    }

    //getter for inputB
    public int getInputB() {
        return inputB;
    }

    //getter for op
    public String getOp() {
        return op;
    }
    
    //ends execution without additional functions. flow returns back to Main() with nothing left to run.
    public void goodbye() {
        System.out.println("Goodbye!");
    }
    
}
