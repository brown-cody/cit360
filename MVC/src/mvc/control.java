
package mvc;

import java.io.IOException;

public class control {
    
    view viewDemo = new view();
    model modelDemo = new model();
    String op;

    public void inputA(double var){
        modelDemo.setA(var);
    }
    
    public void inputB(double var){
        modelDemo.setB(var);
    }
    
    public void setup() {
        
    }
    
    public double runOp() throws java.io.IOException {
        double opValue = 0;
        if (op == null) {
            op = "nv10";
        }
        
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
            default:
                viewDemo.showDefaultView();
                break;
        }
        
        return opValue;
    }
    
    public void runAgain(String answer) throws IOException {
            switch (answer) {
            case "y":
                viewDemo.showDefaultView();
                break;
            case "n":
                viewDemo.goodbye();
                break;
        }
    }
    
}
