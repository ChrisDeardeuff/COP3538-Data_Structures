/**
 * Country class allows a country object to be created.
 * The object holds the Name, Country Code,
 * Capital, GDP, and Happiness Ranking.
 *
 * @Author Christopher Deardeuff
 * @Version 9/15/19
 */


public class Country {
    private String name;
    private String countryCode;
    private String capital;
    private int population;
    private double GDP;
    private int happinessRanking;

    /**
     * compare country will compare two countries by name
     *
     * @param country
     * @return int difference of name.
     */
    public int compareCountry(Country country){

        return country.getName().compareTo(this.name);
    }

    /**
     *
     * Constructor creates and updates a Country object
     *
     *
     * @param name Name of country
     * @param countryCode Code of country
     * @param capital Name of countries capital
     * @param population Current population of country
     * @param GDP Gross Domestic Product is the monetary measure of the market value of all the final goods and services.
     * @param happinessRanking Happiness of countries as ranked by worldhappinessreport.
     */
    public Country(String name, String countryCode, String capital, int population, double GDP, int happinessRanking) {
        this.name = name;
        this.countryCode = countryCode;
        this.capital = capital;
        this.population = population;
        this.GDP = GDP;
        this.happinessRanking = happinessRanking;
    }

    /**
     * getName, when called, returns the
     * current name of the country.
     *
     * @return name Name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * setName, when called, sets the class
     * variable name to the input variable.
     *
     * @param name of the country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getCountryCode, when called, returns the
     * current country code.
     *
     * @return countryCode Country Code is the assigned code to the country.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * setCountryCode, when called, sets the class
     * variable countryCode to the input variable code.
     *
     *
     * @param code
     */
    public void setCountryCode(String code) {
        this.countryCode = code;
    }

    /**
     * getCapital returns the capital of the object
     *
     * @return capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * setCapital sets the class variable to the value
     * of the input variable.
     *
     * @param capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     *
     * getPopulation returns the population of the object
     *
     * @return population
     */
    public int getPopulation() {
        return population;
    }

    /**
     *setPopulation sets the population to the passed variable
     *
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     *getGDP returns the GDP of the object
     *
     * @return GDP
     */
    public double getGDP() {
        return GDP;
    }

    /**
     *setGDP sets the GDP to the passed variable
     *
     * @param GDP
     */
    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    /**
     *getHappinessRanking returns the happiness ranking of the object
     *
     * @return happinessRanking
     */
    public int getHappinessRanking() {
        return happinessRanking;
    }

    /**
     *
     * setHappinessRanking sets the happinessRanking to the passed Variable
     *
     * @param happinessRanking
     */
    public void setHappinessRanking(int happinessRanking) {
        this.happinessRanking = happinessRanking;
    }

    /**
     *toString converts the object to a string to be printed.
     *
     * @return object in string form
     */
    @Override
    public String toString() {
        return "\nName:             " +name+
                "\nCode:             " +countryCode+
                "\nCapital:          " +capital+
                "\nPopulation:       " + population +
                "\nGDP:              " + GDP +
                "\nHappiness Rank:   " + happinessRanking + "\n";
    }
}
