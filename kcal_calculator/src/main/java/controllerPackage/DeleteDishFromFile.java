package controllerPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import modelPackage.DishDetailsModel;

/**  delete dish from text file */

public class DeleteDishFromFile {

    /**  delete dish from text file */
    public void deleteDishFromFile() {

        CompareNameFromDishListAndReturnId compareNameFromDishListAndReturnId = new CompareNameFromDishListAndReturnId();
        GetMealList getMealList = new GetMealList();

        List<DishDetailsModel> dishDetailsList = getMealList.getMealListToList();

        System.out.println("Enter the name of the meal to be deleted: ");
        int id = compareNameFromDishListAndReturnId.compareNameFromDishListAndReturnId(getMealList.getMealList());

        List<String> namesFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getName)
                .collect(Collectors.toList());
        List<Integer> kcalFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getKcal)
                .collect(Collectors.toList());

        if (id > 0) {

            
            dishDetailsList.remove(id-1);

            try {
                
                FileWriter myWriter = new FileWriter("dishes.txt");

                myWriter.write("List of Meals/Indigrients kcal per 100g: \n");

    
    for (int i = 0; i < dishDetailsList.size(); i++) {
        myWriter.write(
                (i + 1) + " " + namesFromDishDetailList.get(i) + " " + kcalFromDishDetailList.get(i)
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
