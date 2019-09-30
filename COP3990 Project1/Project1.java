import java.io.*;
import java.util.Scanner;

/**
 * COP 3538: Project 1 – Array Searches and Sorts
 * <p>
 * Class containing main function which takes in a file and reads it.
 * After parsing the file into separate countries it prompts the user
 * what they would like to do.
 * <p>
 * Each user input results in a search or sorting algorithm which is contained
 * in this class
 *
 * @author Chris Deardeuff
 * @version 9/15/19
 */

public class Project1 {

    /**
     * Main reads and parses the file, prompts the user, and prints resulting outputs
     *
     *
     * @param args
     */
    public static void main(String[] args) {


        boolean quit = false;
        boolean sortedtByName = false;
        //array of countries
        Country[] countryArray = new Country[155];
        //User input scanner
        Scanner userInput = new Scanner(System.in);
        int index = 0;


        System.out.print("COP 3990 Project 1\n" +
                "Student: Chris Deardeuff N01385436 \n\n" +
                "Array Searches and Sorts\n" +
                "Please Type File Name:");
        userInput.nextLine();

        //file name variable
        File filePath = new File("Countries1.csv");



        //Read in CSV file and populate array with countries
        try {

            Scanner fileInput = new Scanner(new FileReader(filePath));
            //skip the first line, the legend.
            fileInput.nextLine();
            while (fileInput.hasNextLine()) {

                fileInput.useDelimiter(",|"  + System.getProperty("line.separator"));
                countryArray[index] =
                        new Country(fileInput.next(),fileInput.next(),fileInput.next(),Integer.parseInt(fileInput.next()),
                                 Double.parseDouble(fileInput.next()),Integer.parseInt(fileInput.next()));

                 index++;
                 fileInput.nextLine();
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        }


        do{
        System.out.print("1: Print a Countries Report\n2: Sort by Name\n3: Sort by Happiness\n" +
                "4: Sort by GDP per capita\n5: Find and print a given country\n6: Quit\n Enter your choice:\n ");

        switch (userInput.nextLine()){

            case "1":
                //print array of countries
                printArrayOfCountries(countryArray);
                break;
            case "2":
                //sort by name(use bubble sort)
                sortByName(countryArray);
                sortedtByName = true;
                System.out.println("Countries Sorted by Name");
                break;
            case "3":
                //sort by Happiness(using selection)
                sortByHappiness(countryArray);
                sortedtByName = false;
                System.out.println("Countries Sorted by Happiness");
                break;
            case "4":
                //sort by GDP (insertion sort)
                sortByGDP(countryArray);
                sortedtByName = false;
                System.out.println("Countries Sorted by GDP");
                break;
            case "5":
                findCountry(countryArray, sortedtByName);
                break;
            case "6":
                //exit program
                System.out.println("Exiting program");
                userInput.close();
                quit = true;
                break;
            default:
                    System.out.println("Please Enter a valid option (1,2,3,4,5, or 6)");
            }
        }while (!quit);
    }

    /**
     * sortByName will sort the array of countries into
     * alphabetical order based on their names.
     * Bubble sort is used to sort the array.
     *
     * @param countryArray
     */
    private static void sortByName(Country[] countryArray) {


        for (int i = 0; i < countryArray.length ; i++) {
            for (int j = i+1; j < countryArray.length - 1; j++) {
                if(countryArray[i].getName().compareTo(countryArray[j].getName()) > 0){
                    Country tempCountry = countryArray[j];
                    countryArray[j] = countryArray[i];
                    countryArray[i] = tempCountry;
                }
            }
        }

    }

    /**
     * sortByHappiness method sorts the country array by the GDP
     * in descending order. Selection Sort is used to sort the Array.
     *
     * @param countryArray
     */
    private static void sortByHappiness(Country[] countryArray) {

        for (int i = 0; i < countryArray.length -1; i++) {
            int lowest = i;
            for (int j = i+1; j < countryArray.length ; j++) {
                if(countryArray[j].getHappinessRanking() < countryArray[lowest].getHappinessRanking()){
                    lowest = j;
                }
            }
            if(lowest != i){
                 Country temp = countryArray[lowest];
                 countryArray[lowest] = countryArray[i];
                 countryArray[i] = temp;
            }

        }
    }

    /**
     * sortByGDP sorts the array of countries by GDP using insertion sort.
     * @param countryArray
     */
    private static void sortByGDP(Country[] countryArray) {
        for (int i = 0; i < countryArray.length; i++) {
            Country temp = countryArray[i];
            int inner = i -1;
            while(inner >= 0 && countryArray[inner].getGDP() < temp.getGDP()){
                countryArray[inner+1] = countryArray[inner];
                inner --;
            }
            countryArray[inner+1] = temp;
        }
    }

    /**
     * findCountry finds a country based on a user's imputed name.
     * If the array is sorted, binary search is used.
     * If the array is not sorted, sequential search is used.
     *
     * @param countryArray
     * @param sortedByName
     */
    private static void findCountry(Country[] countryArray, Boolean sortedByName){
        System.out.print("Please enter a country name: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.next();

        if(sortedByName == true){
            System.out.println("Binary Search");

            int max = countryArray.length -1;
            int min = 0;
            int middle;

            while(min <= max) {
                middle = (max + min) / 2;
                if(countryArray[middle].getName().equalsIgnoreCase(userInput)){
                    System.out.println(countryArray[middle].toString());
                    break;
                }else if(countryArray[middle].getName().compareTo(userInput) < 0){
                    min = middle + 1;
                }else{
                    max = middle - 1;
                }
            }


        }else{
            System.out.println("Sequential Search");

            for (int i = 0; i < countryArray.length ; i++) {
                if(countryArray[i].getName().equalsIgnoreCase(userInput)){
                    System.out.println(countryArray[i].toString());
                }
            }
        }
    }

    /**
     * printArrayOfCountries is used to print the full list of countries.
     *
     * @param countryArray
     */
    public static void printArrayOfCountries(Country[] countryArray){

        System.out.println("Name                             Code            Capital         Population      GDP             Happiness Rank   \n" +
                           "----------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < countryArray.length; i++) {
            System.out.printf("%-33s",countryArray[i].getName());
            System.out.printf("%-16s",countryArray[i].getCountryCode());
            System.out.printf("%-16s",countryArray[i].getCapital());
            System.out.printf("%-16s",countryArray[i].getPopulation());
            System.out.printf("%-16s",countryArray[i].getGDP());
            System.out.printf("%-16s %n",countryArray[i].getHappinessRanking());
        }

    }
}
