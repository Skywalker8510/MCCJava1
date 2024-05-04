package Assignment8;

/** Author:  Lucas Hartman
 *  Class:  INFO 1521 - Java 1
 *  Version 1.0.0
 *
 *  Purpose:  This file is a tester for Assignment 8 on the Student system. Use this to
 *            test your code.  The output from this file should match what is shown in the
 *            assignment page on canvas.  If something is off, modify your files as needed
 *
 *  ***********************    DO NOT MODIFY ******************************
 */

public class A8StudentChecker {

    public static void main(String[] args)
    {

        Course c1 = new Course("23FA", "INFO", "1521", "Java I Programming",
                "WW", "Online", "Online", "O. Kenobi");
        Course c2 = new Course("23FA", "INFO", "1003", "Problem Solving and Programming",
                "4A", "MW - 10:00am - 11:45am", "Fort Omaha", "O. Kenobi");
        Course c3 = new Course("23FA", "INFO", "2800", "IT Ethics",
                "WA", "Online", "Online", "M. Yoda");

        Student s1 = new Student(46739, "Leia", "Organa", "6523 Senate St.",
                "Aldera", "Alderaan", "87694", "Female", "08/01/1973", "411-659-859*6",
                "lorgana@mail.mccneb.edu");

        Student s2 = new Student(46739, "Luke", "Skywalker", "345 Wasteland Desert",
                "Outskirts", "Tatooine", "87694", "Male", "08/01/1973", "758-985-7584",
                "lskywalker@mail.mccneb.edu");

        System.out.println(" ***** Assignment 8 Student Checker ***** \n");

        System.out.println ("*** Initial Student Printout ***");
        s1.printStudent();
        s1.printSchedule();
        System.out.println();
        s2.printStudent();
        s2.printSchedule();

        s1.addClass(c1);
        s1.addClass(c2);
        s1.addClass(c3);
        s1.addClass(c1); // checks to make sure adding class again doesn't work.

        s2.addClass(c1);
        s2.addClass(c2);

        System.out.println("\n\n*** Classes added to Schedule***");
        s1.printStudent();
        s1.printSchedule();
        System.out.println();
        s2.printStudent();
        s2.printSchedule();

        System.out.println("\n\n*** Remove Classes ***");
        s1.removeClass(c1);
        s1.removeClass(c1); // remove a class that isn't there
        s1.printStudent();
        s1.printSchedule();

        if (s1.endQuarter(new String[] {"B"})) {
            System.out.println("Quarter Ended Successfully for " + s1.getFirstName());
            System.out.println("^^^ The above shouldn't print out. ^^^");
        }

        if (s1.endQuarter(new String[] {"B", "C"})) {
            System.out.println("Quarter Ended Successfully for " + s1.getFirstName());
        }

        if (s2.endQuarter(new String[] {"A", "A"})) {
            System.out.println("Quarter Ended Successfully for " + s2.getFirstName());
        }

        System.out.println("\n\n*** Official Record and GPA of students ***");
        System.out.println(s1.getFirstName() + ": \nGPA: " + s1.calculateGPA());
        s1.printOfficialRecord();
        System.out.println();

        System.out.println(s2.getFirstName() + ": \nGPA: " + s2.calculateGPA());
        s2.printOfficialRecord();
    }
}
// **********************   DO NOT MODIFY ***************************