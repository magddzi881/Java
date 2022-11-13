package controllerPackage;

import java.text.DecimalFormat;
import java.util.Scanner;

import viewPackage.MenuTexts;

/**
 Used formulas:
 For women, BMR = 655.1 + (9.563 x weight in kg) + (1.850 x height in cm) - (4.676 x age in years)
 For men, BMR = 66.47 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.755 x age in years)
*/

public class RecommendedTotalCaloriesPerPerson {

    // woman constants
    final private double constantWomenValue = 655.1;
    final private double constantWomenWeightValue = 9.563;
    final private double constantWomenHeightValue = 1.850;
    final private double constantWomenAgeValue = 4.676;

    // man constants
    final private double constantMenValue = 66.47;
    final private double constantMenWeightValue = 13.75;
    final private double constantMenHeightValue = 5.003;
    final private double constantMenAgeValue = 6.755;

    private double weight; // weight in kg
    private double height; // height in cm
    private int age; // age in years

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00"); // format for total calories

    /** a calculator for recommended total calories per person */
    public void recommendedTotalCaloriesPerPerson() {

        MenuTexts recommendedKcalMenu = new MenuTexts();

        int option = -1;
        while (option != 0) {

            Scanner scanner = new Scanner(System.in);
            recommendedKcalMenu.recommendedKcalMenu();
            System.out.print("Gender: \n");
            int menuChoice = scanner.nextInt();

            Scanner scan = new Scanner(System.in);
            System.out.print("Add your weight in kg ex.(70.5): \n");
            weight = scan.nextInt();
            System.out.print("Add your height in cm ex.(175): \n");
            height = scan.nextInt();
            System.out.print("Add your age in years ex.(32): \n");
            age = scan.nextInt();

            double totalCalories = 0;

            switch (menuChoice) {
                case 1: {
                    totalCalories = constantWomenValue + (weight * constantWomenWeightValue)
                            + (height * constantWomenHeightValue)
                            - (age * constantWomenAgeValue);
                    System.out.println("Your recommended total calories per day: " + decimalFormat.format(totalCalories) + "kcal");
                    option = 0;
                }
                    break;
                case 2: {
                    totalCalories = constantMenValue + (weight * constantMenWeightValue)
                            + (height * constantMenHeightValue)
                            - (age * constantMenAgeValue);

                    System.out.println("Your recommended total calories per day: " + decimalFormat.format(totalCalories) + "kcal");
                    option = 0;
                }
                    break;
                case 3:
                    option = 0;
                    break;
                default:
                    option = -1;
            }

        }

    }
    
}
