package TestPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.Model.*;

import static org.junit.jupiter.api.Assertions.*;

/** tests for different model getters functions */

public class IngredientModelGetterTests {


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
    
/** test used to check if dish names are not identical */
@ParameterizedTest
@ValueSource(strings = {"pomidor","kaszka","mleko","kokos","ser"})
public void testNameNotEquals(String i){

    IngredientModel model1 = new IngredientModel( "model1", 6);
    IngredientModel model2 = new IngredientModel( i, 3);

    String name1 = model1.getName();
    String name2 = model2.getName();

    assertNotEquals(name1, name2, "Collections values ​​in both object are identical!");

}


/** test used to check if dish Quantity are not identical */
@Test
public void testQuantityNotEquals(){

    IngredientModel model1 = new IngredientModel( "model1", 6);
    IngredientModel model2 = new IngredientModel( "model2", 3);

    int id1 = model1.getQuantity();
    int id2 = model2.getQuantity();

    assertNotEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish names are identical */
@ParameterizedTest
@ValueSource(strings = {"pomidor","kaszka","mleko","kokos","ser"})
public void testNameEquals(String i){

    IngredientModel model1 = new IngredientModel( i, 6);
    IngredientModel model2 = new IngredientModel( i, 3);

    String name1 = model1.getName();
    String name2 = model2.getName();

    assertEquals(name1, name2, "Collections values ​​in both object are identical!");

}


/** test used to check if dish Quantity are identical */
@ParameterizedTest
@ValueSource(ints = {-2,-78,-7,-4,-100,-20})
public void testQuantityEquals(int i){

    IngredientModel model1 = new IngredientModel( "model1", i);
    IngredientModel model2 = new IngredientModel( "model2", i);

    int id1 = model1.getQuantity();
    int id2 = model2.getQuantity();

    assertEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if name is empty */
@Test
public void testNameIsNull(){

  
    IngredientModel model = new IngredientModel( null, null);
    
    String name = model.getName();
   
   
    assertNull(name);
 
}

/** test used to check if name is not empty */
@ParameterizedTest
@ValueSource(strings = {"pomidor","kaszka","mleko","kokos","ser"})
public void testNameIsNotNull(String i){

    IngredientModel model = new IngredientModel( i, null);
    String name = model.getName();

    int size = name.length();
    NewNumber newResult = isPositiveNumer(size); 
   
   
    assertEquals(NewNumber.POSITIVE, newResult);
  
}

}
