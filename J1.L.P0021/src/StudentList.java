
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentList {

    // Create list of student
    List<Student> student = new ArrayList();
    Scanner in = new Scanner(System.in);
    Input input = new Input();
    Format format = new Format();

    // Function to return the size of student list
    int size() {
        return student.size();
    }

    // Add new student to the list
    Student input() {
        int total = 0;
        String name;
        String id;
        String semester;
        String course;

        // We use this do while loop to check duplicate of student
        do {
            System.out.print("Enter student id: ");
            id = in.nextLine();
            if (!input.checkDuplicateByID(id, student)) {
                System.out.println("This id is already exist, please re-input");
            }
        } while (!input.checkDuplicateByID(id, student));

        // Use do while loop to check valid name
        do {
            System.out.print("Enter student name: ");
            name = in.nextLine();
            // If checkName() is false, then ask user to input name again
            if (!input.checkName(name)) {
                System.out.println("Invalid name, please re-input!");
            }
        } while (!input.checkName(name));

        // Enter student semester
        // We use do while loop to check valid semester: Spring, Summer or Winter
        do {
            System.out.print("Enter student semester: ");
            semester = in.nextLine();
            semester = format.firstCharToUpper(semester);
            if (!input.checkSemester(semester)) {
                System.out.println("Invalid semester, please re-input semester (Spring, Summer or Winnter)");
            }
        } while (!input.checkSemester(semester));

        // Enter student course
        // We use do while to check valid course: C/C++, .Net, Java
        do {
            System.out.print("Enter student course: ");
            course = in.nextLine();
            course = format.firstCharToUpper(course);
            // if checkCourse() is false, then ask user to input course again
            if (!input.checkCourse(course)) {
                System.out.println("Invalid course, please re-input course (C/C++, Java or .Net)");
            }
        } while (!input.checkCourse(course));

        Student theStudent = new Student(id, name, semester, course);
        return theStudent;

    }

    void add() {
        student.add(input());
    }

    // We use this function to sort asc list of student by name
    List<Student> sortStudent(List<Student> a) {
        Student swap = null;
        Student swap1 = null;

        // Here we use bubble sort algorithm
        // For example: we have a list of students:  walter, hung, khanh, anh
        // After first loop, the list becomes: hung, khanh, anh, walter
        // After second loop, the list becomes: hung, anh, khanh, walter
        // After third loop, the list becomes: anh, hung, khanh, walter
        for (int i = a.size(); i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                // If this name is after the nxt name, then we swap theirs position
                // by deleting them and add them in opposite order
                if (a.get(j).name.compareTo(a.get(j + 1).name) > 0) {
                    swap = a.get(j);
                    swap1 = a.get(j + 1);
                    a.remove(j);
                    a.remove(j);
                    a.add(j, swap1);
                    a.add(j + 1, swap);
                }
            }
        }
        return a;
    }

    // This function is used to find student in the list
    void find() {
        List<Student> sort1 = new ArrayList();
        String name;
        System.out.print("Enter student name that you want to find: ");
        name = in.nextLine();
        // We use this loop to find students containing "name" that we want to find
        for (int i = 0; i < student.size(); i++) {
            // If name is found, then add to the list sort1 list
            if (student.get(i).name.contains(name)) {
                sort1.add(student.get(i));

            }
        }
    }
    // This function is used to find student in the list by ID

    Student findByID() {
        System.out.print("Enter student id that you want to find: ");
        String id = in.nextLine();
        // We use this for loop to find students containing "id" that we want to find
        for (int i = 0; i < student.size(); i++) {
            // If id is found, then return this student
            if (student.get(i).id.equals(id)) {
                return student.get(i);
            }
        }
        return null;
    }

    // This function is used to find and update student in the list
    void update() {
        String id;
        String name = "";
        String semester;
        String course;

        do {
            System.out.println("Please enter following information to update: ");
            // Update student id
            System.out.print("Enter student id: ");
            id = in.nextLine();

            // Update student name
            for (int i = 0; i < student.size(); i++) {
                if (student.get(i).id.equals(id)) {
                    name = student.get(i).name;
                }
            }

            // Update student semester
            // We use do while loop to check valid semester: Spring, Summer or Winter
            do {
                System.out.print("Enter student semester: ");
                semester = in.nextLine();
                semester = format.firstCharToUpper(semester);
                // If the semester is not spring, Summer or Winnter, then ask user to input again
                if (!input.checkSemester(semester)) {
                    System.out.println("Invalid semester, please re-input semester (Spring, Summer or Winnter)");
                }
            } while (!input.checkSemester(semester));

            // Update student course
            // We use do while to check valid course: C/C++, .Net, Java
            do {
                System.out.print("Enter student course: ");
                course = in.nextLine();
                course = format.firstCharToUpper(course);
                // if checkCourse() is false, then ask user to input course again
                if (!input.checkCourse(course)) {
                    System.out.println("Invalid course, please re-input course (C/C++, Java or .Net)");
                }
            } while (!input.checkCourse(course));

            if (!input.checkDuplicateUpdating(id, semester, course, student)) {
                System.out.println("Can't update, this student's course is already exists");
            } else {
                student.add(new Student(id, name, semester, course));
            }
        } while (!input.checkDuplicateUpdating(id, semester, course, student));
    }

    void delete(Student e) {
        student.remove(e);
    }

    void report(){
        format.report(student);
    }

}
