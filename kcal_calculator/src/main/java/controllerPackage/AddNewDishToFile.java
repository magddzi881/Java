package controllerPackage;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import  modelPackage.KcalException;
import modelPackage.Number;

/** class used to write a new line of data to a text file */ 

public class AddNewDishToFile {

    /** 
     * @param newName
     * @param newKcal
     */
    /** method used to write a new line of data to a text file */ 
    public void addNewDishToFile(String newName, int newKcal) {
        
        
            if (isPositiveNumer(newKcal) != Number.POSITIVE) {
               
                    try {

                        throw new KcalException("Kilocalories must be entered as a positive number");

                    } catch (KcalException e) {
                        e.printStackTrace();
                    }
                
            } else {

                try {

                    List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));
                    FileWriter myWriter = new FileWriter("dishes.txt");

            
        
                    //foreach
                    for (String line : allLines) {

                        myWriter.write(line + "\n");

                    }

                    int newId = allLines.size(); // create id for new item

                    myWriter.write(newId + " " + newName + " " + newKcal + "\n");
                    myWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
       

    }
/** method used to check if a number is positive */
public Number isPositiveNumer(int number){
    Number newResult;
     
    if (number > 0) {
   newResult = Number.POSITIVE;
  } else if (number < 0) {
   newResult = Number.NEGATIVE;
  } else 
   newResult = Number.ZERO;

   return newResult;

}
    
}
