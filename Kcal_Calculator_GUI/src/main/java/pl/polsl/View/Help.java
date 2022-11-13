package pl.polsl.View;
/**class used to display help info 
 * @author Magdalena Dziubosz
*/
public class Help {
    /**function used to display help info related to parametes */
public void help(){
    System.out.println("To run application type:");
    System.out.println("java AppMain.App <flag>");
    System.out.println("where <flag>:");
    System.out.println("'-r' to run application");
    System.out.println("'-h' to display help info");
    System.out.println("'-e' to exit");
}
}
