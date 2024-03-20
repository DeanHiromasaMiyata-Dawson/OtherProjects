import java.util.Scanner;

import java.text.DecimalFormat;



public class TravelBuddy {

    public static void main (String[] args) {

        double cost = 0.00;

        DecimalFormat df = new DecimalFormat("0.00");



        Scanner input = new Scanner(System.in);

        System.out.print("Welcome to Travel Buddy Service! Please enter your name here: ");

        String name = input.nextLine();



        String correctName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();

        

        System.out.println("The Hive - $6.00 \nInvention Studio - $7.50 \nKlaus - $6.90 \nCULC - $3.20");

        System.out.println();



        System.out.println("Where would you like to go, " + correctName + "?");

        String destination = input.nextLine();

        System.out.println();



        

        

        switch (destination) {

            case "The Hive":

                cost += 6.00;

                break;

            

            case "Invention Studio":

                cost += 7.50;

                break;

            

            case "Klaus":

                cost += 6.90;



                System.out.println("Would you like to stop by Chick-fil-a on the way? (Yes/No)");

                String klausChickFilA = input.nextLine();



                if (klausChickFilA.equals("Yes")) {

                    cost *= 1.5;

                    break;

                } else if (klausChickFilA.equals("No")){

                    break;

                } else {

                    return;

                }

            

            case "CULC":

                cost += 3.20;

                System.out.println("Would you like to stop by Chick-fil-a on the way? (Yes/No)");

                String culcChickFilA = input.nextLine();

                

                if (culcChickFilA.equals("Yes")) {

                    cost *= 1.5;

                    break;

                } else if (culcChickFilA.equals("No")) {

                    break;

                } else {

                    return;

                }

            

            default:

                System.out.println("That destination is invalid, goodbye!");

                return;  

        }



        System.out.println();

        System.out.println("Your current total is $" + df.format(cost));



        System.out.println("Do you have a discount? (Yes/No)");

        String discount = input.nextLine();



        System.out.println();



        if (discount.equals("Yes")) {

            System.out.println("What is the discount code?");

            String discountCode = input.nextLine();

            

            System.out.println();

            

            if (discountCode.equals("CS1331")) {

                cost *= 0.75;

                System.out.println("You have received 25% off your ride!");



            } else if (discountCode.equals("IKNOWTHEOWNER")) {

                System.out.println("How much would you like to take off?");



                if (input.hasNextDouble()) {

                    double discountAmount = input.nextDouble();



                    if (cost - discountAmount >= 0) {

                    System.out.println("Taking off $" + df.format(discountAmount) + " from your total...");

                    cost -= (discountAmount);



                    } else if ((cost - discountAmount) < 0) {

                    System.out.println("Taking off $" + df.format(discountAmount) + " from your total...");

                    cost = 0.00;

                    }

                } else {

                    System.out.println("Taking off $1.00 from your total...");

                    cost -= 1.00;

                }



            } else {

            System.out.println("That discount does not exist! Better luck next time!");

            }

        }



        System.out.println();

        System.out.println("Thank you for riding with the Travel Buddy Service, " + correctName + "! You are now $" + df.format(cost) + " poorer! We hope you ride with us again!");

    }

}
