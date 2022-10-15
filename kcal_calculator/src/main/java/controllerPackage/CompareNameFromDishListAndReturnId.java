package controllerPackage;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import modelPackage.DishDetailsModel;

// the class is used to search for dishes in a list using their names 

public class CompareNameFromDishListAndReturnId {

    
    /** 
     * @param dishDetailsList
     * @return Integer
     */
    public Integer compareNameFromDishListAndReturnId(List<DishDetailsModel> dishDetailsList) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter meal name: ");
        String inputMealName = scan.nextLine();

        List<String> namesFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getName)
                .collect(Collectors.toList());

        int result = 0;

        for (int i = 0; i < dishDetailsList.size(); i++) {

            String mealName = namesFromDishDetailList.get(i);

            if (mealName.compareTo(inputMealName) == 0) {

                result = dishDetailsList.get(i).getId(); // a dish that is exactly the same as the one entered by
                                                         // the user

            }

        }

        if (result == 0) {
            System.out.println("Not on the list");
        }

        return result;

    }

}
