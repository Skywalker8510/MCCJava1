package FinalProject;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;
    private String email;
    private String phone;
    private String accountNumber;
    private double points;
    private ArrayList<Reward> rewards;

    public Customer(String name, String address, String email, String phone, String accountNumber) {
        setName(name);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
        setAccountNumber(phone);
        setPoints(0);
        this.rewards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public ArrayList<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(ArrayList<Reward> rewards) {
        this.rewards = rewards;
    }

    public void addPoints(double points) {
        this.points += points;
    }

    public void addPointsAndCalculateRewards(double points) {
        this.points += points;
        createRewards();
    }

    public void createRewards() {
        while (this.points >= 200) {
            double rewardAmount = (this.points / 200) * 15;
            this.points %= 200;
            Reward reward = new Reward(accountNumber, rewardAmount);
            rewards.add(reward);
        }
    }

    @Override
    public String toString() {
        return "Customer" +
                "\nname: " + name +
                "\naddress: " + address +
                "\nemail: " + email +
                "\nphone: " + phone +
                "\naccountNumber: " + accountNumber +
                "\npoints: " + points +
                "\nrewards: " + rewards;
    }
}
