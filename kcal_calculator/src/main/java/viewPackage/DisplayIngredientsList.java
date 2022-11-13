package viewPackage;
import java.util.List;

import controllerPackage.GetIndredientsListToList;
import modelPackage.IngredientModel;



/** display ingredients list on screen */
public class DisplayIngredientsList {
    /** 
     * @return List
     */

     /**function that displays main ingredients list */
     public List<IngredientModel> displayIngredientsList() {

        GetIndredientsListToList getIndredientsListToList = new GetIndredientsListToList();
        List<IngredientModel> list = getIndredientsListToList.getIndredientsListToList();

        System.out.println("===========================");

        //foreach
        for (IngredientModel dishDetailsModel : list) {

            System.out.print(dishDetailsModel.getName() + " ");
            System.out.print(dishDetailsModel.getQuantity() + " \n");
    
        }
      
        System.out.println("===========================");

        return list;

    }
   
    
}





