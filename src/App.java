
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
  Scanner scanner = new Scanner(System.in);
        Colors color = new Colors();
        Calculator calculator = new Calculator();
       

        double number1;
        double number2=0;
        int operator;
        double result=0;
        double storage;
        
        ArrayList<String> history = new ArrayList<>();

        System.out.println(color.GREEN + "***********CALCULATOR*************"+ color.RESET);
        
       
        number1 = calculator.readDouble(scanner, "Enter the first number: ");
        storage= number1;

        do{
       
        printMenu();
        System.out.print(color.BLUE+"Enter your choice (1-9): "+color.RESET);
        operator= scanner.nextInt();
        
 
        System.out.println("\n-------------------------");
        System.out.printf("Current result: %.2f%n",storage);
        System.out.println("\n-------------------------");

        if (operator == 9) {
            System.out.println(color.YELLOW + "BYE! \nThanks for using the calculator " + color.RESET);
            scanner.close();
            return;
        }
    
        if (operator == 7) {
            history(history);
            continue; 
        }  
        
        if(operator==8){
        history.clear();
        System.out.println("History Cleared"); 
        number1 = calculator.readDouble(scanner, "Enter the first number: ");
        storage = number1;
        continue;
        }

        number2 = calculator.readDouble(scanner, "Enter the second number: ");

            try{
                String symbol = "";
        switch (operator) {
            case 1:
               result = calculator.add(storage,number2);
               symbol = "+";
               
                break;
                case 2:
                result = calculator.subtraction(storage,number2);

                symbol = "-";
                break;
                case 3:
                result =calculator.multiplication(storage,number2);
                symbol="*";

                break;
                case 4:
                result = calculator.division(storage,number2);
                symbol = "/";
                break;


                case 5:
                result = calculator.nthRoot(storage,number2);

                symbol = "sqrt";
                break;
                
                case 6:
                result = calculator.module(storage,number2);
                symbol = "%";
                break;

            default:
            throw new  IllegalArgumentException("Invalid Operator");
            
    
        }
        
        history.add(color.YELLOW+"Operation: " + storage + " "+ symbol +" " + number2 + " = " + result+ color.RESET);
        fileSave("Operation: " + storage + " "+ symbol +" " + number2 + " = " + result+ "\n");
        storage = result;
    }catch (IllegalArgumentException e) {
        System.out.println("It is NOT an operator");
        
    }catch (ArithmeticException ex) {
        System.out.println("Math error: " + ex.getMessage());
    }
    
    System.out.printf("RESULT:  %.2f", result);
    System.out.println();
    
}while(operator >=1 && operator<=8);
scanner.close();

}


    
    public static void history(ArrayList<String> history){

        if (history.isEmpty()) {
            System.out.println("No operations performed yet.");
        } else {
            for (String operation : history) {
                System.out.println(operation);
            }
      }}
    
    
    public static void fileSave(String result){
        try(FileWriter writer = new FileWriter(new File("resultOperation.txt"),true)){

            writer.write(result);


        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void printMenu(){
        System.out.println("Menu: ");
        System.out.println("1. + ");
        System.out.println("2. - ");
        System.out.println("3. * ");
        System.out.println("4. / ");
        System.out.println("5. sqrt ");
        System.out.println("6. % ");
        System.out.println("7. HISTORY");
        System.out.println("8. CLEAR");
        System.out.println("9. EXIT ");
    }
    }


    



    
    
    




