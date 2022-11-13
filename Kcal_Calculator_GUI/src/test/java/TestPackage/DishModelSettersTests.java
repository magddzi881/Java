package TestPackage;

import pl.polsl.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** tests for different model setters functions */
public class DishModelSettersTests {
  

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

    /** test used to check if kcal is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,78,7,4,100,20})
    public void testKcalIsAPositiveNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int kcal = model.setKcal(3); 
        NewNumber newResult = isPositiveNumer(kcal);
         
        assertEquals(NewNumber.POSITIVE, newResult);
     
    }

    /** test used to check if kcal is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testKcalIsNegativeNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setKcal(-2); 
        NewNumber newResult = isPositiveNumer(id); 
       
        assertEquals(NewNumber.NEGATIVE, newResult);
     
    }
    
    /** test used to check if kcal equals zero*/
    @Test
    public void testKcalIsZero(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setKcal(0); 
        NewNumber newResult = isPositiveNumer(id); 
       
        assertEquals(NewNumber.ZERO, newResult);
     
    }
    
    
    /** test used to check if id is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,87,7,4,100,20})
    void testIdIsPositiveNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setId(3); 
        NewNumber newResult = isPositiveNumer(id); 
       
        assertEquals(NewNumber.POSITIVE, newResult);
     
    }

    /** test used to check if id is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testIdIsNegativeNumber(int i){
    
        DishDetailsModel model = new DishDetailsModel(i, "",null );
        int id = model.setId(-2); 
        NewNumber newResult = isPositiveNumer(id); 
       
        assertEquals(NewNumber.NEGATIVE, newResult);
     
    }
    
    /** test used to check if id equals zero*/
    @Test
    public void testIdIsZero(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setId(0); 
        NewNumber newResult = isPositiveNumer(id); 
       
        assertEquals(NewNumber.ZERO, newResult);
     
    }
    


}
