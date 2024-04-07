package Assignment4.Assignment4_1;

import java.util.Scanner;
import java.text.NumberFormat;

public class ShippingCalculator {

    public static void main(String[] args) {
        //set up the helper objects
        Scanner input = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // main program
        System.out.println("*** The Secret Service Shipping Co. ***");

        String cont = "y";
        while (cont.equalsIgnoreCase("y")) {
            // get input for shipping weight
            System.out.print("\nEnter package weight: ");
            double packageWeight = input.nextDouble();

            // get input for shipping distance
            System.out.print("Enter distance to ship: ");
            double shippingMiles = input.nextDouble();

            // figure out shipping cost via package weight
            double packageCost;
            if (packageWeight <= 2) {
                packageCost = 1.36;
            }
            else if (packageWeight <= 5) {
                packageCost = 3.48;
            }
            else if (packageWeight <= 8) {
                packageCost = 5.12;
            }
            else if (packageWeight <= 12) {
                packageCost = 8.99;
            }
            else if (packageWeight <= 20) {
                packageCost = 13.58;
            }
            else {
                packageCost = 25.36;
            }

            // calculate the standard shipping cost
            double shippingCost = (double)Math.round(shippingMiles/100 * packageCost * 100) / 100;

            String output = "\nStandard Shipping Cost:  " + currency.format(shippingCost)+"\n";

            // create and add to the total
            double totalCost = shippingCost;

            // adding any extras to the shipping of a package
            double insuranceCost = (double)Math.round(shippingCost * .10 * 100)/100;
            double wePackCost = (double)Math.round(packageWeight * .786 * 100)/100;
            double priorityCost = (double)Math.round(shippingCost * .34 * 100)/100;
            int choice = 0;
            while (choice != 4) {
                System.out.println("\n** Extras to the shipping **");
                System.out.println("1. Insurance         + " + currency.format(insuranceCost));
                System.out.println("2. We Pack It        + " + currency.format(wePackCost));
                System.out.println("3. Priority Shipping + " + currency.format(priorityCost));
                System.out.println("4. Done");

                System.out.print("Option: ");
                choice = input.nextInt();

                while (choice < 1 || choice > 4) {
                    System.out.print("Invalid Option.\nOption: ");
                    choice = input.nextInt();
                }

                // check the option, add to the output and totalCost.
                // we are assuming it will only be added once so once selected don't do again.
                switch (choice) {
                    case 1 -> {
                        output += "Insurance:               " + currency.format(insuranceCost) + "\n";
                        totalCost += insuranceCost;
                    }
                    case 2 -> {
                        output += "We Pack It:              " + currency.format(wePackCost) + "\n";
                        totalCost += wePackCost;
                    }
                    case 3 -> {
                        output += "Priority Shipping:       " + currency.format(priorityCost)+"\n";
                        totalCost += priorityCost;
                    }
                }
                System.out.println(); //blank line between loops
            }

            // print out the overall total of shipping
            output += "\nTotal Cost:              " + currency.format(totalCost);
            System.out.println(output);


            // calculate again or close
            System.out.print("Calculate again?(y/n): ");
            cont = input.next();
        }

    }
}
