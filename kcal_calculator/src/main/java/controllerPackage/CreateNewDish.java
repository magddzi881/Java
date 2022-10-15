package controllerPackage;

import java.util.Scanner;

// method used to take user input data

public class CreateNewDish {
    public void createNewDish() {

        Scanner scannerDish = new Scanner(System.in);
        System.out.print("Name: ");
        String newName = scannerDish.nextLine();
        System.out.print("Kilocalories per 100g: ");
        int newKcal = scannerDish.nextInt();

        AddNewDishToFile addNewDishToFile = new AddNewDishToFile();
        addNewDishToFile.addNewDishToFile(newName, newKcal);

    }

}
