import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import modelPackage.IngredientModel;
import modelPackage.Number;

/** tests for different model setters functions */
public class IngredientModelSettersTests {

    

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

    /** test used to check if Quantity is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,78,7,4,100,20})
    public void testQuantityIsAPositiveNumber(int i){
    
        IngredientModel model = new IngredientModel("",null);
        int quantity = model.setQuantity(i); 
        Number newResult = isPositiveNumer(quantity);
         
        assertEquals(Number.POSITIVE, newResult);
     
    }

    /** test used to check if Quantity is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testQuantityIsNegativeNumber(int i){

        IngredientModel model = new IngredientModel("",null);

        int quantity = model.setQuantity(i); 
        Number newResult = isPositiveNumer(quantity); 
       
        assertEquals(Number.NEGATIVE, newResult);
     
    }
    
    /** test used to check if Quantity equals zero*/
    @Test
    public void testQuantityIsZero(){
    
        IngredientModel model = new IngredientModel("",null);
        int quantity = model.setQuantity(0); 
        Number newResult = isPositiveNumer(quantity); 
       
        assertEquals(Number.ZERO, newResult);
     
    }

    /** test used to check if Name is empty */
    @Test
    public void testNameIsEmpty(){
    
        IngredientModel model = new IngredientModel("",null);
        String name = model.setName(""); 
        int nameLenght = name.length();
        Number newResult = isPositiveNumer(nameLenght); 
       
        assertEquals(Number.ZERO, newResult);
     
    }
    
     /** test used to check if Name is not empty */
     @ParameterizedTest
     @ValueSource(strings = {"pomidor","kaszka","mleko","kokos","ser"})
     public void testNameIsNotEmpty(String i){
     
         IngredientModel model = new IngredientModel("",null);
         String name = model.setName(i); 
         int nameLenght = name.length();
         Number newResult = isPositiveNumer(nameLenght); 
        
         assertNotEquals(Number.ZERO, newResult);
      
     }
    
    
}
