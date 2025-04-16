import java.util.Scanner;


public class Calculator {

        public  double add(double number1,double number2){
        return number1+number2;
    }

    public  double subtraction(double number1,double number2){
        return number1-number2;
    }

    public  double multiplication(double number1,double number2){
        return number1*number2;
    }

    public  double division(double number1,double number2) throws ArithmeticException{
    if (number2 == 0){
        throw new ArithmeticException("Cannot divide by zero");
    }
    return number1/number2;
      }       
    
    public  double nthRoot(double number1, double number2){
            if (number2 == 0) throw new ArithmeticException("Root cannot be 0");
            if (number1 < 0 && number2 % 2 == 0) throw new ArithmeticException("Cannot take even root of a negative number");
            return Math.pow(number1, 1.0 / number2);
        }
        
    
    public  double readDouble(Scanner scanner, String message){
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid number. Try again:");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }


    public  double module(double number1,double number2) throws ArithmeticException{
        if(number2 == 0){
            throw new ArithmeticException("CANNOT divide by zero");
        }else{
        return number1%number2;}
        }
    
    
}
