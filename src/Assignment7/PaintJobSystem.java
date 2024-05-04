package Assignment7; /**
 * Paint Job Invoice system runner. Use this to test your assignment 7
 * @author Lucas Hartman
 * @version 1.0.0
 *
 *
 *
*/
import java.util.Scanner;
import java.util.ArrayList;

public class PaintJobSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Invoice> paintJobs = new ArrayList<>();

        // put in some sample invoices
        paintJobs.add(new Invoice(1589, "01-25-2023", "Banner", "Bruce", "890 5th Ave, Manhattan, New York 10451", "Dutch Boy", "Flat", "Calming Gray", 1026.75));
        paintJobs.add(new Invoice(1234, "02-15-2023", "Stark", "Tony", "10880 Malibu Point, Malibu, CA 90265", "Sherwin William", "Semi-Gloss", "Hot Rod Red", 2631.58));
        paintJobs.add(new Invoice(78569, "03-31-2023", "Lang", "Scott", "601 Buena Vista Avenue West, Buena Vista, CA 95640", "Behr", "Flat", "Dirt Brown", 635.26));

        // loop through menu
        int choice = 0;
        while(choice != 6)
        {
            System.out.println("** Happy Accidents Paint Job System **\n");
            System.out.println("1. List Invoices");
            System.out.println("2. Add Invoice");
            System.out.println("3. Delete Invoice");
            System.out.println("4. Modify Invoice");
            System.out.println("5. Calculate Paint Job Cost");
            System.out.println("6. Exit");

            // get input and check valid range
            choice = getInt(input, "Choice: ");
            while (choice < 1 || choice > 6)
            {
                choice = getInt(input, "Choice: ");
            }
            System.out.println(); // add blank line
            switch(choice)
            {
                case 1 -> printInvoices(paintJobs);
                case 2 -> addInvoice(paintJobs, input);
                case 3 -> deleteInvoice(paintJobs, input);
                case 4 -> modifyInvoice(paintJobs, input);
                case 5 -> calcInvoice(paintJobs, input);
            }
            System.out.println(); // insert blank line between each
        }
    }

    private static void calcInvoice(ArrayList<Invoice> paintJobs, Scanner input) {
        System.out.println("*** Calculate Job Cost ***\n");

        // get invoice
        int index = searchInvoice(paintJobs, input, "job cost");
        // print invoice
        paintJobs.get(index).printInvoice();

        System.out.println("1. Default Paint");
        System.out.println("2. Enter Paint Cost");
        int choice = getInt(input, "Choice: ");
        while (choice < 1 || choice > 2) {
            choice = getInt(input, "Choice: ");
        }

        double sqft = getDouble(input, "Enter square feet: ");

        if (choice == 2) {
            double costGallon = getDouble(input, "Enter paint cost: ");
            paintJobs.get(index).calculateCost(sqft, costGallon);
        }
        else {
            paintJobs.get(index).calculateCost(sqft);
        }

        System.out.println("Cost updated: " + paintJobs.get(index).getCost());

    }

    private static void modifyInvoice(ArrayList<Invoice> paintJobs, Scanner input) {
        // print options
        System.out.println("Choose options for modifying");
        System.out.println("1. Change Paint Brand");
        System.out.println("2. Change Paint Finish");
        System.out.println("3. Change Paint Color");
        System.out.println("4. Change Cost");

        // get input and valid through the menu
        int choice = getInt(input, "Choice: ");
        while (choice < 1 || choice > 4)
        {
            choice = getInt(input, "Choice: ");
        }

        System.out.println(); // insert blank line
        // make header
        String type = switch(choice) {
            case 1 -> "Paint Brand";
            case 2 -> "Paint Finish";
            case 3 -> "Paint Color";
            default -> "Job Cost";
        };
        // print header
        System.out.print("*** Change " + type + " ***\n");
        int index = searchInvoice(paintJobs, input, (type + " change")); // search
        // print invoice
        Invoice current = paintJobs.get(index);
        // get input for the change
        switch(choice)
        {
            case 1 -> {

                System.out.println("Current brand: " + current.getPaintBrand());
                System.out.print("Enter new brand: ");
                String brand = input.nextLine();
                current.setPaintBrand(brand);
            }
            case 2 -> {
                System.out.println("Current finish: " + current.getPaintFinish());
                System.out.print("Enter new finish: ");
                String finish = input.nextLine();
                current.setPaintFinish(finish);
            }
            case 3 -> {
                System.out.println("Current color: " + current.getColor());
                System.out.print("Enter new color: ");
                String color = input.nextLine();
                current.setColor(color);
            }
            case 4 -> {
                System.out.println("Current cost: " + current.getCost());
                double cost = getDouble(input, "Enter new cost: ");
                current.setCost(cost);
            }
        }

        System.out.println("Invoice Updated\n");

    }

    private static void deleteInvoice(ArrayList<Invoice> paintJobs, Scanner input) {
        int delete = searchInvoice(paintJobs, input, "delete");

        paintJobs.remove(delete);
        System.out.println("Invoice Deleted");
    }

    /**
     * Gets input to add a new invoice into the system. Have full and the "estimate" stage of invoice
     * Estimate just has id, date, name and address. Everything else is blank
     * @param paintJobs ArrayList of the invoices
     * @param input Scanner object
     */
    private static void addInvoice(ArrayList<Invoice> paintJobs, Scanner input) {
        System.out.println("** Invoice Type **");
        System.out.println("1. Full Invoice");
        System.out.println("2. Estimate");
        int choice = getInt(input, "Choice: ");
        while (choice < 1 || choice > 2) {
            choice = getInt(input, "Choice: ");
        }

        // get main data for both
        int id = getInt(input, "Enter ID: ");
        System.out.print("Enter date: ");
        String date = input.nextLine();
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();

        // get the rest of the data for full invoice
        if (choice == 1) {
            System.out.print("Enter paint brand: ");
            String brand = input.nextLine();
            System.out.print("Enter paint finish: ");
            String finish = input.nextLine();
            System.out.print("Enter paint color: ");
            String color = input.nextLine();
            double cost = getDouble(input, "Enter cost: ");

            Invoice i = new Invoice(id, date, firstName, lastName, address, brand, finish, color, cost);
            paintJobs.add(i);
        }
        else {
            Invoice i = new Invoice(id, date, firstName, lastName, address);
            paintJobs.add(i);
        }

    }

    /**
     * Loops through all the invoices and calls the print methods
     * @param paintJobs ArrayList of the Invoices
     */
    private static void printInvoices(ArrayList<Invoice> paintJobs) {
        System.out.println("** Invoices **");
        for (Invoice i : paintJobs) {
            i.printInvoice();
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method will locate an employee in the list and return the index it is found at.
     *
     * @param paintJob ArrayList of employees
     * @param sc Scanner object
     * @param prompt String to print in the prompt
     * @return index location of found employee
     */
    private static int searchInvoice(ArrayList<Invoice> paintJob, Scanner sc, String prompt)
    {

        // quick print for searching invoices
        System.out.println("ID:\t\tName");
        for (Invoice e : paintJob)
        {
            System.out.println(e.getId() + "\t" + e.getLastName() + ", " + e.getFirstName());
        }
        System.out.println(); // blank space

        // look for invoice search
        int index = -1;
        while(index == -1)
        {
            int searchID = getInt(sc, "Enter Invoice ID to " + prompt + ": "); // get valid input

            // loop through invoices to search
            for (int i = 0; i < paintJob.size(); i++)
            {
                // if invoice found save index and break out of loop.
                if (paintJob.get(i).getId() == searchID)
                {
                    index = i;
                    break;
                }
            }

            // error if can't find invoice
            if (index == -1)
            {
                System.out.println("Invoice not found, search again");
            }
        }
        System.out.println(); // blank line
        return index;
    }


    /**
     * Helper method that reads in valid double input. If text is entered
     * then input is ask for again.
     *
     * @param sc Scanner object to read input.
     * @param prompt message to print for the prompt
     * @return double value read in from the keyboard
     */
    public static double getDouble(Scanner sc, String prompt)
    {
        boolean isValid = false;
        double value = 0.0;
        while(!isValid)
        {
            System.out.print(prompt);
            if(sc.hasNextDouble())
            {
                value = sc.nextDouble();
                isValid = true;
                sc.nextLine();
            }
            else
            {
                System.out.println("Error, must enter a number.");
                sc.nextLine(); // clear input
            }
        }
        return value;
    }

    /**
     * Helper method that reads in valid integer input. If text is entered
     * then input is asked for again.
     *
     * @param sc Scanner object to read input.
     * @param prompt message to print for the prompt
     * @return integer value read in from the keyboard
     */
    public static int getInt(Scanner sc, String prompt)
    {
        boolean isValid = false;
        int value = 0;
        while(!isValid)
        {
            System.out.print(prompt);
            if(sc.hasNextInt())
            {
                value = sc.nextInt();
                isValid = true;
                sc.nextLine();
            }
            else
            {
                System.out.println("Error, must enter a number.");
                sc.nextLine(); // clear input
            }
        }
        return value;
    }
}
