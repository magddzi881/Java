package AppMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.polsl.Controller.AppMainController;
import pl.polsl.Model.DishList;
import pl.polsl.View.Help;

import java.io.IOException;
import java.util.Scanner;
/** main app class used to create new window and run application 
 * To run application type:
 * java AppMain.App flag
 * where flag:
 * '-r' to run application
 * '-h' to display help info
 * '-e' to exit"
 * @author Magdalena Dziubosz
 * @version 1
*/
public class App extends Application {

    private static Scene scene;
   
    private static DishList dishes;

   
    
    
    @Override
    /** function used to create new app window 
     * @param stage
    */
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("appMain.fxml"), 821, 526);
        stage.setTitle("Kilocalories calculator");
        stage.setScene(scene);
        stage.show();
    }
/** function used to load fxml file
 * @param fxml
 */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        fxmlLoader.setControllerFactory( p -> { return new AppMainController(dishes);} );  
        return fxmlLoader.load();
    }
/**main app function 
 * @param args
*/
    public static void main(String[] args) throws IOException {
        App app = new App();
        Help help =new Help();
        
            if(args.length!=0&& args[0].compareTo("-r") == 0){
                dishes = new DishList();
                launch();
            } else if(args.length!=0 && args[0].compareTo("-h") == 0){ help.help(); app.setArguments();
            } else {
                System.out.println("Syntax error, type '-h' for help");
                app.setArguments();
            }
       
       
    }
    /**function used to set correct arguments */
    public void setArguments(){
        Help help =new Help();
        int i =-1;
        while(i!=0){
            System.out.print("Enter new <flag>: ");
            Scanner scan = new Scanner(System.in);
            String option = scan.nextLine();
            String[] choice = option.split(" ");
            if(option.compareTo("-r") == 0){
                dishes = new DishList();
                launch();
                i=0;
            } else if(option.compareTo("-h") == 0){
                 help.help();
                }
            else if(option.compareTo("-e") == 0){
                  i=0;Runtime.getRuntime().exit(1);
                   }
            else {
               i=-1;
               
            }
        }
      
    }
    
}