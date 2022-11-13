import java.util.Scanner;

import viewPackage.MainMenu;
import viewPackage.MenuTexts;

/**
 *  To run application correctly enter two parameters, first one is '-f' flag
 *   and the second one is from a text file 'dishes.txt'.
 *    Correct example: 'java Kcal_calculator -f dishes.txt'
 *   Additionally enter one parameter '-h' to get help and this instruction
 *  or parameter '-e' to exit.
 * 
 * 
 * 
 * @author Magdalena_Dziubosz
 * @version 11
 * @since 2022-10-10
 */

public class Kcal_calculator {

   
  /** 
   * 
   * @param args
   */

   /** main program method */
  public static void main(String[] args) {

    MainMenu menu = new MainMenu(); // main application interface
    MenuTexts displayMessage = new MenuTexts();
    Kcal_calculator helperFunction = new Kcal_calculator();

    if (args.length != 0 && args[0].compareTo("-h") == 0) {displayMessage.displayHelpInfo(); helperFunction.setArguments();}
    else if (args.length == 2 && args[0].compareTo("-f") == 0 && args[1].compareTo("dishes.txt") == 0) menu.mainMenu();
    else if (args.length != 0 && args[0].compareTo("-e") == 0) {System.out.println("Application closed");}
    else {displayMessage.displayParametersError(); helperFunction.setArguments();} 
    
    }

    /** if no parameters were entered when starting the application this method will set them */
    public void setArguments() { 

       MenuTexts displayMessage = new MenuTexts();
      
       int i = -1;
       while(i != 0){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter arguments: ");
        String enteredText = scan.nextLine();
        String[] args = enteredText.split(" ");
  
        if(args.length == 1 && args[0].compareTo("-h") == 0) {displayMessage.displayHelpInfo(); Kcal_calculator.main(args);};
        if(args.length == 1 && args[0].compareTo("-e") == 0) {System.out.println("Exit"); i = 0;}
        if(args.length == 2) {Kcal_calculator.main(args); i = 0;}
      
  
        else displayMessage.displayParametersError();

      }
      
    }

}
