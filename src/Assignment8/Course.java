package Assignment8;
//Name: Manas Moondra
//Class: INFO 1521 Spring 2024
//Assignment: MCCJava1
//Date: 5/4/2024
//Resources: 

// Course class

public class Course {

    private String quarter;
    private String department;
    private String courseNumber;
    private String title;
    private String section;
    private String meetTime;
    private String campus;
    private String instructor;
    private String grade;

    public Course(String quarter, String department, String courseNumber, String title, String section, String meetTime, String campus, String instructor) {
        setQuarter(quarter);
        setDepartment(department);
        setCourseNumber(courseNumber);
        setTitle(title);
        setSection(section);
        setMeetTime(meetTime);
        setCampus(campus);
        setInstructor(instructor);
    }

    public Course(Course course) {
        setQuarter(course.quarter);
        setDepartment(course.department);
        setCourseNumber(course.courseNumber);
        setTitle(course.title);
        setSection(course.section);
        setMeetTime(course.meetTime);
        setCampus(course.campus);
        setInstructor(course.instructor);
    }


    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(String meetTime) {
        this.meetTime = meetTime;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getNumberGrade(String grade) {
        double numberGrade = 0.0;
        if(grade.equalsIgnoreCase("A")) {
            numberGrade = 4.0;
        }
        else if(grade.equalsIgnoreCase("B")) {
            numberGrade = 3.0;
        }
        else if(grade.equalsIgnoreCase("C")) {
            numberGrade = 2.0;
        }
        else if(grade.equalsIgnoreCase("D")) {
            numberGrade = 1.0;
        }
        else if(grade.equalsIgnoreCase("F")) {
            numberGrade = 0.0;
        }
        else {
            numberGrade = 0.0;
        }
        return numberGrade;
    }

    public void printCourse() {
        System.out.println(this.department + " " + this.courseNumber + "_" + this.section + " - " + this.title + " - " + this.meetTime + " - " + this.campus + " - " + this.instructor);
    }
}
