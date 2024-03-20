/**
 * This represents an interface Treatable
 */
public interface Treatable {
    /**
     * Converts age in dog years to age in human years
     * @param dogAge age of dog in dog years
     * @return age of dog in human years
     */
    static int convertDogToHumanYears(int dogAge) {
        int humanAge = (int) (16 * Math.log(dogAge) + 31);
        return humanAge;
    }

    /**
     * Converts age in cat years to age in human years
     * @param catAge age of cat in cat years
     * @return age of cat in human years
     */
    static int convertCatToHumanYears(int catAge) {
        int humanAge = (int) (9 * Math.log(catAge) + 18);
        return humanAge;
    }

    /**
     * Abstract method, implemented in Dog and Cat classes
     */
    void treat();
}
