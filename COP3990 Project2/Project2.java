import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * COP 3538: Project 2 – Stacks and Priority Queues
 * <p>
 *     Class containing main which takes a file of countries and sorts them by GDP per capita,
 *     loads them all into a stack, and prints.
 * </p>
 *
 * @author Chris Deardeuff
 * @version 8-4-19
 **/
public class Project2 {

    /**
     * Main method
     *
     * takes a file of countries and sorts them by GDP per capita,
     * loads them all into a stack, and prints.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Variables
        int size = 155;
        int index = 0;
        Country[] countryArray = new Country[155];
        String filename = "";
        Scanner userInput = new Scanner(System.in);
        Boolean fileFound = false;

        //Priority Queues and Stacks
        Priority poorPriorityQue = new Priority(size);
        Priority fairPriorityQue = new Priority(size);
        Priority goodPriorityQue = new Priority(size);
        Priority veryGoodPriorityQue = new Priority(size);
        Priority excellentPriorityQue = new Priority(size);
        Stack stack = new Stack(size);

        //Read in CSV file and populate array with countries
        while (!fileFound) {
            try {
                System.out.print("COP 3990 Project 2\n" +
                        "Student: Chris Deardeuff N01385436 \n" +
                        "Array Stacks and Queues\n" +
                        "Please Type File Name:");
                filename = userInput.nextLine();
                Scanner fileInput = new Scanner(new FileReader(filename));
                //skip the first line, the legend.
                fileInput.nextLine();
                while (fileInput.hasNextLine()) {

                    fileInput.useDelimiter(",|" + System.getProperty("line.separator"));
                    countryArray[index] =
                            new Country(fileInput.next(), fileInput.next(), fileInput.next(), Integer.parseInt(fileInput.next()),
                                    Double.parseDouble(fileInput.next()), Integer.parseInt(fileInput.next()));

                    index++;
                    fileInput.nextLine();
                }
                fileInput.close();
                fileFound = true;
            } catch (FileNotFoundException e) {
                System.out.println("\nFile not found! Please try again...\n\n");
                fileFound = false;
            }
        }
        //sort and put countries in queues based on GDP per capita
        for (Country country : countryArray) {

            double GDPPerCapita = (country.getGDP() / country.getPopulation());

            if (GDPPerCapita < 1000.0) {
                //poor
                poorPriorityQue.insert(country);
            } else if (GDPPerCapita >= 1000.0 && GDPPerCapita < 5000.0) {
                //fair
                fairPriorityQue.insert(country);
            } else if (GDPPerCapita >= 5000.0 && GDPPerCapita < 20000.0) {
                //good
                goodPriorityQue.insert(country);
            } else if (GDPPerCapita >= 20000.0 && GDPPerCapita < 50000.0) {
                //VERYGood
                veryGoodPriorityQue.insert(country);
            } else if (GDPPerCapita >= 50000) {
                //Excellent
                excellentPriorityQue.insert(country);
            }
        }
        //PRINT QUEUES IN ORDER FROM POOR TO EXCELLENT
        System.out.println("\nPrinting Poor Queue:");
        poorPriorityQue.printQueue();

        System.out.println("\nPrinting Fair Queue:");
        fairPriorityQue.printQueue();

        System.out.println("\nPrinting Good Queue:");
        goodPriorityQue.printQueue();

        System.out.println("\nPrinting Very Good Queue:");
        veryGoodPriorityQue.printQueue();

        System.out.println("\nPrinting Excellent Queue:");
        excellentPriorityQue.printQueue();

        //ADD FROM QUEUES TO STACKS

        while (!poorPriorityQue.isEmpty()){
            Country country = poorPriorityQue.remove();
            stack.push(country);
        }

        while (!fairPriorityQue.isEmpty()){
            Country country = fairPriorityQue.remove();
            stack.push(country);
        }

        while (!goodPriorityQue.isEmpty()){
            Country country = goodPriorityQue.remove();
            stack.push(country);
        }

        while (!veryGoodPriorityQue.isEmpty()){
            Country country = veryGoodPriorityQue.remove();
            stack.push(country);
        }


        while (!excellentPriorityQue.isEmpty()){
            Country country = excellentPriorityQue.remove();
            stack.push(country);
        }
        //Print Stack and Exit
        System.out.println("\nPrinting Stack:");
        stack.printStack();
    }

}