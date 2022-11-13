package TestPackage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.Controller.*;
import pl.polsl.Model.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/** tests for different model functions */
public class DishModelTests {

    /** test used to check if the name is taken */
@Test
public void testNewNameIsTaken(){

    GetMealList getMealList = new GetMealList();
    Set<DishDetailsModel> list = getMealList.getMealList();

    List<String> namesFromList = list.stream().map(DishDetailsModel::getName)
                .collect(Collectors.toList());

                String newName = "ser";
                String result = " ";

    for(int i =0; i< namesFromList.size(); i++){

    if(namesFromList.get(i).compareTo(newName)==0){
    result = newName;
}
    }

    assertNotEquals(newName, result); //

 
}

 /** test used to check if the name is not taken */
 @ParameterizedTest
 @ValueSource(strings = {"@","`","/","[","]"})
public void testNewNameIsNotTaken(String j){

    GetMealList getMealList = new GetMealList();
    Set<DishDetailsModel> list = getMealList.getMealList();

    List<String> namesFromList = list.stream().map(DishDetailsModel::getName)
                .collect(Collectors.toList());

                String newName = j;
                String result = " ";

    for(int i =0; i< namesFromList.size(); i++){
if(namesFromList.get(i).compareTo(newName)==0){
    result = newName;
}
    }

    assertNotEquals(newName, result); //

 
}

 /** test used to check if id exists */
@Test
public void testIdExistsOnList(){

    GetMealList getMealList = new GetMealList();
    Set<DishDetailsModel> list = getMealList.getMealList();

    List<Integer> idsFromList = list.stream().map(DishDetailsModel::getId)
                .collect(Collectors.toList());

    DishDetailsModel model = new DishDetailsModel(3, "x",null );
    int id = model.getId();
    int result = 0;

    for(int i = 0; i< idsFromList.size(); i++){
        if(idsFromList.get(i).compareTo(id)==0){result = id;}
    }

    assertEquals(result, id);
    
 
}

/** test used to check if id not exists */
@Test
public void testIdNotExistsOnList(){

    GetMealList getMealList = new GetMealList();
    Set<DishDetailsModel> list = getMealList.getMealList();

    List<Integer> idsFromList = list.stream().map(DishDetailsModel::getId)
                .collect(Collectors.toList());

    DishDetailsModel model = new DishDetailsModel(-1, "x",null );
    int id = model.getId();
    int result = 0;

    for(int i = 0; i< idsFromList.size(); i++){
        if(idsFromList.get(i).compareTo(id)==0){result = id;}
    }

    assertNotEquals(result, id);
    
 
}
/** test used to check if names are equal */
@ParameterizedTest
@ValueSource(strings = {"pomidor","","mleko","kokos","ser"})
void testNameEqualsParam(String i){

    DishDetailsModel model1 = new DishDetailsModel(4, "", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "", 350);

    model1.setName(i);
    model2.setName(i);


    assertEquals(model1.getName(), model2.getName(), "Collections values ​​in both object are identical!");

   
}
/** test used to check if ids are equal */
@ParameterizedTest
@ValueSource(ints = {2,0,-7,4,100,-20})
void testIdEqualsParam(int i){

    DishDetailsModel model1 = new DishDetailsModel(4, "", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "", 350);

    model1.setId(i);
    model2.setId(i);


    assertEquals(model1.getId(), model2.getId(), "Collections values ​​in both object are identical!");

   
}
/** test used to check if kcal values are equal */
@ParameterizedTest
@ValueSource(ints = {2,0,-7,4,100,-20})
void testKcalEqualsParam(int i){

    DishDetailsModel model1 = new DishDetailsModel(4, "", 600);
    DishDetailsModel model2 = new DishDetailsModel(5, "", 350);

    model1.setKcal(i);
    model2.setKcal(i);


    assertEquals(model1.getKcal(), model2.getKcal(), "Collections values ​​in both object are identical!");

   
}

}

