package FinalProject;

import java.util.ArrayList;

public class Database {

    private ArrayList<Item> items;
    private ArrayList<Customer> customers;
//    private ArrayList<Reward> rewardsMasterArray;

    public void testSetupFunction() {
        items.add(new Item("041475778990", "Air Jordan 1", "Nike", "9.5", 5, 124.99));
        items.add(new Item("269979408784", "Air Jordan 1", "Nike", "10", 3, 124.99));
        items.add(new Item("262518191617", "UEFA Euro 2024 League Soccer Ball", "adidas", "5", 10, 39.99));
        items.add(new Item("436213705862", "J Guard Shin Guards", "Nike", "M", 8, 12.00));
        items.add(new Item("113058669286", "J Guard Shin Guards", "Nike", "L", 12, 12.00));
        items.add(new Item("775536022491", "Osito Etip Glove", "The North Face", "S", 22, 40.00));
        items.add(new Item("403097686529", "Storm Defender Insulated Gloves", "Carhartt", "L", 5, 34.99));
        items.add(new Item("009779359366", "Hook Angler Kayak", "Perception", "10.5", 3, 629.99));
        items.add(new Item("013997385114", "Revel BIke Helmet", "Giro", "OneSize", 8, 49.99));
        items.add(new Item("448939731169", "Qi10 MAX Driver", "TaylorMade", "Regular", 4, 599.99));
        Customer c1 = new Customer("Tony Stark", "10880 Malibu Point, Malibu, CA 90265", "tstark@avengers.com", "310-856-9632", "902659632");
        Customer c2 = new Customer("Bruce Banner", "890 5th Ave, Manhattan, New York 10451", "bbanner@avengers.com", "917-521-4125", "104514125");
        Customer c3 = new Customer("Clint Barton", "45689 Happy St. Onawa, IA 51596", "cbarton@avengers.com", "712-328-8970", "515968970");
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        c1.addPointsAndCalculateRewards(326.59);
        c2.addPointsAndCalculateRewards(763.25);
        c3.addPointsAndCalculateRewards(100.56);
    }

    public Database() {
        items = new ArrayList<>();
        customers = new ArrayList<>();
//        rewardsMasterArray = new ArrayList<>();
    }

    public void addItem(String upc, String name, String brand, String size, int inventory, double price) {

        Item item = new Item(upc, name, brand, size, inventory, price);

        if (!items.contains(item)) {
            items.add(item);
        }
        else {
            System.err.println("Item already in system");
        }
    }

    public void removeItem(String upc) {
        items.removeIf(item -> item.getUpc().equals(upc));
    }

    public Item lookupItem(String upc) {
        for (Item item : items) {
            if (item.getUpc().equals(upc)) {
                return item;
            }
        }
        return null;
    }

    public void addCustomer(String name, String address, String email, String phone, String accountNumber) {

        Customer customer = new Customer(name, address, email, phone, accountNumber);

        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        else {
            System.err.println("Customer already in system");
        }
    }

    public void removeCustomer(String phone) {
        customers.removeIf(customer -> customer.getPhone().equals(phone));
    }

    public Customer customerLookup(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null;
    }

//    public void createCustomorRevards() {
//        for (Customer customer : customers) {
//            Reward reward = customer.createRewards();
//        }
//    }
//
//    public static void addRewards(Reward reward) {
//        rewardsMasterArray.add(reward);
//    }

    public ArrayList<Reward> getCustomerRewards(String phone) {
        Customer customer = customerLookup(phone);
        if (customer != null) {
            return customer.getRewards();
        }
        return null;
    }

    public double processSale(ArrayList<String> upcs) {
        ArrayList<Item> currentSale = new ArrayList<>();
        double total = 0;

        for (String upc : upcs) {
            Item item = lookupItem(upc);
            if (item != null) {
                item.sellItem();
                currentSale.add(item);
                total += item.getPrice();
            } else {
                System.err.println("Item with UPC " + upc + " not found.");
            }
        }
        return total;
    }

    public double applyReward(String phone, int rewardIndex, double total) {
        Customer customer = customerLookup(phone);
        if (customer != null) {
            ArrayList<Reward> rewards = customer.getRewards();
            if (rewardIndex >= 0 && rewardIndex < rewards.size()) {
                Reward reward = rewards.get(rewardIndex);
                total -= reward.getAmount();
                rewards.remove(reward);
                System.out.println("Applied reward. New total: $" + total);
            } else {
                System.out.println("Invalid reward index.");
            }
        } else {
            System.out.println("Customer not found or no rewards available.");
        }
        return total;
    }

    public void addPointsToCustomer(String phone, double total) {
        if (phone != null && !phone.isEmpty()) {
            Customer customer = customerLookup(phone);
            if (customer != null) {
                customer.createRewards();
                customer.addPoints(total);
                System.out.println("Added points to customer account.");
            } else {
                System.out.println("Customer not found.");
            }
        }
    }
}
