package Assignment9;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 5/18/2024
//Resources: 

// 

public class HourlyEmployee extends Employee {

    private double wage;
    private double hoursWorked;

    public HourlyEmployee(String fn, String ln, int en, String dept, String job, double w) {
        super(fn, ln, en, dept, job);
        this.wage = w;
        this.hoursWorked = 0.0;
    }

    public void increaseHours() {
        hoursWorked += 1;
    }

    public void increaseHours(double h) {
        if (h > 0) {
            hoursWorked += h;
        }
    }

    @Override
    public void resetWeek() {
        hoursWorked = 0.0;
    }

    @Override
    public double calculateWeeklyPay() {
        double pay = 0;

        if (hoursWorked > 40) {
            pay = 40 * wage + (1.5 * wage) * (hoursWorked - 40);
        } else {
            pay = hoursWorked * wage;
        }

        return pay;
    }

    @Override
    public void annualRaise() {
        wage *= 1.05;
    }

    @Override
    public double holidayBonus() {
        return 40 * wage;
    }

    @Override
    public void setPay(double pay) {
        this.wage = pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWage: " + currency.format(wage) + "\nHours Worked: " + hoursWorked;
    }

}
