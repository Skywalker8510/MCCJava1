package Assignment7;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 5/3/2024
//Resources: Canvas page and supporting Class Files

// Invoice Class

import java.text.NumberFormat;

public class Invoice {
    private int id;
    private String date;
    private String lastName;
    private String firstName;
    private String address;
    private String paintBrand;
    private String finish;
    private String color;
    private double cost;
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    // Constructors


    public Invoice(int id, String date, String lastName, String firstName, String address, String paintBrand, String finish, String color, double cost) {
        setId(id);
        setDate(date);
        setLastName(lastName);
        setFirstName(firstName);
        setAddress(address);
        setPaintBrand(paintBrand);
        setPaintFinish(finish);
        setColor(color);
        setCost(cost);
    }

    public Invoice(int id, String date, String lastName, String firstName, String address) {
        setId(id);
        setDate(date);
        setLastName(lastName);
        setFirstName(firstName);
        setAddress(address);
        setPaintBrand("");
        setPaintFinish("");
        setColor("");
        setCost(0);
    }

    public Invoice(Invoice invoice) {
        setId(invoice.getId());
        setDate(invoice.getDate());
        setLastName(invoice.getLastName());
        setFirstName(invoice.getFirstName());
        setAddress(invoice.getAddress());
        setPaintBrand(invoice.getPaintBrand());
        setPaintFinish(invoice.getPaintFinish());
        setColor(invoice.getColor());
        setCost(invoice.getCost());
    }

    public Invoice() {
        this(0, "", "", "", "", "", "", "", 0.0); //blank invoice
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaintBrand() {
        return paintBrand;
    }

    public void setPaintBrand(String paintBrand) {
        this.paintBrand = paintBrand;
    }

    public String getPaintFinish() {
        return finish;
    }

    public void setPaintFinish(String finish) {
        if (finish.equalsIgnoreCase("Flat") || finish.equalsIgnoreCase("Satin") || finish.equalsIgnoreCase("Semi-Gloss") || finish.equalsIgnoreCase("Gloss")) {
            this.finish = finish;
        } else {
            this.finish = "Flat"; // Default to "Flat" if invalid finish
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost >= 0) {
            this.cost = cost;
        }
    }

    // Calculate the cost of the paint job
    public void calculateCost(double squareFeet) {
        calculateCost(squareFeet, 27.64); // Default cost per gallon for Dutch Boy Flat paint
    }

    public void calculateCost(double squareFeet, double paintCost) {
        double gallons = Math.ceil(squareFeet / 200); // Calculate gallons needed, rounding up
        double totalCost = gallons * paintCost; // Calculate cost of paint
        if (gallons > 5) { // Apply discount if more than 5 gallons
            totalCost *= 0.9; // 10% discount
        }
        totalCost += gallons * 65.0; // Add labor charge
        setCost(totalCost); // Update the cost
    }

    // Print the invoice
    public void printInvoice() {
        System.out.println("ID: " + id);
        System.out.println("Date: " + date);
        System.out.println("Customer Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("Paint Brand: " + paintBrand);
        System.out.println("Paint Finish: " + finish);
        System.out.println("Paint Color: " + color);
        System.out.println("Total Cost: " + currency.format(cost));
    }
}
