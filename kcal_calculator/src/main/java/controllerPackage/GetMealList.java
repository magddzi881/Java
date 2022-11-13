package controllerPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import modelPackage.DishDetailsModel;

/**  generate table/list of all meals, based on the text file */

public class GetMealList {

   
   /** 
    * @return Set
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
}
