package Assignment9;
// tester employee

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private int employeeNum;
    private String department;
    private String jobTitle;
    protected static NumberFormat currency = NumberFormat.getCurrencyInstance();
    protected static NumberFormat percent = NumberFormat.getPercentInstance();
//    private double hoursWorked;
//    private double payRate;
    protected ArrayList<EmergencyContact> emergencyContacts;

    public Employee(String fn, String ln, int en, String dept, String job) {
        percent.setMaximumFractionDigits(3);
        firstName = fn;
        lastName = ln;
        employeeNum = en;
        department = dept;
        jobTitle = job;
//        payRate = pr;
//        hoursWorked = 0;
        emergencyContacts = new ArrayList<EmergencyContact>();
    }
    
    public Employee(String fn, String ln, int en) {
        percent.setMaximumFractionDigits(3);
        firstName = fn;
        lastName = ln;
        employeeNum = en;
        department = "";
        jobTitle = "";
//        payRate = 0;
//        hoursWorked = 0;
        emergencyContacts = new ArrayList<EmergencyContact>();
    }

    public Employee(Employee e) {
        percent.setMaximumFractionDigits(3);
        firstName = e.getFirstName();
        lastName = e.getLastName();
        employeeNum = e.getEmployeeNumber();
        department = e.getDepartment();
        jobTitle = e.getJobTitle();
//        payRate = e.getPayRate();
//        hoursWorked = 0;
        emergencyContacts = new ArrayList<EmergencyContact>();
    }
    
    // default
    public Employee() {
        percent.setMaximumFractionDigits(3);
        firstName = "";
        lastName = "";
        employeeNum = 0;
        department = "";
        jobTitle = "";
//        payRate = 0;
//        hoursWorked = 0;
        emergencyContacts = new ArrayList<EmergencyContact>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeNumber() {
        return employeeNum;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

//    public double getHoursWorked() {
//        return hoursWorked;
//    }
//
//    public double getPayRate() {
//        return payRate;
//    }

    public void setEmployeeNumber(int empNum) {
        employeeNum = empNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

//    public void setPayRate(double payRate) {
//        this.payRate = payRate;
//    }
//
//    public void resetHours()
//    {
//        hoursWorked = 0;
//    }
//
//    public void addHours()
//    {
//        hoursWorked += 1;
//    }
//
//    public void addHours(double h)
//    {
//        hoursWorked += h;
//    }
//
//    public double calculateWeeklyPay()
//    {
//        return hoursWorked * payRate;
//    }

    public static String currencyFormat(double amt) {
        return currency.format(amt);
    }
    
    public void printEmployee() {
        System.out.println(toString());
//        System.out.println("Name: " + firstName +" " + lastName + "\nID: " + employeeNum +
//                "\nDepartment: " + department + "\nTitle: " + jobTitle
//                + "\nPay: " + payRate + "\nHours Worked: " + hoursWorked
//                    );
    }

    public void printEmergencyContacts() {
        System.out.println("**** Emergency Contacts ****\n");
        for (int i = 0; i < emergencyContacts.size(); i++)
        {
            System.out.println("**** Contact "+ (i+1) + "****");
            emergencyContacts.get(i).printContact();
            System.out.println(); // add a space between each
        }
    }

    public void clearContacts() {
        emergencyContacts.clear();
    }

    public void addNewContact(EmergencyContact contact) {
        emergencyContacts.add(contact);
    }

    public ArrayList<EmergencyContact> getEmergencyContactList() {
        return emergencyContacts;
    }

    public boolean removeContact(EmergencyContact contact) {
    	return emergencyContacts.remove(contact);
    }

    public boolean removeContact(int index) {
        if (emergencyContacts.size() > index && index >= 0)
        {
            emergencyContacts.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public abstract void resetWeek();

    public abstract double calculateWeeklyPay();

    public abstract void annualRaise();

    public abstract double holidayBonus();

    public abstract void  setPay(double pay);

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nID: " + employeeNum + "\nDepartment: " + department + "\nTitle: " + jobTitle;
    }

    @Override
    public boolean equals(Object obj2) {
        if (this == obj2) {
            return true;
        }
        if (obj2 == null || getClass() != obj2.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj2;
        return employeeNum == employee.employeeNum;
    }

}
