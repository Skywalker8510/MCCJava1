package Assignment8;

import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        ArrayList<Course> schedule = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        String curQuarter = "23FA";

        // comment when you want to start out blank
        exampleStarter(schedule, students);


        while (choice != 7) {
            System.out.println(" *** MCC Schedule System *** ");
            System.out.println("1. View Current Class Schedule");
            System.out.println("2. Add New Class");
            System.out.println("3. List Students");
            System.out.println("4. Add New Student");
            System.out.println("5. Manage Student Schedule");
            System.out.println("6. Change Quarter");
            System.out.println("7. Exit");
            choice = getInt(input, "Operation: ", 1, 7);

            switch (choice) {
                case 1 -> viewCurrentSchedule(schedule, curQuarter);
                case 2 -> addNewClass(input, schedule);
                case 3 -> listStudents(students);
                case 4 -> addNewStudent(input, students);
                case 5 -> manageStudentSchedule(input, schedule, students);
                case 6 -> curQuarter = changeQuarter(input, curQuarter);
            }
        }
    }

    private static void manageStudentSchedule(Scanner input, ArrayList<Course> schedule, ArrayList<Student> students) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\n ** Manage Student Schedule **");
            System.out.println("1. View Student Schedule");
            System.out.println("2. Add to Classes to Schedule.");
            System.out.println("3. Back to main menu");
            choice = getInt(input, "Operation: ", 1, 3);

            switch(choice) {
                case 1 -> {
                    System.out.print("Enter quarter to view: ");
                    String qtr = input.nextLine();

                    int count = 1;
                    for (Student s : students) {
                        System.out.println(count + ". " + s.getFirstName() + " " + s.getLastName() + " - " + s.getId());
                        count++;
                    }
                    int student = getInt(input, "Select student: ", 1, count);
                    student--; // modify off by one from print to actual location in list.

                    Student curStudent = students.get(student);

                    // print student name
                    System.out.println("\n" + curStudent.getFirstName() + " " + curStudent.getLastName() + " - " + curStudent.getId());
                    System.out.println(" * Courses *");
                    for (Course c : curStudent.getSchedule()) {
                        if (c.getQuarter().equals(qtr)) {
                            c.printCourse();
                        }
                    }
                    System.out.println();
                }
                case 2 -> addToStudentSchedule(input, schedule, students);
            }
        }
    }

    private static void viewCurrentSchedule(ArrayList<Course> schedule, String qtr) {
        System.out.println("\n ** Class Schedule **");
        for (Course c : schedule) {
            if (c.getQuarter().equals(qtr)) {
                c.printCourse();
            }
        }
        System.out.println();
    }

    private static void addNewClass(Scanner sc, ArrayList<Course> schedule) {
        System.out.println("\n ** Add New Class to Schedule **");
        System.out.print("Enter quarter: ");
        String qtr = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter course number: ");
        String crs = sc.nextLine();
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter section: ");
        String sect = sc.nextLine();
        System.out.print("Enter meeting times: ");
        String time = sc.nextLine();
        System.out.print("Enter campus: ");
        String campus = sc.nextLine();
        System.out.print("Enter instructor: ");
        String instr = sc.nextLine();

        // create and add new class
        Course newCourse = new Course(qtr, dept, crs, title, sect, time, campus, instr);
        schedule.add(newCourse);
    }

    private static void listStudents(ArrayList<Student> students) {
        System.out.println("\n ** Student List **");
        for (Student s : students) {
            s.printStudent();
            System.out.println();
        }
        System.out.println();
    }

    private static void addNewStudent(Scanner sc, ArrayList<Student> students) {
        System.out.println("\n ** Add a New Student **");
        int id = getInt(sc, "Enter student ID: ");
        System.out.print("Enter first name: ");
        String fn = sc.nextLine();
        System.out.print("Enter last name: ");
        String ln = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter city: ");
        String city = sc.nextLine();
        System.out.print("Enter state: ");
        String state = sc.nextLine();
        System.out.print("Enter zip: ");
        String zip = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter date of birth: ");
        String dob = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        // create and add new student to list
        Student newStudent = new Student(id, fn, ln, address, city, state, zip, gender, dob, phone, email);
        students.add(newStudent);
    }

    private static void addToStudentSchedule(Scanner sc, ArrayList<Course> schedule, ArrayList<Student> studentList) {
        // list off students to select
        System.out.println("\n ** Add to Student Schedule ** ");
        System.out.println(" * Student List *");
        int count = 1;
        for (Student s : studentList) {
            System.out.println(count + ". " + s.getFirstName() + " " + s.getLastName() + " - " + s.getId());
            count++;
        }
        int student = getInt(sc, "Select student: ", 1, count);
        student--; // modify off by one from print to actual location in list.

        // ask for quarter and list off classes for that quarter
        System.out.print("\nEnter quarter to add: ");
        String quarter = sc.nextLine();

        // print students current schedule?

        System.out.println("\n * Class List *");
        count = 1;
        for (Course c : schedule) {
            if (c.getQuarter().equals(quarter)) {
                System.out.print(count + ". ");
                c.printCourse();
            }
            count++; // increasing count every print so that number lines up with class in list.
        }
        int course = getInt(sc, "Select course: ", 1, count);
        course--; // off by one from print to actual location in list

        // get student from list, add class from schedule list
        if (studentList.get(student).addClass(schedule.get(course))) {
            System.out.println("\n! Course Added Successfully\n");
        }
        else {
            System.out.println("!! Error, class already in schedule\n");
        }
    }

    private static String changeQuarter(Scanner sc, String qtr) {
        System.out.println("\n ** Change Quarter ** ");
        System.out.println(" * Current Quarter: " + qtr);
        System.out.print("Enter quarter to change: ");

        System.out.println();
        return sc.nextLine();
    }

    public static int getInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("!! Error needs to be a number.");
            }
        }
    }

    public static int getInt(Scanner sc, String prompt, int min, int max) {
        int value = getInt(sc, prompt);
        while (value < min || value > max) {
            System.out.println("!! Error not a valid operation.");
            value = getInt(sc, prompt);
        }
        return value;
    }

    private static void exampleStarter(ArrayList<Course> courses, ArrayList<Student> students) {
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

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        students.add(s1);
        students.add(s2);
    }
}
