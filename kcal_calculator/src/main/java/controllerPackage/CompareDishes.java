package controllerPackage;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import modelPackage.DishDetailsModel;


/** 
     * the class is used to search for dishes in a list using their names 
     * 
*/
public class CompareDishes {

     /** 
     *  
     * @param dishDetailsList
     * @return 
     */
    /** 
     * the class is used to search for dishes in a list using their names 
     * 
*/

public DishDetailsModel compareNameFromDishList(Set<DishDetailsModel> dishDetailsList) {

        
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter meal name: ");
    String inputMealName = scan.nextLine();

    List<String> namesFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getName)
            .collect(Collectors.toList());
    List<Integer> idsFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getId)
            .collect(Collectors.toList());
    List<Integer> kcalFromDishDetailList = dishDetailsList.stream().map(DishDetailsModel::getKcal)
            .collect(Collectors.toList());


            DishDetailsModel result = new DishDetailsModel(null, "", null);
   

    for (int i = 0; i < dishDetailsList.size(); i++) {
    String mealName = namesFromDishDetailList.get(i);

    if (mealName.compareTo(inputMealName) == 0) {

         // a dish that is exactly the same as the one entered by the user
      result.setId(idsFromDishDetailList.get(i));
      result.setName(namesFromDishDetailList.get(i));
      result.setKcal(kcalFromDishDetailList.get(i));

     }

    }

    if (result == new DishDetailsModel(null, null, null)) {
        System.out.println("Not on the list");
    }

    return result;

}

    
}




