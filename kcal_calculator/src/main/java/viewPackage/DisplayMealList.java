package viewPackage;

import java.util.Set;
import java.util.function.Consumer;

import controllerPackage.GetMealList;
import modelPackage.DishDetailsModel;


/** display dish list on screen */
public class DisplayMealList {

    
   

     /**function that displays main meal list */
    public void displayMealList() {

        GetMealList getMealList = new GetMealList();
        Set<DishDetailsModel> dishDetailsList = getMealList.getMealList();

        System.out.println("===========================");
        
        //lambda
        Consumer<? super DishDetailsModel> dishConsumer = dish ->
     {
        System.out.print(dish.getId() + " ");
        System.out.print(dish.getName() + " ");
        System.out.print(dish.getKcal() + " \n");
     };
        dishDetailsList.forEach(dishConsumer);
      
        System.out.println("===========================");

        

    }
}
