
package mvc;

public class control {

    model modelDemo = new model();
    String op;

    public void inputA(double var){
        modelDemo.setA(var);
    }
    
    public void inputB(double var){
        modelDemo.setB(var);
    }
    
    public double runOp() {
        double opValue = 0;
        
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
        }
        
        return opValue;
    }
    
}
