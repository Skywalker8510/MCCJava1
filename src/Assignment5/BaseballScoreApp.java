package Assignment5;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 4/23/2024
//Resources: canvas page

// Calculates and displays scores for a baseball game

import java.text.DecimalFormat;
import java.util.Scanner;

public class BaseballScoreApp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("** Baseball/Softball Scoring App **");
        System.out.print("How many innings in the game? ");
        int numberOfInnings = scan.nextInt();
        System.out.print("Team 1 name: ");
        String team1Name = scan.next();
        System.out.print("\nTeam 2 name: ");
        String team2Name = scan.next();
        int nameLength = Math.max(team1Name.length(), team2Name.length());
        if (nameLength < 7) {
            nameLength = 7;
        }


        // Initialize arrays for runs, hits, and errors
        int[][] runs = new int[2][numberOfInnings];
        int[][] hits = new int[2][numberOfInnings];
        int[][] errors = new int[2][numberOfInnings];

        //Get user input for Runs, Hits, and Errors
        for (int i = 0; i < numberOfInnings; i++) {
            System.out.println("\n** Inning " + (i + 1) + " **");

            System.out.print("Enter top runs: ");
            runs[0][i] = scan.nextInt();
            System.out.print("Enter top hits: ");
            hits[0][i] = scan.nextInt();
            System.out.print("Enter top errors: ");
            errors[0][i] = scan.nextInt();

            System.out.print("\nEnter bottom runs: ");
            runs[1][i] = scan.nextInt();
            System.out.print("Enter bottom hits: ");
            hits[1][i] = scan.nextInt();
            System.out.print("Enter bottom errors: ");
            errors[1][i] = scan.nextInt();
        }

        //Print Results
        System.out.println("\n** Baseball/Softball Results **");
        System.out.printf("%-" + nameLength + "s |", "Innings");
        System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | Runs | Hits | Errs |");
        System.out.println("--------------------------------------------------------------------");
        // Print innings
        System.out.printf("%-" + nameLength + "s |", team1Name);
        printInnings(runs, hits, errors, 0);
        System.out.printf("%-" + nameLength + "s |", team2Name);
        printInnings(runs, hits, errors, 1);

        //Print hit conversion rate
        System.out.println("\n" + team1Name + " HCR: " + df.format(calculateHCR(runs, hits, 0)));
        System.out.println("\n" + team2Name + " HCR: " + df.format(calculateHCR(runs, hits, 1)));

        // Determine winner
        if (calculateTotal(runs, 0) > calculateTotal(runs, 1))
            System.out.println("\n" + team1Name + " Wins!");
        else if (calculateTotal(runs, 0) < calculateTotal(runs, 1))
            System.out.println("\n" + team2Name + " Wins!");
        else
            System.out.println("\nIt's a Tie!");
    }

    //Calculate total of everything in the array
    private static int calculateTotal(int[][] arrayToCalculate, int i) {
        int total = 0;
        for (int j : arrayToCalculate[i]) {
            total += j;
        }
        return total;
    }

    //Calculate hit conversion rate
    private static double calculateHCR(int[][] runs, int[][] hits, int i) {
        double HCR;
        if (calculateTotal(runs, i) == 0) {
            HCR = 0;
        } else {
            HCR = ((double) calculateTotal(hits, i)) / ((double) calculateTotal(runs, i));
        }
        return HCR;
    }

    // Helper method to print innings
    private static void printInnings(int[][] runs, int[][] hits, int[][] errors, int i) {
        for (int j : runs[i]) {
            System.out.print(" " + j + " |");
        }
        int errorsTeam;
        if (i == 0) {
            errorsTeam = 1;
        } else {
            errorsTeam = 0;
        }
        System.out.println("   " + calculateTotal(runs, i) + "  |  " + calculateTotal(hits, i) + "   |  " + calculateTotal(errors, errorsTeam) + "   |");
    }

}