/**
 * This calss represents a Pet
 * Instance variable name - name of this pet
 * Instance variable age - age of this pet (different system depending on species of pet)
 * Instance variable painLevel - painLevel of this pet
 */
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    /**
     * Creates a pet
     * @param name name of pet
     * @param age age of pet (different system depending on species of pet)
     * @param painLevel pain level of pet
     * If inputted age is less than 1, then age is set to 1
     * If inputted age is more than 100, then age is set to 100
     * If inputted painLevel is less than 1, then painLevel is set to 1
     * If inputted painLevel is more than 10, then painLevel is set to 10
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;

        if (age < 1) {
            this.age = 1;
        } else if (age > 100) {
            this.age = 100;
        } else {
            this.age = age;
        }

        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * abstract method
     * implemented in Dog, Cat, and Narwhal child classes
     * @param p other pet this pet is playing with
     */
    public abstract void playWith(Pet p);

    /**
     * overrides equals method in Object class
     * @param o other Object
     * If o is not a Pet, then return false
     * Otherwise, cast o to be a Pet and compare all instance variables to check if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pet)) {
            return false;
        }

        Pet other = (Pet) o;
        return (this.name).equals(other.getName()) && this.age == other.getAge()
            && this.painLevel == other.getPainLevel();
    }

    /**
     * getter method for name
     * @return name of this Pet
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter method for age
     * @return age of this Pet
     */
    public int getAge() {
        return this.age;
    }

    /**
     * getter method for painLevel
     * @return painLevel of this Pet
     */
    public int getPainLevel() {
        return this.painLevel;
    }

    /**
     * setter method for painLevel
     * @param painLevel new painLevel of this Pet instance
     * If inputted painLevel is less than 1, then painLevel is set to 1
     * If inputted painLevel is more than 10, then painLevel is set to 10
     */
    public void setPainLevel(int painLevel) {
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }

    /**
     * toString method for this Pet
     * @return description of this Pet
     */
    public String toString() {
        return "My name is " + this.name + " and I am " + this.age
            + ". On a scale of one to ten my pain level is " + this.painLevel + ".";
    }
}
