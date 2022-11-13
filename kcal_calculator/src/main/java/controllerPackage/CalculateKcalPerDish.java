package controllerPackage;

import java.util.Scanner;

import  viewPackage.MenuTexts;
import  viewPackage.DisplayMealList;

/** method used to calculate total meal calories */

public class CalculateKcalPerDish {

    /** method used to calculate total meal calories */
    public void calculateTotalCalories() {

        int i = -1;
        int totalKcal = 0;

        GetMealList getMealList = new GetMealList();
        CompareNameFromDishListAndReturnId compareNameFromDishListAndReturnId = new CompareNameFromDishListAndReturnId();
        CreateNewDish createNewDish = new CreateNewDish();
        DisplayMealList displayMealList = new DisplayMealList();
        MenuTexts calculatorMenu = new MenuTexts();
        GetOneMealKcalData getOneMealKcalData = new GetOneMealKcalData();

        displayMealList.displayMealList();

        while (i != 0) {

            calculatorMenu.calculatorMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Option: ");
            int option = scanner.nextInt();

            switch (option) {
                
                case 1: {

                    int mealId = compareNameFromDishListAndReturnId
                            .compareNameFromDishListAndReturnId(getMealList.getMealList());

                    if (mealId == 0) {
                        i = -1;
                    } else {

                        totalKcal = totalKcal + getOneMealKcalData.getOneMealKcalData(mealId); // add new kcal data to
                                                                                               // result

                    }
                }
                    break;
                case 2: {
                    createNewDish.createNewDish(); // add new dish to the main list and text file
                }
                    break;
                case 3: {
                    System.out.println(totalKcal + "kcal"); // display total kcal result
                    i = 0;
                }
                    break;
                default:
                    i = -1;

            }

        }

    }
}
