
package junit;

public class Calc {
    
    
    double add(double inputA, double inputB) {
        double result = inputA + inputB;
        return result;
    }
    
    double subtract(double inputA, double inputB) {
        double result = inputA - inputB;
        return result;
    }

    double multiply(double inputA, double inputB) {
        double result = inputA * inputB;
        return result;
    }
    
    double divide(double inputA, double inputB) {
        double result = inputA / inputB;
        return result;
    }
    
    double sqrt(double input) {
        double result = Math.sqrt(input);
        return result;
    }
    
    int pwr(double inputA, double inputB) {
        double result = Math.pow(inputA, inputB);
        int intResult = (int) Math.floor(result);
        return intResult;
    }
    
    double circumference(double radius) {
        double result = radius * 2 * Math.PI;
        result = Math.round(result * 100);
        return result / 100;
    }
    
    double areaOfCircle(double radius) {
        double result = Math.PI * Math.pow(radius, 2);
        result = Math.round(result * 100);
        return result / 100;
    }
    
    boolean isPrime(int input) {
        boolean flag = true;
        
        for(int i = 2; i <= input/2; ++i){
            if(input % i == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
    
    String isMathHard(int input) {
        if (input == 0) {
            return null;
        } else {
            return "Math is hard sometimes";
        }
        
    }
    
    int[] arrayBuilder(int inputA, int inputB, int inputC, int inputD) {
        int[] intArray = new int[]{inputA,inputB,inputC,inputD};
        return intArray;
    }
    
}
