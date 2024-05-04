package Assignment7;

/**
 * @author Lucas Hartman
 * @version 1.0.0
 * Class: INFO 1521 - Java 1
 *
 * This is the checker file for INFO1521 - Assignment 7 - Paint Job Invoice
 *
 * Errors appear at first and will go away when you fully code the Invoice.java file required.
 *
 * **************************** DO NOT MODIFY THIS FILE ********************************
 */

public class A7InvoiceChecker {
    public static void main(String[] args) {

        Invoice invoice1 = new Invoice(1589, "01-25-2023", "Banner", "Bruce", "890 5th Ave, Manhattan, New York 10451", "Dutch Boy", "Flat", "Calming Gray", 1026.75);
        Invoice invoice2 = new Invoice(1234, "02-15-2023", "Stark", "Tony", "10880 Malibu Point, Malibu, CA 90265", "Sherwin William", "Semi-Gloss", "Hot Rod Red", 2631.58);
        Invoice invoice3 = new Invoice(78569, "03-31-2023", "Lang", "Scott", "601 Buena Vista Avenue West, Buena Vista, CA 95640", "Behr", "Flat", "Dirt Brown", 635.26);
        Invoice invoice4 = new Invoice(3695, "02-12-2023", "Odinson", "Loki", "Asgard", "Dutch Boy", "Gloss", "Emerald", 586.25);
        Invoice invoice5 = new Invoice(8536, "12-22-2022", "Odinson", "Thor", "Asgard");

        // print the invoices here
        System.out.println("Happy Accidents Paint Company\n** Invoice Printouts **");
        invoice1.printInvoice();
        System.out.println();
        invoice2.printInvoice();
        System.out.println();
        invoice3.printInvoice();
        System.out.println();
        invoice4.printInvoice();
        System.out.println();
        invoice5.printInvoice();

        // Invoice 5 needs final setup
        invoice5.setPaintBrand("Dutch Boy");
        invoice5.setPaintFinish("Gloss");
        invoice5.setColor("Lightning Blue");
        invoice5.calculateCost(635);

        System.out.println("\n\n** Updated Invoice 5 **");
        invoice5.printInvoice();

        // check the copy constructor
        Invoice invoice6 = new Invoice(invoice5);
        System.out.println("\n\n** Copied Invoice 5 to Invoice 6 **");
        invoice6.printInvoice();

        // update this new invoice 6 - checks all the setters
        invoice6.setId(3589);
        invoice6.setDate("03-25-2023");
        invoice6.setLastName("Maximoff");
        invoice6.setFirstName("Wanda");
        invoice6.setAddress("2800 Sherwood Dr, Westview, New Jersey 08801");
        invoice6.setPaintBrand("Sherwin Williams");
        invoice6.setPaintFinish("Super Flat"); // ERROR, the setter should catch this!! should stay gloss
        invoice6.setColor("Tan");
        invoice6.setCost(-569.25); // Again ERROR, the setter should catch this and not change it
        invoice6.calculateCost(1350, 35.76);

        System.out.println("\n\n** Updated Invoice 6 **");
        invoice6.printInvoice();

        // check blank constructor to make sure is all blank
        System.out.println("\n\n** Blank Invoice **");
        Invoice invoice7 = new Invoice();
        invoice7.printInvoice();

    }

}
