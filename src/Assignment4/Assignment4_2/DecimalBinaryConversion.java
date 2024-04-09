package Assignment4.Assignment4_2;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 4/9/2024
//Resources: 

// using Recursion to convert a number from decimal(base 10) to binary (base 2)

import java.util.Scanner;

public class DecimalBinaryConversion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What number do you want to convert to binary");
        int IntForm = scan.nextInt();
        System.out.println(RecursionToBinary(IntForm));
    }

    public static String RecursionToBinary(int number) {
        if(number == 0) {
            return "0";
        } else if(number == 1) {
            return "1";
        } else {
            return RecursionToBinary(number / 2) + (number % 2);
        }
    }

}
