/*
 * I worked on the homework assignment alone, using only course materials
 */

/**
 * This class represents a Narwhal
 * Child class of Pet
 * Instance variable hornLength - length of the horn of this Narwhal in feet
 * @author Dean Hiromasa Miyata-Dawson
 * @version 10/28/2023
 */
public class Narwhal extends Pet {
    private int hornLength;

    /**
     * Creates a Narwhal
     * 4-arguement constructor
     * @param name name of this Narwhal
     * @param age age of this Narwhal
     * @param painLevel painLevel of this Narwhal
     * @param hornLength length of the horn of this Narwhal in feet
     * Calls super-constructor in Pet parent class
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }

    /**
     * Creates a Narwhal
     * 0-argument constructor
     * Calls 4-argument constructor from above by contrusctor-chaining
     * name of this Narwhal = "Jelly"
     * age of this Narwhal = 19
     * painLevel of this Narwhal = 2
     * hornLength of this Narwhal = 7
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    /**
     * Implements playWith method from Pet parent class
     * @param p other Pet this Narwhal is playing with
     * If p is another Narwhal, decrease this Narwhals painLevel by 2, and print happy statement
     * If p is not a Narwhal, increase this Narwhals painLevel by 1, and print sad statement
     */
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            this.setPainLevel(this.getPainLevel() - 2);
            System.out.println("Who needs dogs and cats when we have each other");

        } else {
            this.setPainLevel(this.getPainLevel() + 1);
            System.out.println("I live in the ocean so I can't play with you");

        }
    }

    /**
     * Overrides equals method from Pet parent class
     * @param o other Object
     * If o is not a Narwhal, return false
     * Otherwise, cast o to be a Narwhal, and compare all instance variables
     * @return results of comparisons of all instance variables of this Narwhal and o
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Narwhal)) {
            return false;
        }

        Narwhal other = (Narwhal) o;
        return (this.getName()).equals(other.getName()) && this.getAge() == other.getAge()
            && this.getPainLevel() == other.getPainLevel() && this.hornLength == other.getHornLength();
    }

    /**
     * getter method for hornLength
     * @return hornLength of this Narwhal
     */
    public int getHornLength() {
        return this.hornLength;
    }

    /**
     * toString method for this Narwhal
     * @return description of this Narwhal
     */
    public String toString() {
        return "My name is " + this.getName() + " and I am " + this.getAge()
            + ". On a scale of one to ten my pain level is " + this.getPainLevel()
            + ". I have a horn that is " + this.hornLength + " feet long.";
    }
}
