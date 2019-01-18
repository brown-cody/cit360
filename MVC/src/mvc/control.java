
package mvc;


import mvc.model;

public class control {

    model modelDemo = new model();
    String op;

    public void getNumA(double var){
        modelDemo.numA = var;
    }
    
    public void getNumB(double var){
        modelDemo.numB = var;
    }
    
    public double runOp() {
        double opValue = 0;
        
        switch (op) {
            case "+":
                opValue = modelDemo.numA + modelDemo.numB;
                break;
            case "-":
                opValue = modelDemo.numA - modelDemo.numB;
                break;
            case "*":
                opValue = modelDemo.numA * modelDemo.numB;
                break;
            case "/":
                opValue = modelDemo.numA / modelDemo.numB;
                break;
        }
        
        return opValue;
    }
    
}
