package viewPackage;

import java.util.Scanner;

// main application interface, calls most of the program's functions

import controllerPackage.CalculateKcalPerDish;
import controllerPackage.CreateNewDish;
import controllerPackage.DeleteDishFromFile;
import controllerPackage.PressToContinue;
import controllerPackage.RecommendedTotalCaloriesPerPerson;

public class MainMenu {

  public void mainMenu() {

    PressToContinue pressAnyKeyToContinue = new PressToContinue();
    CalculateKcalPerDish calculateTotalCalories = new CalculateKcalPerDish();
    CreateNewDish createNewDish = new CreateNewDish();
    DisplayMealList displayMealList = new DisplayMealList();
    RecommendedTotalCaloriesPerPerson recommendedTotalCaloriesPerPerson = new RecommendedTotalCaloriesPerPerson();
    MenuTexts mainMenuText = new MenuTexts();
    DeleteDishFromFile deleteDishFromFile = new DeleteDishFromFile();
    
    int i = -1;
    while (i != 0) {

      mainMenuText.mainMenuText();

      Scanner scan = new Scanner(System.in);
      System.out.print("Option: ");
      int option = scan.nextInt();

      switch (option) {

        case 0:
          i = 0;
          break;
        case 1:
          calculateTotalCalories.calculateTotalCalories();
          pressAnyKeyToContinue.pressAnyKeyToContinue();
          break;
        case 2:
          createNewDish.createNewDish();
          pressAnyKeyToContinue.pressAnyKeyToContinue();
          break;
        case 3:
          displayMealList.displayMealList();
          pressAnyKeyToContinue.pressAnyKeyToContinue();
          break;
        case 4:
          recommendedTotalCaloriesPerPerson.recommendedTotalCaloriesPerPerson();
          pressAnyKeyToContinue.pressAnyKeyToContinue();
          break;
        case 5:
          deleteDishFromFile.deleteDishFromFile();
          pressAnyKeyToContinue.pressAnyKeyToContinue();
          break;
        default:
          i = -1;

      }

    }
  }
}
