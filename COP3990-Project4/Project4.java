
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 *
 * Project 4 will read in countries from a file and add them to a Binary Search Tree.
 *
 * @author Chris Deardeuff
 * @version 11/17/19
 *
 **/
public class Project4 {
    /**
     * <p>
     * Main will read in countries from a file and perform operations with the country objects using queues and stacks
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) {

        //Variables
        int pass = 1;
        int index = 0;
        Country[] countryArray = new Country[155];
        String filename = "";
        Scanner userInput = new Scanner(System.in);
        Boolean fileFound = false;

        //read in countries
        while (!fileFound) {
            try {
                System.out.print("COP 3990 Project 4\n" +
                        "Student: Chris Deardeuff N01385436 \n" +
                        "Binary Search Trees\n" +
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
        //create BST
        BinarySearchTree bst = new BinarySearchTree();

        //insert countries into Binary Search Tree
        for (int i = 0; i < countryArray.length; i++) {
            bst.insert(countryArray[i].getName(),(countryArray[i].getGDP()/countryArray[i].getPopulation()));
        }
        //traverse and print in order
        System.out.println("\nIn Order Traversal...");
        

        System.out.println("Name             GDP Per Capita");
        System.out.println("===============================");
        bst.printInOrder();

        //delete 3 countries
        bst.delete("Australia");
        System.out.println("\n\nAustralia has been deleted from tree");
        
        bst.delete("Tunisia");
        System.out.println("Tunisia has been deleted from tree");
        
        bst.delete("Norway");
        System.out.println("Norway has been deleted from tree");
        

        System.out.println("\nPre Order Traversal...");

        System.out.println("Name             GDP Per Capita");
        System.out.println("===============================");
        bst.printPreOrder();


        //search for 3 countries
        double found = bst.find("Sri Lanka");
        if(found == -1){
            System.out.println("Sri Lanka Not Found");
        }else{
            System.out.println("Sri Lank Found with GDP per Capita " + found);
        }
        found = bst.find("North Cyprus");
        if(found == -1){
            System.out.println("North Cyprus Not Found");
        }else{
            System.out.println("North Cyprus Found with GDP per Capita " + found);
        }
        found = bst.find("Tunisia");
        if(found == -1){
            System.out.println("North Cyprus Not Found");
        }else{
            System.out.println("North Cyprus Found with GDP per Capita " + found);
        }

        //delete 5 countries
        bst.delete("Malawi");
        System.out.println("\n\nMalawi has been deleted from tree");
        bst.delete("Somolia");
        System.out.println("Somalia has been deleted from tree");
        bst.delete("Ireland");
        System.out.println("Ireland has been deleted from tree");
        bst.delete("Greece");
        System.out.println("Greece has been deleted from tree");
        bst.delete("Singapore");
        System.out.println("Singapore has been deleted from tree");

        //postOrderPrint the remaining tree
        System.out.println("\nPost Order Traversal...");

        System.out.println("Name             GDP Per Capita");
        System.out.println("===============================");
        bst.printPostOrder();

        //print bottom ten and top ten
        System.out.println("\nBottom Ten...");

        System.out.println("Name             GDP Per Capita");
        System.out.println("===============================");
        bst.printBottomTen();

        System.out.println("\nTop Ten...");

        System.out.println("Name             GDP Per Capita");
        System.out.println("===============================");
        bst.printTopTen();


        

    }
}
