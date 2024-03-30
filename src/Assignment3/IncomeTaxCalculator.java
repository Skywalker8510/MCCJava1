package Assignment3;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 3/28/2024
//Resources: Canvas page, Stack overflow

// Java program to Calculate income tax from user inputs

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> grossPayArray = new ArrayList<Integer>();
        ArrayList<Integer> children = new ArrayList<Integer>();
        ArrayList<Integer> otherDependents = new ArrayList<Integer>();
        ArrayList<Double> taxArray = new ArrayList<Double>();
        ArrayList<Integer> taxAmount = new ArrayList<Integer>();
        DecimalFormat df = new DecimalFormat("###,###,###.##");

        String userInput = "y";
        while(userInput.equalsIgnoreCase("y")) {

            grossPayArray.clear();
            children.clear();
            otherDependents.clear();
            taxArray.clear();
            taxAmount.clear();

            System.out.println("**** Income Tax Calculator ****");

            System.out.print("Enter number of people to calculate for: ");
            int numberOfPeople = scan.nextInt();
            System.out.println();

            for (int i = 0; i < numberOfPeople; i++) {

                System.out.print("Enter gross pay for employee " + (i + 1) + ": ");
                int grossPay = scan.nextInt();

                while (grossPay < 0) {

                    System.out.println("Error, Pay must be positive.");

                    System.out.print("Enter gross pay for employee " + (i + 1) + ": ");
                    grossPay = scan.nextInt();
                    System.out.println();

                }

                grossPayArray.add(grossPay);

                if (grossPayArray.get(i) < 200000) {
                    System.out.print("Enter number of children: ");
                    children.add(scan.nextInt());
                    System.out.print("Enter number of other dependents: ");
                    otherDependents.add(scan.nextInt());
                    System.out.println();

                } else {
                    children.add(0);
                    otherDependents.add(0);
                }

                double tax;

                if (0 <= grossPayArray.get(i) && grossPayArray.get(i) <= 11000) {
                    tax = (grossPayArray.get(i) * 0.08);
                    taxAmount.add(8);
                } else if (11001 <= grossPayArray.get(i) && grossPayArray.get(i) <= 44725) {
                    tax = (grossPayArray.get(i) * 0.14);
                    taxAmount.add(14);
                } else if (44726 <= grossPayArray.get(i) && grossPayArray.get(i) <= 95375) {
                    tax = (grossPayArray.get(i) * 0.22);
                    taxAmount.add(22);
                } else if (95376 <= grossPayArray.get(i) && grossPayArray.get(i) <= 182100) {
                    tax = (grossPayArray.get(i) * 0.25);
                    taxAmount.add(25);
                } else if (182101 <= grossPayArray.get(i) && grossPayArray.get(i) <= 231250) {
                    tax = (grossPayArray.get(i) * 0.28);
                    taxAmount.add(28);
                } else if (231251 <= grossPayArray.get(i)) {
                    tax = (grossPayArray.get(i) * 0.32);
                    taxAmount.add(32);
                } else {
                    tax = 0.00;
                    taxAmount.add(0);
                }

                tax -= (children.get(i) * 2000) - (otherDependents.get(i) * 500);
                if (tax < 0) {
                    tax = 0;
                }

                taxArray.add(tax);

            }

            for (int i = 0; i < grossPayArray.size(); i++) {
                System.out.println();
                System.out.println("*** Employee" + (i + 1) + "***");
                System.out.println("Yearly Pay: $" + df.format(grossPayArray.get(i)));
                System.out.println("Income Tax " + taxAmount.get(i) + "%: $" + df.format(taxArray.get(i)));


            }

            System.out.println();
            System.out.println("Total Taxes: $" + df.format(taxArray.stream().mapToDouble(a -> a).sum()));

            System.out.println();
            System.out.print("Calculate another?(y/n): ");
            userInput = scan.next();
            System.out.println();




            //        //Testing Code
            //        for(int i = 0; i < grossPay.size(); i++) {
            //            System.out.println(grossPay.get(i));
            //            System.out.println(children.get(i));
            //            System.out.println(otherDependents.get(i));
            //        }


        }

    }

}
