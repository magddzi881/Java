package TestPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.Model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/** tests for different model setters functions */
public class IngredientModelSettersTests {

    

/** method used to check if a number is positive */
    public NewNumber isPositiveNumer(int number){
        NewNumber newResult;
         
        if (number > 0) {
       newResult = NewNumber.POSITIVE;
      } else if (number < 0) {
       newResult = NewNumber.NEGATIVE;
      } else 
       newResult = NewNumber.ZERO;
    
       return newResult;
    
    }

    /** test used to check if Quantity is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,78,7,4,100,20})
    public void testQuantityIsAPositiveNumber(int i){
    
        IngredientModel model = new IngredientModel("",null);
        int quantity = model.setQuantity(i); 
        NewNumber newResult = isPositiveNumer(quantity);
         
        assertEquals(NewNumber.POSITIVE, newResult);
     
    }

    /** test used to check if Quantity is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testQuantityIsNegativeNumber(int i){

        IngredientModel model = new IngredientModel("",null);

        int quantity = model.setQuantity(i); 
        NewNumber newResult = isPositiveNumer(quantity); 
       
        assertEquals(NewNumber.NEGATIVE, newResult);
     
    }
    
    /** test used to check if Quantity equals zero*/
    @Test
    public void testQuantityIsZero(){
    
        IngredientModel model = new IngredientModel("",null);
        int quantity = model.setQuantity(0); 
        NewNumber newResult = isPositiveNumer(quantity); 
       
        assertEquals(NewNumber.ZERO, newResult);
     
    }

    /** test used to check if Name is empty */
    @Test
    public void testNameIsEmpty(){
    
        IngredientModel model = new IngredientModel("",null);
        String name = model.setName(""); 
        int nameLenght = name.length();
        NewNumber newResult = isPositiveNumer(nameLenght); 
       
        assertEquals(NewNumber.ZERO, newResult);
     
    }
    
     /** test used to check if Name is not empty */
     @ParameterizedTest
     @ValueSource(strings = {"pomidor","kaszka","mleko","kokos","ser"})
     public void testNameIsNotEmpty(String i){
     
         IngredientModel model = new IngredientModel("",null);
         String name = model.setName(i); 
         int nameLenght = name.length();
         NewNumber newResult = isPositiveNumer(nameLenght); 
        
         assertNotEquals(NewNumber.ZERO, newResult);
      
     }
    
    
}
