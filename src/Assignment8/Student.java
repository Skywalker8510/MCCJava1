package Assignment8;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * This is the base class for a student in the Student record system.
 *
 * @author Lucas Hartman
 * @version 1.0.0 - 08/14/23
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String gender;
    private String DOB;
    private String phone;
    private String email;

    ArrayList<Course> schedule;
    ArrayList<Course> officialRecord;

    protected static NumberFormat twoDecimal = NumberFormat.getNumberInstance();

    public Student(int id, String firstName, String lastName, String address, String city, String state, String zip,
                          String gender, String DOB, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.gender = gender;
        this.DOB = DOB;
        this.phone = phone;
        this.email = email;
        twoDecimal.setMaximumFractionDigits(2);
        schedule = new ArrayList<>();
        officialRecord = new ArrayList<>();
    }

    public Student() {
        id = 0;
        firstName = "";
        lastName = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        gender = "";
        DOB = "";
        phone = "";
        email = "";
        twoDecimal.setMaximumFractionDigits(2);
        schedule = new ArrayList<>();
        officialRecord = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Course> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Course> getOfficialRecord() {
        return officialRecord;
    }

    public void setOfficialRecord(ArrayList<Course> officialRecord) {
        this.officialRecord = officialRecord;
    }

    public boolean addCourse(Course course) {
        if(!schedule.contains(course)) {
            schedule.add(course);
        }
        return !schedule.contains(course);
    }

    public boolean removeCourse(Course course) {
        if(schedule.contains(course)) {
            schedule.remove(course);
            return true;
        }
        else {
            return false;
        }
    }

    public double calculateGPA() {
        double gradesTotal = 0;
        for (int i = 0; i < officialRecord.size(); i++) {
            gradesTotal += officialRecord.get(i).getNumberGrade();
        }
        return gradesTotal/officialRecord.size();
    }

    public void printSchedule() {
        System.out.println("Schedule:");
        for (Course course : schedule) {
            course.printCourse();
        }
    }

    public void printOfficialRecord() {
        System.out.println("Official Record:");
        for (Course course : officialRecord) {
            course.printCourse();
            System.out.println(course.getGrade());
        }
    }

    public boolean endQuarter(String[] grades) {
        if (schedule.size() != grades.length) {
            return false;
        }
        for (int i = 0; i < schedule.size(); i++) {
            Course copy = new Course(schedule.get(i));
            copy.setGrade(grades[i]);
            officialRecord.add(copy);
        }
        schedule.clear();
        return true;
    }

    public void printStudent() {
        System.out.println("ID: " + id + "\nName: " + firstName + " " + lastName + "\nAddress: " +
                address + "\n         " + city + ", " + state + " " + zip +  "\nGender: " +
                gender + "\nDate of Birth: " + DOB + "\nPhone: " + phone + "\nEmail: " + email);
    }

}