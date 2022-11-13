package controllerPackage;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import modelPackage.DishDetailsModel;
import modelPackage.NameException;

/** class used to take user input data */

public class CreateNewDish {

    /** method used to take user input data */
    public void createNewDish() {

        try {

            Scanner scannerDish = new Scanner(System.in);
            System.out.print("Name: ");
            String newName = scannerDish.nextLine();
            GetMealList getMealList = new GetMealList();
            Set<DishDetailsModel> list = getMealList.getMealList();
        
            List<String> namesFromList = list.stream().map(DishDetailsModel::getName)
                        .collect(Collectors.toList());
        
            String testName = newName;
            String result = "";
        
            for(int i = 0; i< namesFromList.size(); i++){
                if(namesFromList.get(i).compareTo(testName)==0){result = testName;}
            }
            if(result == testName){

                throw new NameException("Dish name is already taken");
         
            }
            else{  

                System.out.print("Kilocalories per 100g: ");
                int newKcal = scannerDish.nextInt();
 
                AddNewDishToFile addNewDishToFile = new AddNewDishToFile();
                addNewDishToFile.addNewDishToFile(newName, newKcal);
            
                }

     } catch (NameException e) {
       e.printStackTrace();
     }

    }

}
