package Assignment2;

import java.util.Scanner;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: Manas-Assignment2
//Date: 3/22/2024
//Resources: Assignment page in canvas

// Discription: Calculator to solve how many grape vines can be planted in a row given
// the length of the row, the space lost by each end post and spacing between each vine.

public class VineyardCalculator {

    public static void main(String[] args) {

        String userInput = "y";
        while(userInput.equalsIgnoreCase("y")) {

            //get user input
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter in row length: ");
            double rowLength = scan.nextDouble();
            System.out.print("Enter post space: ");
            double postSpace = scan.nextDouble();
            System.out.print("Enter vine space: ");
            double vineSpace = scan.nextDouble();

            //solve for grapes per row
            double grapesPerRow;
            grapesPerRow = Math.floor((rowLength - (2 * postSpace)) / vineSpace);

            //printing result
            System.out.println();
            System.out.println("Vines per row: " + grapesPerRow);
            System.out.println();

            //get user input
            System.out.print("Enter vineyard width: ");
            double vineyardWidth = scan.nextDouble();
            System.out.print("Enter space between rows: ");
            double rowSpace = scan.nextDouble();

            //solve for vines to plant
            double vinesToPlant;
            vinesToPlant = grapesPerRow * Math.floor(vineyardWidth / rowSpace);

            //print results
            System.out.println();
            System.out.println("Total vines to plant: " + vinesToPlant);

            //solve for vineyard size
            double vineyardSize;
            vineyardSize = Math.round(((rowLength * vineyardWidth) / 43560) * 100.00) / 100.00;
            System.out.println("Vineyard size : " + vineyardSize + " acre(s)");

            //solve for plant density
            double plantDensity;
            plantDensity = Math.floor(vinesToPlant / vineyardSize);
            System.out.println(plantDensity + " vines per acre");
            System.out.println();

            //get user input
            System.out.print("Enter cluster per vine: ");
            double clusterPerVine = scan.nextDouble();
            System.out.print("Enter average cluster weight: ");
            double clusterWeight = scan.nextDouble();

            //solve for predicted yield
            double predictedYeild = Math.round(((vineyardSize * plantDensity * clusterPerVine * clusterWeight) / 2000) * 100.00) / 100.00;
            System.out.println();
            System.out.println("Predicted yield: " + predictedYeild);
            System.out.println();

            //print production numbers and profit
            double bottlesProduced = Math.floor((predictedYeild * 2000) / 2.5);
            System.out.println("Estimated bottles produced: " + bottlesProduced + " bottles");
            double costPerBottle = 32.99;
            double estimatedProfit = Math.round((bottlesProduced * costPerBottle) * 100.00) / 100.00;
            System.out.println("Estimated gross profit: $" + estimatedProfit);

            System.out.println();
            System.out.println("Calculate another?(y/n): ");
            userInput = scan.next();

        }
    }
}