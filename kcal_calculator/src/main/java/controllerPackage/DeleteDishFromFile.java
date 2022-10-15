package controllerPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelPackage.DishDetailsModel;

// delete dish from text file

public class DeleteDishFromFile {

    public void deleteDishFromFile() {

        CompareNameFromDishListAndReturnId compareNameFromDishListAndReturnId = new CompareNameFromDishListAndReturnId();
        GetMealList getMealList = new GetMealList();

        List<DishDetailsModel> dishDetailsList = getMealList.getMealList();

        System.out.println("Enter the name of the meal to be deleted: ");
        int id = compareNameFromDishListAndReturnId.compareNameFromDishListAndReturnId(getMealList.getMealList());

        if (id > 0) {

            dishDetailsList.remove(id - 1);

            try {
                
                FileWriter myWriter = new FileWriter("dishes.txt");

                myWriter.write("List of Meals/Indigrients kcal per 100g: \n");

                for (int i = 0; i < dishDetailsList.size(); i++) {
                    myWriter.write(
                            (i + 1) + " " + dishDetailsList.get(i).getName() + " " + dishDetailsList.get(i).getKcal()
                                    + "\n");
                }

                myWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("The dish has not been removed");
        }

    }

}
