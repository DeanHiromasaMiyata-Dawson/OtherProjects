import java.util.Scanner;

public class Giveaway {

    /**

     * Checks if inventory is empty (as in full of x's).

     * @param inventory to check the inventory is empty or not.

     * @return a boolean value of true if empty, and false if there are still items in the inventory.

     */

    public static boolean isEmpty(final String[][] inventory) {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (!(inventory[i][j].equals("x"))) {

                    return false;

                }

            }

        }



        return true;

    }

    /**

     * Runs main.

     * @param args takes input.

     */

    public static void main(String[] args) {

        String[][] inventory = {

            {"x", "x", "StuffedPython", "x", "CSalt"},

            {"hAIrspray", "x", "x", "x", "x"},

            {"x", "x", "x", "JavaBeans", "x"},

            {"x", "RustedMetal", "SwiftShoes", "x", "x"},

            {"FuRniture", "x", "x", "GroovyGear", "RadiantRuby"}

        };



        System.out.println("Welcome to the 1331 Giveaway!");

        Scanner input = new Scanner(System.in);



        checkDecision(input, inventory);

        return;

    }



    /**

     * Prints the inventory

     * @param inventory is the inventory when this method is called

     */

    public static void showInventory(String[][] inventory) {

        for (int k = 0; k < 5; k++) {

            for (int w = 0; w < 5; w++) {

                System.out.print("|" + inventory[k][w]);

            }

            System.out.print("|\n");

        }

    }



    /**

     * Asks the user whether they would like to take an item from the inventory

     * @param input records user input

     * @param inventory is the inventory

     */

    public static void checkDecision(final Scanner input, final String[][] inventory) {

        System.out.println("\nWould you like to take an item? [Y]es, [N]o, or [E]xit");

        String decision = input.nextLine();



        System.out.println();



        if (validDecision(decision, input, inventory)) {

            decisionResult(decision, input, inventory);

        }



        return;

    }



    /**

     * Checks the users input to see if they inputed a valid decision (as in 'Y', 'N', or 'E')

     * @param decision is the user's decision

     * @param input keeps a record of the user's input

     * @param inventory is the current inventory

     * @return will return if user inputed a valid decision or not

     */

    public static boolean validDecision(final String decision, final Scanner input, final String[][] inventory) {

        if (decision.equals("Y") || decision.equals("N") || decision.equals("E")) {

            return true;

        } else {

            System.out.println("Please input 'Y', 'N', or 'E'");

            checkDecision(input, inventory);

            return false;

        }

    }



    /**

     * Decides what to do as a result of the user's decision

     * @param decision is the user's decision

     * @param input keeps a record of the user's input

     * @param inventory is the current inventory

     */

    public static void decisionResult(final String decision, final Scanner input, final String[][] inventory) {

        if (decision.equals("Y")) {

            showInventory(inventory);

            yes(inventory, input);

            return;



        } else if (decision.equals("N")) {

            System.out.println("Next person in line!");

            checkDecision(input, inventory);



        } else if (decision.equals("E")) {

            exit();

        }

    }

    /**

     * What happens when user decides they want to take an item from the inventory

     * @param inventory is the current inventory

     * @param input keeps a record of the user's input

     */

    public static void yes(String[][] inventory, Scanner input) {

        System.out.println("\nWhat item are you interested in taking?");

        int row = input.nextInt();

        int col = input.nextInt();

        input.nextLine();



        System.out.println();



        checkItem(input, row, col, inventory);



        if (isEmpty(inventory)) {

            return;

        }

    }

    /**

     * Checks to see if there is an item where the user asked to take an item from

     * @param input keeps a reocrds of the user's input

     * @param row is the row the user decided to take an item from

     * @param col is the column the user decided to take an item from

     * @param inventory is the current inventory

     */

    public static void checkItem(Scanner  input, int row, int col, String[][] inventory) {

        if (row < 0 || row > 4 || col < 0 || col > 4) {

            System.out.println("Location does not exist.");

            yes(inventory, input);



        } else if (inventory[row][col].equals("x")) {

            System.out.println("There is no item in this location.");

            yes(inventory, input);



        } else if (!inventory[row][col].equals("x")) {

            System.out.println("\nYou successfully took the " + inventory[row][col] + "!");

            System.out.println();



            inventory[row][col] = "x";



            showInventory(inventory);

            checkDecision(input, inventory);

        }

    }



    /**

     * What happens if the user decides to exit the giveaway

     * @return will return that user decided to exit the giveaway

     */

    public static boolean exit() {

        System.out.println("Have a good day!");

        return true;

    }

}

