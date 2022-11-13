import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import modelPackage.DishDetailsModel;
import modelPackage.Number;


/** tests for different model getters functions */
public class DishModelGetterTests {

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
    
/** test used to check if dish names are not identical */
@ParameterizedTest
@ValueSource(strings = {"1","2","3","4","5"})
public void testNameNotEquals(){

    DishDetailsModel model1 = new DishDetailsModel(4, "model1", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "model2", 350);

    String name1 = model1.getName();
    String name2 = model2.getName();

    assertNotEquals(name1, name2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish ids are not identical */

@ParameterizedTest
@ValueSource(ints = {2,0,-7,4,100,-20})
public void testIdNotEquals(int i){

    DishDetailsModel model1 = new DishDetailsModel(i, "model1", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "model2", 350);

    int id1 = model1.getId();
    int id2 = model2.getId();

    assertNotEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish kcal are not identical */
@ParameterizedTest
@ValueSource(ints = {2,0,-7,4,100,-20})
void testKcalNotEquals(int i){

    DishDetailsModel model1 = new DishDetailsModel(i, "model1", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "model2", 350);

    int id1 = model1.getKcal();
    int id2 = model2.getKcal();

    assertNotEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish names are identical */
@Test
public void testNameEquals(){

    DishDetailsModel model1 = new DishDetailsModel(5, "model", 60);
    DishDetailsModel model2 = new DishDetailsModel(5, "model", 60);

    String name1 = model1.getName();
    String name2 = model2.getName();

    assertEquals(name1, name2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish ids are identical */
@Test
public void testIdEquals(){

    DishDetailsModel model1 = new DishDetailsModel(5, "model", 60);
    DishDetailsModel model2 = new DishDetailsModel(5, "model", 60);

    int id1 = model1.getId();
    int id2 = model2.getId();

    assertEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if dish kcal are identical */
@Test
public void testKcalEquals(){

    DishDetailsModel model1 = new DishDetailsModel(5, "model", 60);
    DishDetailsModel model2 = new DishDetailsModel(5, "model", 60);

    int id1 = model1.getKcal();
    int id2 = model2.getKcal();

    assertEquals(id1, id2, "Collections values ​​in both object are identical!");

}

/** test used to check if name is empty */
@Test
public void testNameIsEmpty(){

    DishDetailsModel model = new DishDetailsModel(null, "",null );
    String name = model.getName();
   
    int size = name.length();
    Number newResult = isPositiveNumer(size); 
   
   
    assertEquals(Number.ZERO, newResult);
 
}

/** test used to check if name is not empty */
@ParameterizedTest
@ValueSource(strings = {"m","l","k","j","i"})
public void testNameIsNotEmpty(String i){

    DishDetailsModel model = new DishDetailsModel(null, i,null );
    String name = model.getName();

    int size = name.length();
    Number newResult = isPositiveNumer(size); 
   
   
    assertEquals(Number.POSITIVE, newResult);
  
}


}
