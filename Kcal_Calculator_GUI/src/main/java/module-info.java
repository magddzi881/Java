module pl.polsl.AppMain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;


    opens pl.polsl.Controller to javafx.fxml;
    
    exports pl.polsl.Model;
    exports pl.polsl.Controller;
    exports AppMain;
    
    
}
