package pl.polsl.Model;

import pl.polsl.Controller.GetMealList;

import java.util.List;
/**@author Magdalena Dziubosz
 * returns list of dishes based on text file
 */
public class DishList {

    private final List<DishDetailsModel> data;
    GetMealList getMealList = new GetMealList();
    
    public DishList() {
        data = getMealList.getMealListToList();
    }   

    
    /** 
     * method used to get meals data based on text file
     * @return List
     */
    public List<DishDetailsModel> getData() {
        return data;
    }
    
}
