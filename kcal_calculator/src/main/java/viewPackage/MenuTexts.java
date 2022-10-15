package  viewPackage;

//console menu texts

public class MenuTexts {

    public void mainMenuText() {

        System.out.println("===========================");
        System.out.println("Kilocalories calculator");
        System.out.println("===========================");
        System.out.println("1. Calculate total meal calories");
        System.out.println("2. Add new dish to the list");
        System.out.println("3. Display meal list");
        System.out.println("4. Calculate the daily caloric requirement");
        System.out.println("5. Remove dish from list");
        System.out.println("0. Exit");
        System.out.println("===========================");

    }

    public void calculatorMenu() {

        System.out.println("===========================");
        System.out.println("1. Enter the new item");
        System.out.println("2. Create new dish and add it to the list");
        System.out.println("3. Done, calculate");
        System.out.println("===========================");

    };

    public void recommendedKcalMenu() {

        System.out.println("===========================");
        System.out.println("Choose gender:");
        System.out.println("1. Woman");
        System.out.println("2. Man");
        System.out.println("3. Exit");
        System.out.println("===========================");

    }

    public void displayParametersError() {

        System.out.println("=================================================================================");
        System.out.println("Syntax error:");
        System.out.println("Run application with '-h' for help, '-e' to exit");
        System.out.println("=================================================================================");

    }

    public void displayHelpInfo() {

        System.out.println("=================================================================================");
        System.out.println("To run the application, enter two parameters");
        System.out.println("the flag '-f' for file");
        System.out.println("and the name of the text file with dishes ('dishes.txt').");
        System.out.println("Example: java Kcal_calc -f dishes.txt");
        System.out.println("=================================================================================");

    }

}
