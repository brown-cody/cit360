
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
    
    //retrieve inputs from view and send to model
    //retrieve operator from view and save locally
    public void sendToModel(){
        //accesses model function to set value
        modelDemo.setA(viewDemo.getInputA());
        modelDemo.setB(viewDemo.getInputB());
        op = viewDemo.getOp();

    }
    
    //chooses math operation based on operator chosen
    //access data from model getters
    public void runOp() throws java.io.IOException {
                
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
        }
        
    }
    
    //prompt for another run
    public void runAgain() throws IOException {
            repeat = viewDemo.showMenuView();
            switch (repeat) {
            //option to re-start application flow
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
