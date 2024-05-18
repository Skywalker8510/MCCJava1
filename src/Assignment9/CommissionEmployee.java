package Assignment9;

public class CommissionEmployee extends Employee {

    private double sales;
    private double rate;

    public CommissionEmployee(String fn, String ln, int en, String dept, String job, double rate) {
        super(fn, ln, en, dept, job);
        this.rate = rate;
        this.sales = 0.0;
    }

    public void increaseSales() {
        sales += 100;
    }

    public void increaseSales(double s) {
        if (s > 0) {
            sales += s;
        }
    }

    @Override
    public void resetWeek() {
        sales = 0.0;
    }

    @Override
    public double calculateWeeklyPay() {
        return rate * sales;
    }

    @Override
    public void annualRaise() {
        rate += 0.002;
    }

    @Override
    public double holidayBonus() {
        return 0;
    }

    @Override
    public void setPay(double pay) {
        this.rate = pay;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRate: " + percent.format(rate) + "\nSales: " + currency.format(sales);
    }

}
