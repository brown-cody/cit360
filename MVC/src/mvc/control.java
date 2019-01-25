
package mvc;

import java.io.IOException;

public class control {
    
    view viewDemo = new view();
    model modelDemo = new model();
    private String op;
    private double answer;
    private String repeat;
    
    public void setup() throws IOException {
        viewDemo.showDefaultView();
        sendToModel();
        runOp();
        viewDemo.showAnswerView(answer);
        runAgain();
    }
    
    //run when first number input is entered
    public void sendToModel(){
        //accesses model function to set value
        modelDemo.setA(viewDemo.getInputA());
        modelDemo.setB(viewDemo.getInputB());
        op = viewDemo.getOp();

    }
    
    //runs from Main() and whenever operator is set
    public void runOp() throws java.io.IOException {
                
        //chooses which math operation to perform based on operator chosen in View
        //cases access model functions to retrieve values
        switch (op) {
            case "+":
                answer = modelDemo.getA() + modelDemo.getB();
                break;
            case "-":
                answer = modelDemo.getA() - modelDemo.getB();
                break;
            case "*":
                answer = modelDemo.getA() * modelDemo.getB();
                break;
            case "/":
                answer = modelDemo.getA() / modelDemo.getB();
                break;
            //execution path if no valid operator is chosen, or if first run
        }
        
    }
    
    //run after execution complete
    public void runAgain() throws IOException {
            repeat = viewDemo.showMenuView();
            switch (repeat) {
            //option to re-run showDefaultView() to restart application flow
            case "y":                                        
                setup();
                break;
            //option to call goodbye() to end execution
            case "n":                                        
                viewDemo.goodbye();
                break;
        }
    }
    
}
