import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import modelPackage.DishDetailsModel;
import modelPackage.IngredientModel;
import modelPackage.Number;



/** tests for different model functions */
public class IngredientModelTests {


/** test used to add different ingfredients to list */
@ParameterizedTest
@ValueSource(strings = {"ser","","mleko","kakao","cukier"})
void testAddIngredientToListNames(String i){

     DishDetailsModel dishModel = new DishDetailsModel(1, "ciasto", 3);
    
     IngredientModel model = new IngredientModel( i, null);
    
    dishModel.addToIngredientsSet(model);


}

/** test used to add different quantities to list */
@ParameterizedTest
@ValueSource(ints = {1,4,-9,0,5})
void testAddIngredientToLisQuantitiest(int i){

     DishDetailsModel dishModel = new DishDetailsModel(1, "ciasto", 3);
    
     IngredientModel model = new IngredientModel( "", i);
    
    dishModel.addToIngredientsSet(model);


}


    /** test used to check if the name is taken */
@Test
public void testNewNameIsTaken(){

    DishDetailsModel dishModel = new DishDetailsModel(1, "ser", 3);
    dishModel.addToIngredientsSet(new IngredientModel("dorsz", 3));
    List<String> ingredientsFromList = dishModel.namesFromSet(dishModel);

                String newName = "dorsz";
                String result = " ";

    for(int i =0; i< ingredientsFromList.size(); i++){

    if(ingredientsFromList.get(i).compareTo(newName)==0){
    result = newName;
}
    }

    assertEquals(newName, result); //

 
}

 /** test used to check if the name is not taken */
@Test
public void testNewNameIsNotTaken(){

    DishDetailsModel dishModel = new DishDetailsModel(1, "ser", 3);

    List<String> ingredientsFromList = dishModel.namesFromSet(dishModel);

                String newName = "dorsz";
                String result = " ";

    for(int i =0; i< ingredientsFromList.size(); i++){

    if(ingredientsFromList.get(i).compareTo(newName)==0){
    result = newName;
}
    }

    assertNotEquals(newName, result); //

 
}


/** test used to remove different ingfredients from list */
@ParameterizedTest
@ValueSource(strings = {"ser","","mleko","kakao","cukier"})
void testRemoveIngredientFromListNames(String i){

     DishDetailsModel dishModel = new DishDetailsModel(1, "ciasto", 3);
    
     IngredientModel model = new IngredientModel( i, null);
    
    dishModel.addToIngredientsSet(model);

    dishModel.removeToIngredientsSet(model);

}

/** test used to remove different quantities from list */
@ParameterizedTest
@ValueSource(ints = {1,4,-9,0,5})
void testRemoveIngredientFromLisQuantitiest(int i){

     DishDetailsModel dishModel = new DishDetailsModel(1, "ciasto", 3);
    
     IngredientModel model = new IngredientModel( "", i);
    
    dishModel.addToIngredientsSet(model);

    dishModel.removeToIngredientsSet(model);

}

 /** test used to check if the list is empty */
 @Test
 public void testIngredientsListIsEmpty(){
 
     
     DishDetailsModel dishModel = new DishDetailsModel(1, "ser", 3);
     
 
     List<String> ingredientsFromList = dishModel.namesFromSet(dishModel);
 
     int listSize = ingredientsFromList.size();
     Number result = isPositiveNumer(listSize);
 
     assertEquals(Number.ZERO, result ); //
 
  
 }

 /** test used to check if the list is not empty */
 @Test
 public void testIngredientsListIsNotEmpty(){
 
    
     DishDetailsModel dishModel = new DishDetailsModel(2, null, 3);
     dishModel.addToIngredientsSet(new IngredientModel("ser", 2));
 
     List<String> ingredientsFromList = dishModel.namesFromSet(dishModel);
     
 
     int listSize = ingredientsFromList.size();
     Number result = isPositiveNumer(listSize);
 
     assertNotEquals(Number.ZERO, result ); //
 
  
 }
 
/** test used to check if names are equal */
@ParameterizedTest
@ValueSource(strings = {"pomidor","","mleko","kokos","ser"})
void testNameEqualsParam(String i){

    IngredientModel model1 = new IngredientModel( "", null);
    IngredientModel model2 = new IngredientModel( "", null);

    model1.setName(i);
    model2.setName(i);


    assertEquals(model1.getName(), model2.getName(), "Collections values ​​in both object are identical!");

   
}

/** test used to check if quantities are equal */
@ParameterizedTest
@ValueSource(ints = {2,0,-7,4,100,-20})
void testQuantityEqualsParam(int i){

    IngredientModel model1 = new IngredientModel( "", null);
    IngredientModel model2 = new IngredientModel( "", null);


    model1.setQuantity(i);
    model2.setQuantity(i);


    assertEquals(model1.getQuantity(), model2.getQuantity(), "Collections values ​​in both object are identical!");

   
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

