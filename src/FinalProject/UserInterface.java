package FinalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Database database;
    private Scanner scanner;

    public UserInterface() {
        database = new Database();
        scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        database.testSetupFunction();
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getValidIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    manageItemsMenu();
                    break;
                case 2:
                    pointOfSaleSystem();
                    break;
                case 3:
                    manageRewardsProgram();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("1. Manage Items");
        System.out.println("2. Point of Sale System");
        System.out.println("3. Manage Rewards Program");
        System.out.println("0. Exit");
    }

    private void manageItemsMenu() {
        boolean running = true;
        while (running) {
            printItemsMenu();
            int choice = getValidIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    lookupItem();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printItemsMenu() {
        System.out.println("1. Add Items");
        System.out.println("2. Remove Items");
        System.out.println("3. Lookup Items");
        System.out.println("0. Back to Main Menu");
    }

    private void addItem() {
        String upc = getStringInput("Enter UPC: ");
        String name = getStringInput("Enter name: ");
        String brand = getStringInput("Enter brand: ");
        String size = getStringInput("Enter size: ");
        int inventory = getValidIntInput("Enter inventory: ");
        double price = getValidDoubleInput("Enter price: ");

        try {
            database.addItem(upc, name, brand, size, inventory, price);
            System.out.println("Item added successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeItem() {
        String upc = getStringInput("Enter the UPC of the item to remove: ");
        database.removeItem(upc);
        System.out.println("Item removed.");
    }

    private void lookupItem() {
        String upc = getStringInput("Enter the UPC of the item to lookup: ");
        Item item = database.lookupItem(upc);
        if (item != null) {
            System.out.println(item);
        }
        else {
            System.out.println("Item not found.");
        }
    }


    //TODO move more of this to the Database class and just streamline this more its quite clucky at the moment
    private void pointOfSaleSystem() {
        ArrayList<String> upcs = new ArrayList<>();
        boolean addingItems = true;

        while (addingItems) {
            String upc = getStringInput("Enter UPC of item (or 'done' to finish): ");
            if (upc.equalsIgnoreCase("done")) {
                addingItems = false;
            }
            else {
                upcs.add(upc);
            }
        }

        double total = database.processSale(upcs);

        System.out.println("Subtotal: $" + total);

        String phone = getStringInput("Enter customer phone number (or 'skip' to skip): ");
        if (!phone.equalsIgnoreCase("skip")) {

            database.addPointsToCustomer(phone, total);

            Customer customer = database.customerLookup(phone);
            if (customer != null) {
                ArrayList<Reward> rewards = customer.getRewards();
                if (!rewards.isEmpty()) {
                    System.out.println("Customer has rewards:");
                    for (int i = 0; i < rewards.size(); i++) {
                        System.out.println((i + 1) + ". " + rewards.get(i));
                    }
                    int rewardChoice = getValidIntInput("Enter reward number to use (or 0 to skip): ");
                    if (rewardChoice > 0 && rewardChoice <= rewards.size()) {
                        total = database.applyReward(phone, rewardChoice - 1, total);
                    }
                }
                else {
                    System.out.println("No rewards available.");
                }
            }
            else {
                System.out.println("Customer not found.");
            }
        }

        System.out.println("Total amount due: $" + total);

        //Create rewards after sale completes
        //TODO move this to database and make the database.rewardsMasterArray work
        Customer customer = database.customerLookup(phone);
        if (customer != null) {
            customer.createRewards();
        }
    }

    private void manageRewardsProgram() {
        boolean running = true;
        while (running) {
            printRewardsMenu();
            int choice = getValidIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    checkCustomerRewards();
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printRewardsMenu() {
        System.out.println("Manage Rewards Program");
        System.out.println("1. Add Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Check Customer Rewards");
        System.out.println("0. Back to Main Menu");
    }

    private void addCustomer() {
        String name = getStringInput("Enter name: ");
        String address = getStringInput("Enter address: ");
        String email = getStringInput("Enter email: ");
        String phone = getStringInput("Enter phone: ");
        String accountNumber = getStringInput("Enter account number: ");

        try {
            database.addCustomer(name, address, email, phone, accountNumber);
            System.out.println("Customer added successfully.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeCustomer() {
        String phone = getStringInput("Enter the phone number of the customer to remove: ");
        database.removeCustomer(phone);
        System.out.println("Customer removed.");
    }

    private void checkCustomerRewards() {
        String phone = getStringInput("Enter the phone number of the customer: ");
        ArrayList<Reward> rewards = database.getCustomerRewards(phone);
        if (rewards != null) {
            for (Reward reward : rewards) {
                System.out.println(reward);
            }
        }
        else {
            System.out.println("Customer not found or no rewards available.");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getValidIntInput(String prompt) {
        int userInput;
        while (true) {
            System.out.print(prompt);
            try {
                userInput = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return userInput;
    }

    private double getValidDoubleInput(String prompt) {
        double userInput;
        while (true) {
            System.out.print(prompt);
            try {
                userInput = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return userInput;
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}