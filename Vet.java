/**
 * This class represents the vet
 */
public class Vet {
    /**
     * Static method to inspect Pet
     * @param pet Pet being inspected
     * If pet is a Dog, then call bark method
     * Print toString method of pet
     */
    public static void inspectPet(Pet pet) {
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.bark();
        }

        System.out.println(pet.toString());
    }

    /**
     * Static method to treat Pet
     * @param pet Pet being treated
     * If pet is Treatable, then print greeting
     * If pet is a Cat, then do treatment for Cats
     * If pet is a Dog, then do treatment for Dogs, print cute statement, give Dog a treat
     * Else, print that pet is not Treatable
     */
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.getName());

            if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                cat.treat();
            }

            if (pet instanceof Dog) {
                System.out.println("Wow what a cute dog!");
                Dog dog = (Dog) pet;
                dog.treat();
                giveDogTreat(dog);
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }

    /**
     * Static method to give a Dog a treat
     * @param dog Dog getting a treat
     * Call setter method for painLevel to decreases painLevel of this Dog by 2
     */
    public static void giveDogTreat(Dog dog) {
        dog.setPainLevel(dog.getPainLevel() - 2);
    }
}
