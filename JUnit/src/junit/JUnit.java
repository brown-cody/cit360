
package junit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class JUnit {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Calc calc = new Calc();
    
    public static void main(String[] args) throws IOException {
        menu();
    }
    
    public static void menu() throws IOException {

        
        System.out.println("\nWhich would you like to perform?");
        System.out.println("a - Add");
        System.out.println("s - Subtract");
        System.out.println("m - Multiply");
        System.out.println("d - Divide");
        System.out.println("r - Square Root");
        System.out.println("x - Power");
        System.out.println("c - Find Circumference");
        System.out.println("p - Find Area of a Circle");
        System.out.println("n - Is it a Prime Number");
        System.out.println("q - Quit");
        
        String choice = br.readLine();
        
        switch (choice) {
            case "a":
                menuTwoInput("add");
                break;
            case "s":
                menuTwoInput("subtract");
                break;
            case "m":
                menuTwoInput("multiply");
                break;
            case "d":
                menuTwoInput("divide");
                break;
            case "r":
                menuOneInput("find the square root", "number");
                break;
            case "x":
                menuTwoInput("find the power");
                break;
            case "c":
                menuOneInput("find the circumference", "radius");
                break;                
            case "p":
                menuOneInput("find the area of a circle", "radius");
                break;
            case "n":
                menuOneInput("see if its a prime", "number");
                break;
            case "q":
                break;
                
        }
    }
    
    public static void menuTwoInput(String operation) throws IOException {
        System.out.println("\nLet's " + operation + "!");
        System.out.println("Enter the first number: ");
        double inputA = Integer.parseInt(br.readLine());
        
        System.out.println("Enter the second number: ");
        double inputB = Double.parseDouble(br.readLine());
        
        double output = 0;
        
        switch (operation) {
            case "add":
                output = calc.add(inputA, inputB);
                break;
            case "subtract":
                output = calc.subtract(inputA, inputB);
                break;
            case "multiply":
                output = calc.multiply(inputA, inputB);
                break;
            case "divide":
                output = calc.divide(inputA, inputB);
                break;
            case "find the power":
                output = calc.pwr(inputA, inputB);
                break;
        }

        System.out.println("\nThe answer is: " + output);
        
        menu();
    }
    
    public static void menuOneInput(String operation, String type) throws IOException {
        System.out.println("\nLet's " + operation + "!");
        System.out.println("Enter the " + type + ": ");
        double input = Double.parseDouble(br.readLine());
        String outputMessage = null;
        
        switch (operation) {
            case "find the circumference":
                outputMessage = calc.circumference(input) + "";
                break;
            case "find the area of a circle":
                outputMessage = calc.areaOfCircle(input) + "";
                break;
            case "find the square root":
                outputMessage = calc.sqrt(input) + "";
                break;
            case "see if its a prime":
                int intInput = (int) Math.round(input);
                outputMessage = calc.isPrime(intInput) + "";
                break;
        }

        System.out.println("\nThe answer is: " + outputMessage);
        
        menu();
    }
}
