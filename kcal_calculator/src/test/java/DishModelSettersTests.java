import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import modelPackage.DishDetailsModel;
import modelPackage.Number;

/** tests for different model setters functions */
public class DishModelSettersTests {
  

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

    /** test used to check if kcal is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,78,7,4,100,20})
    public void testKcalIsAPositiveNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int kcal = model.setKcal(3); 
        Number newResult = isPositiveNumer(kcal);
         
        assertEquals(Number.POSITIVE, newResult);
     
    }

    /** test used to check if kcal is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testKcalIsNegativeNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setKcal(-2); 
        Number newResult = isPositiveNumer(id); 
       
        assertEquals(Number.NEGATIVE, newResult);
     
    }
    
    /** test used to check if kcal equals zero*/
    @Test
    public void testKcalIsZero(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setKcal(0); 
        Number newResult = isPositiveNumer(id); 
       
        assertEquals(Number.ZERO, newResult);
     
    }
    
    
    /** test used to check if id is a positive number */
    @ParameterizedTest
    @ValueSource(ints = {2,87,7,4,100,20})
    void testIdIsPositiveNumber(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setId(3); 
        Number newResult = isPositiveNumer(id); 
       
        assertEquals(Number.POSITIVE, newResult);
     
    }

    /** test used to check if id is a negative number */
    @ParameterizedTest
    @ValueSource(ints = {-2,-78,-7,-4,-100,-20})
    public void testIdIsNegativeNumber(int i){
    
        DishDetailsModel model = new DishDetailsModel(i, "",null );
        int id = model.setId(-2); 
        Number newResult = isPositiveNumer(id); 
       
        assertEquals(Number.NEGATIVE, newResult);
     
    }
    
    /** test used to check if id equals zero*/
    @Test
    public void testIdIsZero(){
    
        DishDetailsModel model = new DishDetailsModel(null, "",null );
        int id = model.setId(0); 
        Number newResult = isPositiveNumer(id); 
       
        assertEquals(Number.ZERO, newResult);
     
    }
    


}
