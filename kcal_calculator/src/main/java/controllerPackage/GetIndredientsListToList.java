package controllerPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import modelPackage.IngredientModel;

/**  class returns list of all ingredients, based on the text file */
public class GetIndredientsListToList {
     /** 
    * @return List
    */
    /**  returns list of all ingredients, based on the text file */
   public List<IngredientModel> getIndredientsListToList() {

    List<IngredientModel> list = new ArrayList<IngredientModel>();

    try {
      
       List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));

       String line = " ";

       for (int i = 1; i < allLines.size(); i++) {

          line = allLines.get(i);
          String[] splitedTextLine = line.split(": "); // method used to distinguish the data in the file
          String dishName = splitedTextLine[0];
          String[] secondSplit = splitedTextLine[1].split(" ");
          System.out.print(dishName+": ");
         for(int k =0; k< secondSplit.length; k++){
            String[] d = secondSplit[k].split("-");
            String name = d[0];
            String quantityAString = d[1];
           System.out.print(name +" (" + quantityAString +")" + " ");
         }
          System.out.println();
          
        

        

       }

    } catch (IOException e) {

       e.printStackTrace();
    }

    return list;
 }
}
