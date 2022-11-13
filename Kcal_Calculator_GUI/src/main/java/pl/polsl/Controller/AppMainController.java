package pl.polsl.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import pl.polsl.Model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

 /** Main page controller, used for GUI 
  * @author Magdalena Dziubosz
 */
public class AppMainController {
 
    @FXML
    private TableView<DishDetailsModel> table;
    @FXML
    private TableColumn<DishDetailsModel, Object> idCol;
    @FXML
    private TableColumn<DishDetailsModel, String> nameCol;
    @FXML
    private TableColumn<DishDetailsModel, Object> kcalCol;
    @FXML
    private TableView<IngredientModel> iTable;
    @FXML
    private TableColumn<IngredientModel, Object> iQuantityCol;
    @FXML
    private TableColumn<IngredientModel, String> iNameCol;
    @FXML
    private Label displayTitle;
    @FXML    
    private Label help;
    @FXML    
    private Label kcalResult;
    @FXML    
    private Label newResult;
    @FXML    
    private Label newList;
    @FXML    
    private Button show;
    @FXML    
    private RadioButton radio1;
    @FXML    
    private RadioButton radio2;
    @FXML    
    private RadioButton radio3;
    @FXML    
    private RadioButton radio4;
    @FXML    
    private TextField takeName;
    @FXML    
    private TextField newName;
    @FXML    
    private TextField newNumber;
    @FXML    
    private TextField newDishName;
    @FXML    
    private TextField height;
    @FXML    
    private TextField newTextField;
    @FXML    
    private TextField weight;
    @FXML    
    private TextField age;
    @FXML    
    private Button calculate;
    @FXML    
    private Button add;
    @FXML
    private Button remove;
    @FXML    
    private Button newAdd;
    @FXML    
    private Button newUndo;
    @FXML
    private ScrollPane newScroll;
    
    private final ObservableList<DishDetailsModel> data;    
    private final DishList dishes;
    IsPositiveNumber isPositiveNumber = new IsPositiveNumber();
    final ToggleGroup group = new ToggleGroup();
    final ToggleGroup genderGroup = new ToggleGroup();
    Set<DishDetailsModel> list = new LinkedHashSet<>();
    String namesFromList;
    double total = 0;
    /** Main page controller, used for GUI */
    public AppMainController(DishList dishes ) {

        this.dishes = dishes;
    
        data = FXCollections.observableArrayList(dishes.getData());
        data.addListener(new ListChangeListener<DishDetailsModel>(){
            @Override
            public void onChanged(ListChangeListener.Change<? extends DishDetailsModel> change) {
                while (change.next()) {
                    if (change.wasPermutated()) {
                      
                    } else if (change.wasUpdated()) {
                       
                    } else {
                        for (DishDetailsModel remitem : change.getRemoved()) {
                            dishes.getData().remove(remitem);
                        }
                        for (DishDetailsModel additem : change.getAddedSubList()) {
                            dishes.getData().add(additem);
                        }
                    }
                }
            }
        });
        
        
    }   
     /** method used to initialize values and widgets */
    @FXML
    public void initialize() {

        radio1.setToggleGroup(group);
        radio1.setSelected(true);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(genderGroup);
        radio3.setSelected(true);
        radio4.setToggleGroup(genderGroup);
        newDishName.setDisable(true); 
        
        table.setItems(data);
        idCol.setCellValueFactory(new PropertyValueFactory<DishDetailsModel, Object>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<DishDetailsModel, String>("name"));
        kcalCol.setCellValueFactory(new PropertyValueFactory<DishDetailsModel, Object>("kcal"));
        table.setEditable(false);

    }

    
    /** 
     * method used for searching for a specific dish on the main list
     * @param event
     */
    @FXML
    private void showFunction(ActionEvent event) { 

       
        GetMealList getMealList = new GetMealList();
        List<IngredientModel> emptyList = new ArrayList<>();
        ObservableList<IngredientModel> list2 = FXCollections.observableArrayList(emptyList) ;
        DishList list = dishes;
        displayTitle.setText("Meal is not on the list");
        displayTitle.setTextFill(Color.rgb(136, 8, 8, 0.87));
        String input = takeName.getText();
 
     for(int i =0; i< list.getData().size() ; i++){

       if(input.compareTo(list.getData().get(i).getName())==0){

        displayTitle.setText("List of "+ list.getData().get(i).getName() + " ingredients");
        displayTitle.setTextFill(Color.rgb(0, 0, 0, 0.87));
        list2 = FXCollections.observableArrayList(getMealList.getIndredientsListToList(list.getData().get(i)));
        
        }
     }

        iTable.setItems(list2);
        iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
        iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
        iTable.setEditable(false);


    }
    
     
     /** 
      * method used for disabling and enabling texfield basen on radiobutton option
      * @param event
      */
     @FXML
     private void radioButtonAction(ActionEvent event) {
         newDishName.setDisable(radio1.isSelected());
      }     
            
        
      
      
      /** 
       * method used to add dish name to list and kcal value to calculator  
       * @param event
       */
      @FXML
      private void newAddFunction(ActionEvent event) { 

        try {
            List<String> names = list.stream().map(DishDetailsModel::getName).collect(Collectors.toList());
            boolean exists = false;
            if(newTextField.getText().isEmpty()==false){
                for(int i = 0;i<data.size();i++){
                    if(data.get(i).getName().compareTo(newTextField.getText())==0){

                        
                   for(int j=0;j<names.size();j++){
                    if(names.get(j).compareTo(newTextField.getText())==0){

                        exists=true;
                    }  
    
                   }
                   if(exists==false) total = total + data.get(i).getKcal();
                   list.add(new DishDetailsModel(data.get(i).getId(), data.get(i).getName(), data.get(i).getKcal()) );
                    newResult.setText("Total: "+total+" kcal"); 
        
                    }
                    namesFromList = list.stream().map(DishDetailsModel::getName).collect(Collectors.toSet()).toString();
                    String text = namesFromList;
                    text = text.replace("[", "");
                    text = text.replace("]", "");
                    newList.setText(text); 
                   
                    }
            }else{newResult.setText("Incorrect values");}
            
        } catch (Exception e) {
           
           newResult.setText("Incorrect values");
        }
        }
        
        /** 
         * method used to delete added meal from caloric calculator
         * @param event
         */
        @FXML
        private void newUndoFunction(ActionEvent event) { 
  
            int tot = 0;
            
            Set<DishDetailsModel> temp = new LinkedHashSet<DishDetailsModel>();

            List<String> name = list.stream().map(DishDetailsModel::getName).collect(Collectors.toList());
            List<Integer> id = list.stream().map(DishDetailsModel::getId).collect(Collectors.toList());
            List<Integer> kcal = list.stream().map(DishDetailsModel::getKcal).collect(Collectors.toList());
          try {
          
              for(int i = 0;i<list.size();i++){
                
          
              if(name.get(i).compareTo(newTextField.getText())==0){
             
             
               
              }else{
               
                temp.add(new DishDetailsModel(id.get(i), name.get(i), kcal.get(i)));
               
           
            }

              } 
                          
           
            List<Integer> kcalTemp = temp.stream().map(DishDetailsModel::getKcal).collect(Collectors.toList());
            for(int t = 0;t<temp.size();t++){
                tot = tot + kcalTemp.get(t);
            }

            
              String text = temp.stream().map(DishDetailsModel::getName).collect(Collectors.toSet()).toString();
              list = temp;
              namesFromList = text;
              text = text.replace("[", "");
              text = text.replace("]", "");
              
              newList.setText(text); 
              total = tot;
              newResult.setText("Total: "+total+" kcal"); 
          } catch (Exception e) {
            e.printStackTrace();
             newResult.setText("Enter correct values");
          }
          }




    
    /** 
     *  method used to add ingredient to specific meal or new dish to the main list
     * and save data to the text file
     * based on radiobutton option
     * @param event
     */
    @FXML
    private void addNew(ActionEvent event) {

if(newNumber.getText().length()!=0&& isPositiveNumber.isPositiveNumer(Integer.parseInt(newNumber.getText())) == NewNumber.NEGATIVE    ){
    try {
        throw new NumberException("Number must be a positive value");
    } catch (NumberException e) {
       
       help.setText(e.getMessage());
    }
}else{
    if(radio1.isSelected()){ 
        
        int lenght = data.size();
        boolean exists = false;
       
         try {
            for(int k = 0; k< data.size();k++){
    
                if(data.get(k).getName().compareTo(newName.getText())==0){
                    help.setText("Meal already exists");
                    exists = true;
                }
            }
    
            if(exists == false)
             {
             data.add(new DishDetailsModel(lenght+1, newName.getText(), Integer.parseInt(newNumber.getText())));
             try {
    
                List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));
                FileWriter myWriter = new FileWriter("dishes.txt");
    
        
                for (String line : allLines) {
    
                    myWriter.write(line + "\n");
    
                }
    
                myWriter.write((lenght+1) + " " + newName.getText() + " " + Integer.parseInt(newNumber.getText()) + "\n");
                myWriter.close();
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        } catch (Exception e) {
            help.setText("Enter correct data");
        }}
       else{
    
        GetMealList getMealList = new GetMealList();
        List<IngredientModel> emptyList = new ArrayList<>();
        ObservableList<IngredientModel> list2 = FXCollections.observableArrayList(emptyList) ;
        DishList list = dishes;
        displayTitle.setText("Meal is not on the list");
        displayTitle.setTextFill(Color.rgb(136, 8, 8, 0.87));
        String input = newDishName.getText();
        if(input.isEmpty()){
            help.setText("Enter Dish Name");
            input = takeName.getText();}
    
           if(input.isEmpty()){ }
           else{
       
        
        try {
           
            DishDetailsModel model = new DishDetailsModel(null, " " , null);
         for(int i =0; i< list.getData().size() ; i++){
    
            if(input.compareTo(list.getData().get(i).getName())==0){
            
                displayTitle.setText("List of "+ list.getData().get(i).getName() + " ingredients");
                displayTitle.setTextFill(Color.rgb(0, 0, 0, 0.87));
                list2 = FXCollections.observableArrayList(getMealList.getIndredientsListToList(list.getData().get(i)));
                iTable.setItems(list2);
                iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
                iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
                iTable.setEditable(false);
    
                if(list2.isEmpty()){
                    if(newName.getText().isEmpty() == false && newNumber.getText().isEmpty()==false){
                        List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));
                        FileWriter myWriter = new FileWriter("ingredients.txt");
                        for (String line1 : allLines) {
             
                            myWriter.write(line1 + "\n");
                     
                        }
            
                        myWriter.write(input + ": ");
       
                       
                            myWriter.write(newName.getText()+ "-" + newNumber.getText()  + " ");
                        myWriter.write("\n");
                       
                        myWriter.close();
                        list2.add(new IngredientModel(newName.getText(), Integer.parseInt(newNumber.getText())));
                        iTable.setItems(list2);
                           iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
                           iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
                           iTable.setEditable(false);
                    }else help.setText("Incorrect values");
                    
            }
                else{
                    if(newName.getText().isEmpty() == false && newNumber.getText().isEmpty()==false){
    
                    IngredientModel ingredient = new IngredientModel(newName.getText(), Integer.parseInt(newNumber.getText()));
                 
                    model.setId(list.getData().get(i).getId());
                    model.setName(list.getData().get(i).getName());
                    model.setKcal(list.getData().get(i).getKcal());
       
                       try {
                           List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));
                           FileWriter myWriter = new FileWriter("ingredients.txt");
                           myWriter.write("\n");
          
       
            
                           String line = " ";
                           boolean exists = true;
                           for (int o = 1; o < allLines.size(); o++) {
       
                           line = allLines.get(o);
                           String[] splitedTextLine = line.split(": "); // method used to distinguish the data in the file
                           String dishName = splitedTextLine[0];
                           String[] secondSplit = splitedTextLine[1].split(" ");
       
                           for(int k =0; k< secondSplit.length; k++){
                           String[] d = secondSplit[k].split("-");
                           String name = d[0];

                               exists = name.compareTo(newName.getText()) == 0;
                
                           }
       
                           if(dishName.compareTo(model.getName())==0 && exists == false){
       
                            myWriter.write(line + newName.getText()+ "-" + newNumber.getText()  + " "+ "\n");
                   
                           list2.add(ingredient);
                           iTable.setItems(list2);
                           iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
                           iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
                           iTable.setEditable(false);
                  
                           }
                           else { myWriter.write(line + "\n"); }
       
                           }
                           myWriter.close();
       
                       } catch (Exception e) {
                         help.setText("Invalid values/Indgredient name taken");
                       }
       
       
                   }}
    
                
            }
    
            else 
            help.setText("Invalid values/Indgredient name taken");
                iTable.setItems(list2);
                iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
                iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
                iTable.setEditable(false);
            }
        } catch (Exception e) {
            help.setText("Enter correct values");
        }
        
       
       }}
}


    }

    
    /** 
     * method used to calculate daily caloric requirement 
     * @param event
     */
    @FXML
    private void getKcalResult(ActionEvent event) {
       RecommendedTotalCaloriesPerPerson recommended = new RecommendedTotalCaloriesPerPerson();
       DecimalFormat df = new DecimalFormat("0.00");
       int gender = 1;
       if(radio4.isSelected()) gender = 2;
       try {
      
        double result = (recommended.recommendedTotalCaloriesPerPerson(Double.parseDouble(weight.getText()), Double.parseDouble(height.getText()), Integer.parseInt(age.getText()), gender)) ; 
        
        kcalResult.setText(df.format(result) + " kcal");
    
        } catch (Exception e) {
       
        kcalResult.setText("Incorrect values");
       
       }
       } 

    
    /** 
     * method used to remove meal or igredient from list based o choosen radiobutton option
     * additionally writes changes to text files and changes meals ids
     * @param event
     */
    @FXML
    private void removeOld(ActionEvent event) {

        if(radio1.isSelected()){ 
        
        int index = table.getSelectionModel().getSelectedIndex();
      
        if(index != -1) data.remove(index); 
        
        List<DishDetailsModel> newData = new ArrayList<>();
    
        for(int i =0;i< data.size();i++){
            
            newData.add(new DishDetailsModel((i+1),  data.get(i).getName(),  data.get(i).getKcal()));
            
        }
        try {

            List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));
            FileWriter myWriter = new FileWriter("dishes.txt");
            data.clear();
            myWriter.write(allLines.get(0) + "\n");
           
            for (int p = 0; p<newData.size();p++ ) {

                data.add(new DishDetailsModel(newData.get(p).getId(), newData.get(p).getName() ,  newData.get(p).getKcal()));
                myWriter.write( newData.get(p).getId()+" "+ newData.get(p).getName() +" "+  newData.get(p).getKcal()  + "\n");
                
            }

            
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        dishes.getData();
    }
   
     else { 
        removeIngredient();
        }   
     }


             private void removeIngredient() {
                GetMealList getMealList = new GetMealList();
                List<IngredientModel> emptyList = new ArrayList<>();
                ObservableList<IngredientModel> list2 = FXCollections.observableArrayList(emptyList) ;
                DishList list = dishes;
                displayTitle.setText("Meal is not on the list");
                displayTitle.setTextFill(Color.rgb(136, 8, 8, 0.87));
                String input = newDishName.getText();
                if(input.isEmpty()){
                     help.setText("Enter Dish Name");
                     input = takeName.getText();}
        
                    if(input.isEmpty()){ }
                    else{
                    for(int i =0; i< list.getData().size() ; i++){
        
                        if(input.compareTo(list.getData().get(i).getName())==0){
        
                            int index = iTable.getSelectionModel().getSelectedIndex();
                            displayTitle.setText("List of "+ list.getData().get(i).getName() + " ingredients");
                            displayTitle.setTextFill(Color.rgb(0, 0, 0, 0.87));
                            list2 = FXCollections.observableArrayList(getMealList.getIndredientsListToList(list.getData().get(i)));
                            if(index != -1) list2.remove(index); 
                            iTable.setItems(list2);
                            iNameCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, String>("name"));
                            iQuantityCol.setCellValueFactory(new PropertyValueFactory<IngredientModel, Object>("quantity"));
                            iTable.setEditable(false);
                            try {

                                List<String> allLines = Files.readAllLines(Paths.get("ingredients.txt"));
                                FileWriter myWriter = new FileWriter("ingredients.txt");
                                
                                myWriter.write("\n");
                                String line = " ";
                      
                       for (int o = 1; o < allLines.size(); o++) {
   
                       line = allLines.get(o);
                       String[] splitedTextLine = line.split(": "); // method used to distinguish the data in the file
                       String dishName = splitedTextLine[0];
                     
   
                       if(dishName.compareTo(list.getData().get(i).getName())==0){
   
                    
               if(list2.size()==0){}
               else {
                myWriter.write(dishName+ ": ");
                
               for(int y=0;y<list2.size();y++){
                myWriter.write(list2.get(y).getName()+ "-" + list2.get(y).getQuantity()  + " ");
                
               }
               myWriter.write("\n");
               }
                       
                       
              
                       }
                       else { myWriter.write(line + "\n"); }
   
                       }
                              
                    
                                
                                myWriter.close();
                    
                            } catch (IOException e) {
                                e.printStackTrace();
                                help.setText("Dish is not on the list");
                            }
                
                        }else{
                         help.setText("Dish is not on the list");
                        }
        
                
                                }
            
                        }    
                                             }


}

