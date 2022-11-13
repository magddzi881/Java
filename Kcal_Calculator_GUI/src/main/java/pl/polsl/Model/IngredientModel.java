package pl.polsl.Model;
/** main ingredient model
@author Magdalena Dziubosz*/

public class IngredientModel {
      /** total ingredient quantity */
  private Object quantity; 
  /** ingredient name*/
  private String name; 
  

   /** main ingredient constructor */
  public IngredientModel(String name, Object quantity) {
    
    this.name = name;
    this.quantity = quantity;
  }

 
 /** 
  * @return int
  */
 /* * 
  * method used to get quantity
  * @return int
  */
 public int getQuantity() {
   return (int) quantity;
 }

 
 /** 
  * method used to set ingredient quantity
  * @param quantity
  */
 public int setQuantity(int quantity) {
   this.quantity = quantity;
   return quantity;
 }

 
 /** 
  * method used to get name
  * @return String
  */
 public String getName() {
   return name;
 }

 
 /** 
  * method used to set dish ingredient name
  * @param name
  */
 public String setName(String name) {
   this.name = name;
   return name;
 }

 




}
