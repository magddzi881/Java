package controllerPackage;

import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;

import  modelPackage.KcalException;

// class used to write a new line of data to a text file

public class AddNewDishToFile {

    
    /** 
     * @param newName
     * @param newKcal
     */
    public void addNewDishToFile(String newName, int newKcal) {
        try {

            if (newKcal < 0) {
                throw new KcalException("Kilocalories must be entered as a positive number");
            } else {

                try {

                    List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));
                    FileWriter myWriter = new FileWriter("dishes.txt");

                    for (String line : allLines) {

                        myWriter.write(line + "\n");

                    }

                    int newId = allLines.size(); // create id for new item

                    myWriter.write(newId + " " + newName + " " + newKcal + "\n");
                    myWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (KcalException ex) {
            ex.printStackTrace();
        }

    }

}
