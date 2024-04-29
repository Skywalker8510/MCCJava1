package Assignment5;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 4/23/2024
//Resources: 

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


        // Initialize arrays for top and bottom innings, runs, hits, and errors
        int[] topRuns = new int[numberOfInnings];
        int[] topHits = new int[numberOfInnings];
        int[] topErrors = new int[numberOfInnings];
        int[] bottomRuns = new int[numberOfInnings];
        int[] bottomHits = new int[numberOfInnings];
        int[] bottomErrors = new int[numberOfInnings];

        // Part 2: Get the Runs, Hits, and Errors
        for (int i = 0; i < numberOfInnings; i++) {
            System.out.println("\n** Inning " + (i + 1) + " **");

            System.out.print("Enter top runs: ");
            topRuns[i] = scan.nextInt();
            System.out.print("Enter top hits: ");
            topHits[i] = scan.nextInt();
            System.out.print("Enter top errors: ");
            topErrors[i] = scan.nextInt();

            System.out.print("\nEnter bottom runs: ");
            bottomRuns[i] = scan.nextInt();
            System.out.print("Enter bottom hits: ");
            bottomHits[i] = scan.nextInt();
            System.out.print("Enter bottom errors: ");
            bottomErrors[i] = scan.nextInt();
        }

        // Part 3: Calculate Scores and Display Results
        System.out.println("\n** Baseball/Softball Results **");
        System.out.printf("%-" + nameLength + "s |", "Innings");
        System.out.println(" 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | Runs | Hits | Errs |");
        System.out.println("--------------------------------------------------------------------");
        // Print top innings
        System.out.printf("%-" + nameLength + "s |", team1Name);
        printInnings(topRuns, topHits, topErrors);
        System.out.printf("%-" + nameLength + "s |", team2Name);
        printInnings(bottomRuns, bottomHits, bottomErrors);

        // Calculate and print hit conversion rate
        System.out.println("\n" + team1Name + " HCR: " + df.format(calculateHCR(topRuns, topHits)));
        System.out.println("\n" + team2Name + " HCR: " + df.format(calculateHCR(bottomRuns, bottomHits)));

        // Determine winner
        if (calculateTotal(topRuns) > calculateTotal(bottomRuns))
            System.out.println("\n" + team1Name + " Wins!");
        else if (calculateTotal(topRuns) < calculateTotal(bottomRuns))
            System.out.println("\n" + team2Name + " Wins!");
        else
            System.out.println("\nIt's a Tie!");
    }

    // Helper method to calculate total
    private static int calculateTotal(int[] arrayToCalculate) {
        int total = 0;
        for (int i : arrayToCalculate) {
            total += i;
        }
        return total;
    }

    // Helper method to calculate hit conversion rate
    private static double calculateHCR(int[] runs, int[] hits) {
        double HCR;
        if (calculateTotal(runs) == 0) {
            HCR = 0;
        } else {
            HCR = ((double) calculateTotal(hits)) / ((double) calculateTotal(runs));
        }
        return HCR;
    }

    // Helper method to print innings
    private static void printInnings(int[] runs, int[] hits, int[] errors) {
        for (int i : runs) {
            System.out.print(" " + i + " |");
        }
        System.out.println("   " + calculateTotal(runs) + "  |  " + calculateTotal(hits) + "   |  " + calculateTotal(errors) + "   |");
    }

}