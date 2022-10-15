package viewPackage;

import java.util.List;

import controllerPackage.GetMealList;
import modelPackage.DishDetailsModel;

//display dish list on screen

public class DisplayMealList {

    
    /** 
     * @return List
     */
    public List<DishDetailsModel> displayMealList() {

        GetMealList getMealList = new GetMealList();
        List<DishDetailsModel> dishDetailsList = getMealList.getMealList();

        System.out.println("===========================");

        for (int i = 0; i < dishDetailsList.size(); i++) {
            System.out.print(dishDetailsList.get(i).getId() + " ");
            System.out.print(dishDetailsList.get(i).getName() + " ");
            System.out.print(dishDetailsList.get(i).getKcal() + " \n");
        }

        System.out.println("===========================");

        return dishDetailsList;

    }
}
