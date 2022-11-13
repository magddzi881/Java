package pl.polsl.Controller;



/**
 * @author Magdalena Dziubosz
 Used formulas:
 For women, BMR = 655.1 + (9.563 x weight in kg) + (1.850 x height in cm) - (4.676 x age in years)
 For men, BMR = 66.47 + (13.75 x weight in kg) + (5.003 x height in cm) - (6.755 x age in years)
*/

public class RecommendedTotalCaloriesPerPerson {

    // woman constants
    final private double constantWomenValue = 655.1;
    final private double constantWomenWeightValue = 9.563;
    final private double constantWomenHeightValue = 1.850;
    final private double constantWomenAgeValue = 4.676;

    // man constants
    final private double constantMenValue = 66.47;
    final private double constantMenWeightValue = 13.75;
    final private double constantMenHeightValue = 5.003;
    final private double constantMenAgeValue = 6.755;



    /** a calculator for recommended total calories per person */
    public double recommendedTotalCaloriesPerPerson(double weight,double height,int age, int gender ) {

        

            double totalCalories = 0;

            
                if(gender == 1) {
                    totalCalories = constantWomenValue + (weight * constantWomenWeightValue)
                            + (height * constantWomenHeightValue)
                            - (age * constantWomenAgeValue);
                
                    
                }
                    
                if(gender == 2) {
                    totalCalories = constantMenValue + (weight * constantMenWeightValue)
                            + (height * constantMenHeightValue)
                            - (age * constantMenAgeValue);

                  
                   
                }
                    
                
                return totalCalories ;


        }

    }
    

