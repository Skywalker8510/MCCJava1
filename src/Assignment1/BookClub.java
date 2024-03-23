package Assignment1;

import java.util.InputMismatchException;
import java.util.Scanner;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: Manas-Assignment1
//Date: 3/10/2024
//Resources: The Canvas page for this assignment

// this program will calculate how many points that each student earns based on their purchases.

public class BookClub {

    public static void main(String[] args) {

        int numberOfBooks;
        int pointsEarned;
        String userInput = "y";
        Scanner scan = new Scanner(System.in);

        while(userInput.equalsIgnoreCase("y")) {

            numberOfBooks = 0;

            while(true) {
                try {
                    System.out.println("** MCC Bookstore Points Club **\nEnter number of books purchased:");
                    numberOfBooks = scan.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("That is not a number.");
                    scan.next();
                }
            }

            if(numberOfBooks == 1) {
                pointsEarned = 1;
            }
            else if(numberOfBooks == 2) {
                pointsEarned = 2;
            }
            else if(numberOfBooks >= 3 && numberOfBooks <= 4) {
                pointsEarned = 15;
            }
            else if(numberOfBooks >= 5 && numberOfBooks <= 7) {
                pointsEarned = 30;
            }
            else if(numberOfBooks >= 8) {
                pointsEarned = 60;
            }
            else {
                pointsEarned = 0;
            }
            System.out.println("Points Earned: " + pointsEarned);
            System.out.println("Another purchase?(y/n):");
            userInput = scan.next();
        }
    }

}

