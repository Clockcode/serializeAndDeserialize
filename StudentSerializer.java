import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentSerializer {
    private static ArrayList<Student> studentArrayList;
    private static int stdID;
    private static String firstName;
    private static String lastName;
    private static ArrayList<String> courses;
    private static Scanner sc;
    final static String filename = "output.out";

    public static void main(String[] args) {
        studentArrayList = new ArrayList<Student>();
        System.out.println("Enter students!");
        addStudents();
        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(studentArrayList);
            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

    }

    public static void addStudents() {
        boolean isMore = true;
        sc = new Scanner(System.in);
        while (isMore == true) {
            setStudentID();
            setName();
            setCourses();
            studentArrayList.add(new Student(stdID, firstName, lastName, courses));
            isMore = isMore(isMore);
        }
        sc.close();
    }

    public static void setCourses() {
        courses = new ArrayList<String>();
        String stringCourses;
        System.out.println("Enter Student Courses (Seperated by space)");
        stringCourses = sc.nextLine();

        for (String course : stringCourses.split(" ")) {
            if (!course.isEmpty()) {
                courses.add(course);
            }
        }
        
    }

    public static boolean isMore(boolean isMore) {
        boolean done = false;
        char choice;
        System.out.println("Want to add another one? (y/n)");
        do {
            choice = sc.next().charAt(0);
            sc.nextLine();
            if (choice == 'y' || choice == 'Y') {
                isMore = true;
                done = true;
            } else if (choice == 'n' || choice == 'N') {
                isMore = false;
                done = true;
            } else {
                System.out.println("Only y or n");
            }
        } while (done == false);
        return isMore;
    }

    public static void setStudentID() {
        boolean isTrue = true;
        do {
            System.out.println("Enter Student ID");
            try {
                isTrue = true;
                stdID = Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Student ID has to be an integer!");
                isTrue = false;
            }
        } while (isTrue == false);
        
    }

    public static void setName() {
        
        System.out.println("Enter Student Firstname");
        firstName = sc.nextLine();
        System.out.println("Enter Student Lastname");
        lastName = sc.nextLine();
        
    }
}