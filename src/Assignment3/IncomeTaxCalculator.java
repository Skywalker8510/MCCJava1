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
        System.out.println("**** Income Tax Calculator ****");
        System.out.print("Enter number of people to calculate for: ");
        int numberOfPeople = scan.nextInt();
        System.out.println();
        ArrayList<Integer> grossPayArray = new ArrayList<Integer>();
        for(int i = 0; i < numberOfPeople; i++) {

            System.out.println("Enter gross pay for employee " + (i+1));
            int grossPay = scan.nextInt();
            if (grossPay < 0) {

            } else {
                grossPayArray.add(grossPay);
            }

        }

    }

}
