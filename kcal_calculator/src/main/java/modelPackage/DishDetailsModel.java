package modelPackage;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** main dish/meal model with data getters and setters */ 


public class DishDetailsModel {

   /** meal id number */
  private Object id;
  /** meal total kilocalories per 100g */
  private Object kcal; 
  /** meal name*/
  private String name; 
  /** list of meals*/
  private Set<IngredientModel> ingredients = new LinkedHashSet<>(); 

  /** main dish constructor */
  public DishDetailsModel(Object id, String name, Object kcal) {
    this.name = name;
    this.kcal = kcal;
    this.id = id;
  }

  
  /** 
   * method used to get id
   * @return int
   */
  public int getId() {
    return (int) id;
  }

  
  /** 
   * method used to set dish id
   * @param id
   */
  public int setId(int id) {
    this.id = id;
    return id;
  }

  
  /** 
   * method used to get kcal
   * @return int
   */
  public int getKcal() {
    return (int) kcal;
  }

  
  /** 
   * method used to set dish kcal
   * @param kcal
   */
  public int setKcal(int kcal) {
    this.kcal = kcal;
    return kcal;
  }

  
  /** 
   * method used to get name
   * @return String
   */
  public String getName() {
    return name;
  }

  
  /** 
   * method used to set dish name
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  
  /** 
   * method used to get collection of ingredients
   * @return Set
   */
  public Set<IngredientModel> getIngredientsList(){
    return ingredients;
  }


/** 
 * method used to add ingredients to list
 * @param model
 */
public void addToIngredientsSet(IngredientModel model){
  getIngredientsList().add(model);
}

/** 
 * method used to remove ingredients from list
 * @param model
 */
public void removeToIngredientsSet(IngredientModel model){
  getIngredientsList().remove(model);
}

/** 
 * method used to get a list of ingredient names
 * @param model
 * @return List
 */
public List<String> namesFromSet(DishDetailsModel model){

  Set<IngredientModel> list = model.getIngredientsList();

  List<String> names = list.stream().map(IngredientModel::getName).collect(Collectors.toList());

  return names;
}

/** 
 * method used to get a list of ingredient quantity
 * @param model
 * @return List
 */
public List<Integer> quantityFromSet(DishDetailsModel model){

  Set<IngredientModel> list = model.getIngredientsList();

  List<Integer> quantity = list.stream().map(IngredientModel::getQuantity).collect(Collectors.toList());

  return quantity;
}


}
