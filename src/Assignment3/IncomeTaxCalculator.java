package Assignment3;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 3/28/2024
//Resources: 

// Java program to Calculate income tax from user inputs

import java.util.ArrayList;
import java.util.Scanner;

public class IncomeTaxCalculator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> grossPayArray = new ArrayList<Integer>();
        ArrayList<Integer> children = new ArrayList<Integer>();
        ArrayList<Integer> otherDependents = new ArrayList<Integer>();

        System.out.println("**** Income Tax Calculator ****");

        System.out.print("Enter number of people to calculate for: ");
        int numberOfPeople = scan.nextInt();
        System.out.println();

        for(int i = 0; i < numberOfPeople; i++) {

            System.out.print("Enter gross pay for employee " + (i+1) + ": ");
            int grossPay = scan.nextInt();

            while(grossPay < 0) {

                System.err.println("Error, Pay must be positive.");

                System.out.print("Enter gross pay for employee " + (i+1) + ": ");
                grossPay = scan.nextInt();
                System.out.println();

            }
            
            grossPayArray.add(grossPay);

            if(grossPayArray.get(i) < 200000) {

            }

        }
//        for(int i = 0; i < grossPayArray.size(); i++) {
//            System.out.println(grossPayArray.get(i));
//        }

    }

}
