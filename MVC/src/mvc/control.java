
package mvc;

import java.io.IOException;

public class control {
    
    view viewDemo = new view();
    model modelDemo = new model();
    String op;
    
    //runs from Main() and whenever operator is set
    public double runOp() throws java.io.IOException {
        double opValue = 0;
        if (op == null) {
            op = "nv10";
        }
        
        //chooses which math operation to perform based on operator chosen in View
        //cases access model functions to retrieve values
        switch (op) {
            case "+":
                opValue = modelDemo.getA() + modelDemo.getB();
                break;
            case "-":
                opValue = modelDemo.getA() - modelDemo.getB();
                break;
            case "*":
                opValue = modelDemo.getA() * modelDemo.getB();
                break;
            case "/":
                opValue = modelDemo.getA() / modelDemo.getB();
                break;
            //execution path if no valid operator is chosen, or if first run
            default:
                viewDemo.showDefaultView();
                break;
        }
        
        return opValue;
    }
    
    //run when first number input is entered
    public void inputA(double var){
        //accesses model function to set value
        modelDemo.setA(var);
    }
    
    //run when second number input is entered
    public void inputB(double var){
        //accesses model function to set value
        modelDemo.setB(var);
    }
    
    //run after execution complete
    public void runAgain(String answer) throws IOException {
            switch (answer) {
            //option to re-run showDefaultView() to restart application flow
            case "y":                                        
                viewDemo.showDefaultView();
                break;
            //option to call goodbye() to end execution
            case "n":                                        
                viewDemo.goodbye();
                break;
        }
    }
    
}
