/**
 * Priority creates an array with a first in first out style.
 * To add data, you insert O(1)
 * to remove data, you remove O(n)
 *
 * @author Chris Deardeuff
 * @version 8-4-19
 *
 */
public class Priority {
    private int size;
    int last = 0;

    private Country[] priorityQueOfCountries;

    /**
     * Constructor creates the array of length size
     *
     * @param size input to determine length of size
     */
    public Priority(int size) {
        this.size = size;
        priorityQueOfCountries = new Country[size];
        last = -1;
    }

    /**
     * insert will add an object into the array unsorted.
     *
     * @param country
     */
    public void insert(Country country) {
        last++;
        priorityQueOfCountries[last] = country;
    }

    /**
     * remove will remove the element with the highest priority. In this case, GDP per capita
     *
     * @return country with highest priority
     */
    public Country remove() {
        int max = 0;
        Country country = priorityQueOfCountries[0];
        Country lastCountry = priorityQueOfCountries[last];
        for (int i = 0; i < last; i++) {
            Country nextCountry = priorityQueOfCountries[i+1];
            if( country.getGDP()/country.getPopulation() < nextCountry.getGDP()/nextCountry.getPopulation() ){
                country = nextCountry;
                max = i+1;

            }
        }
        if(max != last) {
            Country temp = priorityQueOfCountries[last];
            priorityQueOfCountries[max] = temp;
        }
        priorityQueOfCountries[last] = null;
        last--;
        return country;
    }

    /**
     * printQueue prints queue
     */
    public void printQueue(){

        System.out.println("Name                             Code            Capital         Population      GDP             Happiness Rank   \n" +
                "----------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i <= last; i++){
            Country currentCountry = priorityQueOfCountries[i];
            System.out.printf("%-33s",currentCountry.getName());
            System.out.printf("%-16s",currentCountry.getCountryCode());
            System.out.printf("%-16s",currentCountry.getCapital());
            System.out.printf("%-16s",currentCountry.getPopulation());
            System.out.printf("%-16s",currentCountry.getGDP());
            System.out.printf("%-16s %n",currentCountry.getHappinessRanking());
        }

    }

    /**
     * isEmpty checks if the queue is empty, if it is it returns true
     *
     * @return true if empty, false if not.
     */
    public Boolean isEmpty(){

        return last == -1;
    }

    /**
     * isFull checks if the queue is full, if it is, it returns true
     * @return true if empty, false if not.
     */
    public Boolean isFull() {

        return last == (size - 1);
    }
}
