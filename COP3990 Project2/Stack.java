/**
 * Stack creates an array that has a first in, last out data calling format
 * to add data, you push
 * to remove data, you pop
 *
 * @author Chris Deardeuff
 * @version 9-4-19
 *
 **/
public class Stack {
    boolean isEmpty = false;
    boolean isFull = false;
    private int size;
    int top;
    private Country[] stackOfCountries;

    /**
     * Constructor takes in a size and creates a stack of that size
     *
     * @param size size of needed array
     */
    public Stack(int size){
        this.size = size;
        stackOfCountries = new Country[size];
        top = -1;
    }

    /**
     * push adds an inputted object to end of the stack
     *
     * @param pushed a Country object
     */
    public void push(Country pushed){
        if(!isFull(top)){
            top++;
            stackOfCountries[top] = pushed;
        }
    }

    /**
     * pop removes last element from the stack
     *
     * @return last element of the stack
     */
    public Country pop(){
        if(!isEmpty(top)){
            return stackOfCountries[top];
        }
        return null;
    }

    /**
     * isEmpty checks if the stack has 0 elements in it
     *
     * @param top
     * @return true if empty, false if not
     */
    private Boolean isEmpty(int top){

        return top == -1;
    }

    /**
     * isFull checks if the stack has any space left
     *
     * @param top
     * @return false, if full. True if space is available.
     */
    private Boolean isFull(int top) {

        return top == (size - 1);
    }

    /**
     * printStack prints the elements inside of the Stack.
     */
    public void printStack(){

        System.out.println("Name                             Code            Capital         Population      GDP             Happiness Rank   \n" +
                "----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i <= top ; i++) {
            Country currentCountry = stackOfCountries[i];
            System.out.printf("%-33s",currentCountry.getName());
            System.out.printf("%-16s",currentCountry.getCountryCode());
            System.out.printf("%-16s",currentCountry.getCapital());
            System.out.printf("%-16s",currentCountry.getPopulation());
            System.out.printf("%-16s",currentCountry.getGDP());
            System.out.printf("%-16s %n",currentCountry.getHappinessRanking());
        }

    }

}
