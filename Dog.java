/**
 * This class represents a Dog
 * Child class of Pet
 * Implements Treatable interface
 * Instance variable breed - breed of this Dog
 */
public class Dog extends Pet implements Treatable {
    private String breed;

    /**
     * Creates a Dog
     * 4-argument constructor
     * @param name name of this Dog
     * @param age age of this Dog in dog years
     * @param painLevel painLevel of this Dog
     * @param breed breed of this Dog
     * Calls super-constructor in Pet parent class
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    /**
     * Creates a Dog
     * 1-argument constructor
     * @param breed breed of this Dog
     * Calls 4-argument constructor from above by constructor-chaining
     * name of this Dog = "Buzz"
     * age of this Dog = 6
     * painLevel of this Dog = 3
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    /**
     * Implements playWith method from Pet parent class
     * @param p other Pet this Dog is playing with
     * If p is also a Dog, then this Dogs painLevel decreases by 3, and print very happy statement
     * If p is a cat without stripes, then this Dogs painLevel decreases by 1, and print happy statement
     * If p is a cat with stripes, then this Dogs painLevel increases by 2, and print scared statement
     */
    @Override
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            int oldPainLevel = this.getPainLevel();
            this.setPainLevel(this.getPainLevel() - 3);
            System.out.println("Woof! I love playing with other dogs so much that my pain level went from "
                + oldPainLevel + " to " + this.getPainLevel());

        } else if (p instanceof Cat) {
            Cat cat = (Cat) p;

            if (!(cat.getHasStripes())) {
                int oldPainLevel = this.getPainLevel();
                this.setPainLevel(this.getPainLevel() - 1);
                System.out.println("Woof. Cats without stripes are okay since they made my pain level go from "
                    + oldPainLevel + " to " + this.getPainLevel());

            } else if (cat.getHasStripes()) {
                this.setPainLevel(this.getPainLevel() + 2);
                System.out.println("AHHH! I thought you were a tiger!");
            }
        }
    }

    /**
     * Overrides equals method from Pet parent class
     * @param o other Object
     * If o is not a Dog, then return false
     * Otherwise, cast o to be a Dog and compare all instance variables to check if they are equal
     * @return results of comparisons of all instance variables of this Dog and o
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog)) {
            return false;
        }

        Dog other = (Dog) o;
        return this.getName().equals(other.getName()) && this.getAge() == other.getAge()
            && this.getPainLevel() == other.getPainLevel() && (this.breed).equals(other.getBreed());
    }

    /**
     * Implements treat method from Treatable interface
     * Decreases this Dogs painLevel by 3
     */
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 3);
    }

    /**
     * Bark method
     * return "bark bark"
     */
    public void bark() {
        System.out.println("bark bark");
    }

    /**
     * getter method for breed
     * @return breed of this Dog
     */
    public String getBreed() {
        return this.breed;
    }

    /**
     * toString method for this Dog
     * @return description of this Dog
     */
    public String toString() {
        return "My name is " + this.getName() + ", I am " + this.getAge()
            + ", and I am a " + this.breed + ". On a scale of one to ten my pain level is "
            + this.getPainLevel() + ". My age in human years is "
            + Treatable.convertDogToHumanYears(this.getAge()) + ".";
    }
}
