package Assignment9;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 5/18/2024
//Resources: 

// 

public class SalaryEmployee extends Employee{

    private double salary;

    public SalaryEmployee(String fn, String ln, int en, String dept, String job, double s) {
        super(fn, ln, en, dept, job);
        salary = s;
    }

    @Override
    public void resetWeek() {

    }

    @Override
    public double calculateWeeklyPay() {
        return salary / 52;
    }

    @Override
    public void annualRaise() {
        salary *= 1.0625;
    }

    @Override
    public double holidayBonus() {
        return salary * 0.03365;
    }

    @Override
    public void setPay(double pay) {
        this.salary = pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + currency.format(salary);
    }

}
