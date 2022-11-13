package pl.polsl.Controller;

import pl.polsl.Model.DishDetailsModel;
import pl.polsl.Model.IngredientModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**class used to generate list or/and set of data from text file
 * @author Magdalena Dziubosz
 */
public class GetMealList {
    /** 
    * @return List
    */
   /**  returns collection of all meals, based on the text file */
   public Set<DishDetailsModel> getMealList() {

      Set<DishDetailsModel> dishDetailsList = new LinkedHashSet<DishDetailsModel>();
      
      try {
        
         List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));

         String line = " ";

         for (int i = 1; i < allLines.size(); i++) {

            line = allLines.get(i);
            String[] splitedTextLine = line.split(" "); // method used to distinguish the data in the file
            String idAsString = splitedTextLine[0];
            String name = splitedTextLine[1];
            String kcalAsString = splitedTextLine[2];

            int id = Integer.parseInt(idAsString);
            int kcal = Integer.parseInt(kcalAsString);

            dishDetailsList.add(new DishDetailsModel(id, name, kcal));

         }

      } catch (IOException e) {

         e.printStackTrace();
      }

      return dishDetailsList;
   }

   
    /** 
    * @return List
    */
    /**  returns list of all meals, based on the text file */
   public List<DishDetailsModel> getMealListToList() {

    List<DishDetailsModel> dishDetailsList = new ArrayList<DishDetailsModel>();

    try {
      
       
       List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));

       String line = " ";

       for (int i = 1; i < allLines.size(); i++) {

          line = allLines.get(i);
          String[] splitedTextLine = line.split(" "); // method used to distinguish the data in the file
          String idAsString = splitedTextLine[0];
          String name = splitedTextLine[1];
          String kcalAsString = splitedTextLine[2];

          int id = Integer.parseInt(idAsString);
          int kcal = Integer.parseInt(kcalAsString);

          dishDetailsList.add(new DishDetailsModel(id, name, kcal));

       }

    } catch (IOException e) {

       e.printStackTrace();
    }

    return dishDetailsList;
 }

  /** 
    * @return List
    */
    /**  returns list of all ingredients, based on the text file */
    public List<IngredientModel> getIndredientsListToList(DishDetailsModel model) {

        
        List<IngredientModel> list = new ArrayList<IngredientModel>();
    
        try {
          
           List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));
    
           String line = " ";
    
           for (int i = 1; i < allLines.size(); i++) {
    
              line = allLines.get(i);
              String[] splitedTextLine = line.split(": "); // method used to distinguish the data in the file
              String dishName = splitedTextLine[0];
              String[] secondSplit = splitedTextLine[1].split(" ");
             
            if(dishName.compareTo(model.getName())==0){
                for(int k =0; k< secondSplit.length; k++){
                    String[] d = secondSplit[k].split("-");
                    String name = d[0];
                    String quantityAString = d[1];
                   
                   int q = Integer.parseInt(quantityAString);
                 list.add(new IngredientModel(name, q));
                 }
            }

             
             
              
              
           }
    
        } catch (IOException e) {
    
           e.printStackTrace();
        }
    
        return list;
     }
}
