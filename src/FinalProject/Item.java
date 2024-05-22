package FinalProject;

import Assignment9.Employee;

public class Item {

    private String upc;
    private String name;
    private String brand;
    private String size;
    private int inventory;
    private double price;

    public Item(String upc, String name, String brand, String size, int inventory, double price) {
        setUpc(upc);
        setName(name);
        setBrand(brand);
        setSize(size);
        setInventory(inventory);
        setPrice(price);
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item" +
                "\nupc: " + upc +
                "\nname: " + name +
                "\nbrand: " + brand +
                "\nsize: " + size +
                "\ninventory: " + inventory +
                "\nprice: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return upc.equals(item.upc);
    }

    public void addInventory(int amount) {
        this.inventory += amount;
    }

    public void sellItem() {
        if (inventory > 0) {
            this.inventory--;
        }
        else {
            throw new IllegalStateException("Item out of stock");
        }
    }
}