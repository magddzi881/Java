package controllerPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/** get total kilocalories per one meal*/ 

public class GetOneMealKcalData {

    
    /** 
     * @param id
     * @return Integer
     */
    /** returns total kcal per dish, using its id*/ 
    public Integer getOneMealKcalData(int id) {

        int result = 0;
        try {

            List<String> allLines = Files.readAllLines(Paths.get("dishes.txt"));
            String lineFromFile = allLines.get(id);
            String[] splitedTextLine = lineFromFile.split(" ");
            String nameFromFile = splitedTextLine[1];
            String kcalFromFile = splitedTextLine[2];

            System.out.println("\n" + nameFromFile + " selected" + "\n");

            Scanner scan = new Scanner(System.in);
            System.out.print("Total meal grams: ");
            int myMealGrams = scan.nextInt();
            double mealKcalPerOneGram = Double.parseDouble(kcalFromFile) / 100;

            double totalKcal = mealKcalPerOneGram * myMealGrams;

            result = (int) totalKcal; // convert result to int

        } catch (IOException e) {

            e.printStackTrace();
        }

        return result;

    }

}
