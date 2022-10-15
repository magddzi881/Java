package controllerPackage;

import java.util.Scanner;


// use class to temporarily suspend the display of the main menu

public class PressToContinue {

    Scanner scan = new Scanner(System.in);

    public void pressAnyKeyToContinue() {

        System.out.print("Press any key to continue . . . ");
        scan.nextLine();

    }

}
