package FinalProject;

import java.time.LocalDate;

public class Reward {
    private String date;
    private String upc;
    private double amount;

    public Reward(String customerAccountNumber, double amount) {
        setAmount(amount);
        setDate();
        setUpc(customerAccountNumber);
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now().toString();
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String customerAccountNumber) {
        String[] split = this.date.split("-");
        this.upc = customerAccountNumber + split[0] + split[1] + split[2];
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Reward" +
                "\nupc: " + upc +
                "\ndate: " + date +
                "\namount: " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reward reward = (Reward) o;
        return upc.equals(reward.upc);
    }
}