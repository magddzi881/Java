package controllerPackage;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import modelPackage.DishDetailsModel;
import modelPackage.IngredientModel;
import viewPackage.DisplayIngredientsList;

/** class used to add ingredients to complicated meals */
public class IngredientsSet {

    /** method used to add ingredients to complicated meals */
public void ingredientsSet(){

    DisplayIngredientsList displayList = new DisplayIngredientsList();
    CompareDishes compareDishes = new CompareDishes();
    GetMealList getMealList = new GetMealList();



displayList.displayIngredientsList();

System.out.println("1. Add new ingrediens");
System.out.println("0. Exit");
Scanner scan = new Scanner(System.in);
int option = scan.nextInt();


if(option == 1){
    DishDetailsModel model = compareDishes.compareNameFromDishList(getMealList.getMealList());
    
    if(model.getName().isEmpty()){System.out.println("Dish not on the main list");}
else{

try {

   List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));
   FileWriter myWriter = new FileWriter("ingredients.txt");
   int exit = -1;
   String line = "";
   String dishName = "";
   int onTheList = -1;

   for(int i = 0; i< allLines.size(); i++){

    line = allLines.get(i);
    String[] splitedTextLine = line.split(": "); // method used to distinguish the data in the file
    dishName = splitedTextLine[0];

    if(dishName.compareTo(model.getName() ) ==0)
        {onTheList = 0; }
   }

  

   if(onTheList != 0){

    List<String> names = model.namesFromSet(model);
    List<Integer> quantity = model.quantityFromSet(model);

    while(exit != 0){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter quantity: "); 
        int newQuantity = scanner.nextInt();
        
        IngredientModel ingredientModel = new IngredientModel(newName, newQuantity);
        model.addToIngredientsSet(ingredientModel);
    
    

     for(int i =0; i< names.size(); i++){
    if(names.get(i).compareTo(newName)==0){
      
       model.removeToIngredientsSet(ingredientModel);
       
       
    }

   
   
     }    
     names = model.namesFromSet(model);
     quantity = model.quantityFromSet(model);
      if(names.size()==0){
     model.addToIngredientsSet(ingredientModel);
     names = model.namesFromSet(model);
     quantity = model.quantityFromSet(model);}
        
     
        System.out.println("1. Add new");
        System.out.println("0. Done");
        int nextLine = scan.nextInt();
        if(nextLine != 1){
            names = model.namesFromSet(model);
            quantity = model.quantityFromSet(model);
            exit = 0;}
    }
    
    //foreach
    for (String line1 : allLines) {
 
        myWriter.write(line1 + "\n");
 
    }
 
 
    myWriter.write(model.getName() + ": ");
   
    for(int i =0; i< names.size(); i++){
        myWriter.write(names.get(i)+ "-" + quantity.get(i)  + " ");}
    myWriter.write("\n");
   
   
    
}
   else{System.out.println("Already taken");
   for (String line5 : allLines) {
 
    myWriter.write(line5 + "\n");

}

  

   int remove = -1;

   Scanner newScann = new Scanner(System.in);
   System.out.println("1. Remove");
   System.out.println("0. Exit");
   String newLine = "";
   
   remove = newScann.nextInt();
   myWriter.close();

   FileWriter myWriter1 = new FileWriter("ingredients.txt");
   if(remove == 1){  for(int i = 0; i< allLines.size(); i++){
  

    newLine = allLines.get(i);
    String[] splitedTextLine = newLine.split(": "); // method used to distinguish the data in the file
    dishName = splitedTextLine[0];
    

    if(dishName.compareTo(model.getName() ) == 0)
    {
       allLines.remove(i);
       for (String line7 : allLines) {
 
        myWriter1.write(line7 + "\n");
    
    }
     }
    
   }
   myWriter1.close();
   
}
 
}

myWriter.close();
} catch (IOException e) {
   e.printStackTrace();
}

}}
 
}


}
