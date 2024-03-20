/**
 * This represents a Cat
 * Child class of Pet
 * Implements Treatable interface
 * Instance variable hasStripes - whether this Cat has stripes or not
 */
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;

    /**
     * Creates a Cat
     * 4-argument constructor
     * @param name name of this Cat
     * @param age age of this Cat in cat years
     * @param painLevel painLevel of this Cat
     * @param hasStripes whether this Cat has stripes of not
     */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }

    /**
     * Creats a Cat
     * 1-argument contructor
     * @param hasStripes whether this Cat has stripes or not
     * Calls 4-argument contructor above by constructor-chaining
     * name of this Cat = "Purrfect"
     * age of this Cat = 4
     * painLevel of this Cat = 9
     */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    /**
     * Implements playWith method from Pet parent class
     * @param p other Pet this Cat is playing with
     * If both this Cat and p have the same pattern, then decrease this Cats painLevel by 4,
     * and print very happy statement
     * If this Cat and p do not have the same pattern, then decrease this Cats painLevel by 2,
     * and print happy statement
     * If p is a Dog, increase this Cats painLevel by 1, and print angry statement
     */
    public void playWith(Pet p) {
        if (p instanceof Cat) {
            Cat other = (Cat) p;

            if (this.hasStripes == other.getHasStripes()) {
                this.setPainLevel(this.getPainLevel() - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");

            } else if (this.hasStripes != other.getHasStripes()) {
                this.setPainLevel(this.getPainLevel() - 2);
                System.out.println("Meow! I like playing with other cats without the same pattern as me");
            }
        } else if (p instanceof Dog) {
            Dog other = (Dog) p;

            this.setPainLevel(this.getPainLevel() + 1);
            System.out.println("Meow. Go away " + other.getName() + "! I don't like playing with Dogs!");
        }
    }

    /**
     * Overrides equals method from Pet parent class
     * @param o other Object
     * If o is not a Cat, then return false
     * Otherwise, cast o to be a Cat, and compare instance variables to check if they are equal
     * @return result of comparisons of all instance variables of this Cat and o
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) {
            return false;
        }

        Cat other = (Cat) o;
        return (this.getName()).equals(other.getName()) && this.getAge() == other.getAge()
            && this.getPainLevel() == other.getPainLevel() && this.hasStripes == other.getHasStripes();
    }

    /**
     * Implements treat method from Treatable interface
     * Decreases this Cats painLevel by 1
     */
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 1);
    }

    /**
     * getter method for hasStripes
     * @return whether this Cat has stripes or not
     */
    public boolean getHasStripes() {
        return this.hasStripes;
    }

    /**
     * toString method for this Cat
     * @return description of this Cat
     */
    public String toString() {
        return "My name is " + this.getName() + " and I am " + this.getAge()
            + ". On a scale of one to ten my pain level is " + this.getPainLevel()
            + ". My age in human years is " + Treatable.convertCatToHumanYears(this.getAge()) + ".";
    }
}
