package modelPackage;

// dish/meal model with data getters and setters


public class DishDetailsModel {

  private int id;
  private int kcal; // kcal per 100g
  private String name;

  public DishDetailsModel(int id, String name, int kcal) {
    this.name = name;
    this.kcal = kcal;
    this.id = id;
  }

  
  /** 
   * @return int
   */
  public int getId() {
    return id;
  }

  
  /** 
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  
  /** 
   * @return int
   */
  public int getKcal() {
    return kcal;
  }

  
  /** 
   * @param kcal
   */
  public void setKcal(int kcal) {
    this.kcal = kcal;
  }

  
  /** 
   * @return String
   */
  public String getName() {
    return name;
  }

  
  /** 
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

}
