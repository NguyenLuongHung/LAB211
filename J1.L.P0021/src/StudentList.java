
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
        String name = "";
        String id;
        String semester;
        String course;
        // this 'next' var is used to decide if we have dont need to input name
        

        // We use this do while loop to check duplicate of student
        do {
            boolean next = true;
            do {
                System.out.print("Enter student id: ");
                id = in.nextLine();
                // If id is blank, ask user to re-input1
                if (!input.checkBlank(id)) {
                    System.out.println("Blank id, please re-input id!");
                    continue;
                }
                // If id is already existed, then ask user to re-input!

            } while (!input.checkBlank(id));

            for (int i = 0; i < student.size(); i++) {
                if (id.equalsIgnoreCase(student.get(i).id)) {
                    next = false;
                    name = student.get(i).name;
                    break;
                }
            }

            // Use do while loop to check valid name
            if (next == true) {
                do {
                    System.out.print("Enter student name: ");
                    name = in.nextLine();
                    // If name is blank, ask user to re-input name again
                    if (!input.checkBlank(name)) {
                        System.out.println("Blank name, please re-input name");
                        continue;
                    }
                    // If checkName() is false, then ask user to input name again
                    if (!input.checkName(name)) {
                        System.out.println("Invalid name, please re-input name!");
                        continue;
                    }
                    name = format.firstCharToUpper(name);
                } while (!input.checkName(name) || !input.checkBlank(name));
            }
            // Enter student semester
            // We use do while loop to check valid semester: Spring, Summer or Winter
            do {
                System.out.print("Enter student semester: ");
                semester = in.nextLine();
                // If semester is blank, ask user to re-input
                if (!input.checkBlank(semester)) {
                    System.out.println("Blank semester, please re-input semester!");
                    continue;
                }
                // If semester is not valid, ask user to re-input!
                if (!input.checkSemester(semester)) {
                    System.out.println("Invalid semester, please re-input semester "
                            + "(Spring, Summer or Winnter)");
                    continue;
                }
                semester = format.firstCharToUpper(semester);
            } while (!input.checkSemester(semester) || !input.checkBlank(semester));

            // Enter student course
            // We use do while to check valid course: C/C++, .Net, Java
            do {
                System.out.print("Enter student course: ");
                course = in.nextLine();
                // If course is blank, ask user to re-enter again
                if (!input.checkBlank(course)) {
                    System.out.println("Blank course, please re-input course!");
                    continue;
                }
                // if checkCourse() is false, then ask user to input course again
                if (!input.checkCourse(course)) {
                    System.out.println("Invalid course, please re-input course "
                            + "(C/C++, Java or .Net)");
                    continue;
                }
                course = format.firstCharToUpper(course);

            } while (!input.checkCourse(course) || !input.checkBlank(course));

            if (!input.checkDuplicateUpdating(id, semester, course, student)) {
                System.out.println("This record is already existed, please re-enter!");
            }
        } while (!input.checkDuplicateUpdating(id, semester, course, student));

        Student theStudent = new Student(id, name, semester, course);
        return theStudent;

    }
    
    List<Student> sortStudentByIDSemesterCourse(List<Student> a) {
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
                
                if (a.get(j).id.compareTo(a.get(j + 1).id) > 0) {
                    swap = a.get(j);
                    swap1 = a.get(j + 1);
                    a.remove(j);
                    a.remove(j);
                    a.add(j, swap1);
                    a.add(j + 1, swap);
                // Else if id is equal, then we have to sort by course name
                } else if (a.get(j).id.compareTo(a.get(j + 1).id) == 0) {
                    
                    if (a.get(j).course.compareTo(a.get(j + 1).course) > 0) {
                        swap = a.get(j);
                        swap1 = a.get(j + 1);
                        a.remove(j);
                        a.remove(j);
                        a.add(j, swap1);
                        a.add(j + 1, swap);
                    // Else if course is equal, then we have to sort by semester
                    } else if (a.get(j).course.compareTo(a.get(j + 1).course) == 0) {
                        if (a.get(j).semester.compareTo(a.get(j + 1).semester) > 0) {
                            swap = a.get(j);
                            swap1 = a.get(j + 1);
                            a.remove(j);
                            a.remove(j);
                            a.add(j, swap1);
                            a.add(j + 1, swap);
                        }
                    }

                }
            }
        }
        return a;
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
            if (student.get(i).name.toLowerCase().contains(name.toLowerCase())) {
                sort1.add(student.get(i));

            }
        }
        sort1 = sortStudent(sort1);
        // If sort1 is not empty then display the list
        if (!sort1.isEmpty()){
            format.display(sort1);
        }
        // Else if there isn't, then show user cant find student
        else {
            System.out.println("---------------------------");
            System.out.println("There is no such student!");
            System.out.println("---------------------------");
        }
    }
    // This function is used to find student in the list by ID

    List<Student> findByID(String id) {
        List<Student> search = new ArrayList();
        // we use this for loop to find a list of id
        for (int i = 0; i < student.size(); i++) {
            // If id is found, then return this student
            if (student.get(i).id.equals(id)) {
                search.add(student.get(i));
            }
        }
        return search;
        
    }

    // This function is used to find and update student in the list
    void update(Student e) {
        String id;
        String name = "";
        String semester;
        String course;
        // This 'check' variable is used to check if we have to create a new
        // student
        boolean check = true;

        do {
            System.out.println("Please enter following information to update: ");
            // we use do while loop to ask user to input id
            do {
                System.out.print("Enter student id: ");
                id = in.nextLine();
                // If id is blank, ask user to re-input
                if (!input.checkBlank(id)) {
                    System.out.println("Blank id, please re-input1");
                }
            } while (!input.checkBlank(id));
            // We use id to search for student name that needing to update
            // we use for loop to search
            for (int i = 0; i < student.size(); i++) {
                // If we found id, then we dont need to ask user to input name
                // Else we cant found match id, then we have to ask user to 
                // input a new name
                if (student.get(i).id.equals(id)) {
                    check = false;
                    name = student.get(i).name;
                    break;
                }
            }
            if (check == true) {
                do {
                    System.out.print("Enter student name: ");
                    name = in.nextLine();
                    // If name is blank, ask user to re-input
                    if (!input.checkBlank(name)) {
                        System.out.println("Blank name, please re-input!");
                        continue;
                    }
                    // if name is not valid, ask user to re-input
                    if (!input.checkName(name)) {
                        System.out.println("Invalid name, please re-input!");
                        continue;
                    }
                    name = format.firstCharToUpper(name);

                } while (!input.checkBlank(name) || !input.checkName(name));
            }
            // ----

            // Update student semester
            // We use do while loop to check valid semester: Spring, Summer or Winter
            do {
                System.out.print("Enter student semester: ");
                semester = in.nextLine();
                // If semester is blank, then ask user to re-input
                if (!input.checkBlank(semester)) {
                    System.out.println("Blank semester, please re-input!");
                }
                // If the semester is not spring, Summer or Winnter, then ask user to input again
                if (!input.checkSemester(semester)) {
                    System.out.println("Invalid semester, please re-input semester (Spring, Summer or Winnter)");
                    continue;
                }
                semester = format.firstCharToUpper(semester);
            } while (!input.checkSemester(semester) || !input.checkBlank(semester));

            // Update student course
            // We use do while to check valid course: C/C++, .Net, Java
            do {
                System.out.print("Enter student course: ");
                course = in.nextLine();
                // If course is blank, ask user to re-enter again
                if (!input.checkBlank(course)) {
                    System.out.println("Blank course, please re-input course!");
                    continue;
                }
                // if checkCourse() is false, then ask user to input course again
                if (!input.checkCourse(course)) {
                    System.out.println("Invalid course, please re-input course "
                            + "(C/C++, Java or .Net)");
                    continue;
                }
                course = format.firstCharToUpper(course);

            } while (!input.checkCourse(course) || !input.checkBlank(course));
            // if updated record is already existed, then we ask user to re-input again!
            if (!input.checkDuplicateUpdating(id, semester, course, student)) {
                System.out.println("Can't update, this student's course is already exists");
                // else if it's not, then we update normally
            } else {
                
                e.setId(id);
                e.setName(name);
                e.setSemester(semester);
                e.setCourse(course);
                System.out.println("Update successfully");
                break;
                

            }
        } while (!input.checkDuplicateUpdating(id, semester, course, student));
    }

    void add(Student e){
        student.add(e);
    }
    void create() {
        String check;
        do {
            student.add(input());
            // We use this do while loop to ask user if they want to continue
            // create new students
            do {

                System.out.print("Do you want to continue (Y/N): ");
                check = in.nextLine();
                // If answer is blank, ask user to re-choose!
                if (!input.checkBlank(check)) {
                    System.out.println("Blank choice, please re-choose!");
                    continue;
                }
                // Else if answer is not yes or no, ask user to re-choose
                if (!input.checkYesNo(check)) {
                    System.out.println("Invalid choice, please re-choose "
                            + "Yes(Y) or No(N) only!");
                }
            } while (!input.checkBlank(check) || !input.checkYesNo(check));
        } while (!check.equalsIgnoreCase("N"));
    }
    
    // This function is used to detele Student
    void delete(Student e) {
        student.remove(e);
        System.out.println("Delete successfully");
    }
    
    void UpdateOrDelete() {
        String id;
        List<Student> search = new ArrayList();
        do {
            System.out.print("Enter student id: ");
            id = in.nextLine();
            // If id is blank, ask user to re-input1
            if (!input.checkBlank(id)) {
                System.out.println("Blank id, please re-input id!");
                continue;
            }
        } while (!input.checkBlank(id));
        // We find students and store in to 'search' list
        search = findByID(id);
        // If there's no student, then show user there's no student
        if (search.isEmpty()){
            System.out.println("-----------------------------");
            System.out.println("There is not student with id: " + id);
            System.out.println("-----------------------------");
        }
        // Else if it, then display list of found student and ask user choose one to 
        // update or delete
        else {
            // this check is used to ask user if they want to update to delete
            String check;
            String index;
            int index1 = -1;
            format.displayFound(search);
            do {
                System.out.print("Choose one item to update: ");
                index = in.nextLine();
                // if item is blank, ask user to re-choose
                if (!input.checkBlank(index)){
                    System.out.println("Blank item, please choose again!");
                    continue;
                }
                // If item is invalid, ask user to re-choose
                if (!input.checkNumberFormat(index)){
                    System.out.println("Invalid item, please choose again!");
                    continue;
                }
                
                index1 = Integer.parseInt(index) - 1;
                // If item is not in the list, ask user to re-choose
                if (!input.checkItem(search, index1)){
                    System.out.println("Item is not the list, please choose again!");
                }
                
            } while ( !input.checkBlank(index) 
                    || !input.checkNumberFormat(index) 
                    || !input.checkItem(search, index1));
            
            do {
                System.out.print("Do you want to update(U) or delete(D): ");
                check = in.nextLine();
                // if check is blank, the ask user to choose again
                if (!input.checkBlank(check)){
                    System.out.println("Blank answer, please choose again!");
                    continue;
                }
                // else choice is invalid, then ask user to choose again!
                if (!input.updateOrDelete(check)){
                    System.out.println("Ivalid choice, please choose again "
                            + "Update(U) or Delete(D) only!");
                }
            } while (!input.checkBlank(check) || !input.updateOrDelete(check));
            
            if (check.equalsIgnoreCase("U")){
                System.out.println("The current list is: ");
                format.display(student);
                update(search.get(index1));
                System.out.println("New list: ");
                format.display(student);
            }
            else {
                delete(search.get(index1));
            }
            
        }
        
    }
    
    List<Report> report() {
        int index = 0;

        List<Student> studentList = student;
        List<Report> report = new ArrayList();
        // First we sort student list by Following attributes:
        // ID -> Course -> Semester
        studentList = sortStudentByIDSemesterCourse(studentList);
        
        // We use this for loop to find courses of a student
        for (int i = 0; i < studentList.size(); i++) {
            // If this is the first record, then add it to the report
            if (i == 0) {
                report.add(new Report(studentList.get(0).name
                        , studentList.get(0).course, 1));

            }
            // We use this for loop to check if succesive record has the same id
            // and the same course as the previous record
            for (int j = i + 1; j < studentList.size(); j++) {
                // If it's, then we add one in the total of the previous record
                if ((studentList.get(i).id.equals(studentList.get(j).id))
                        && (studentList.get(i).course.equalsIgnoreCase(studentList.get(j).course))) {
                    report.get(index).setTotal(report.get(index).getTotal() + 1);
                // Else if it's not, then we create a new report form and add 
                // to report list with total = 1
                } else {
                    report.add(new Report(studentList.get(j).name
                            , studentList.get(j).course, 1));
                    index++;
                    i = j-1;
                    break;
                }

            }
        }
        return report;
    }
    
}
