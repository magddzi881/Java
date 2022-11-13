package pl.polsl.Controller;

import pl.polsl.Model.NewNumber;

/** class used to check if a number is positive 
 * @author Magdalena Dziubosz
*/
public class IsPositiveNumber {
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

}
